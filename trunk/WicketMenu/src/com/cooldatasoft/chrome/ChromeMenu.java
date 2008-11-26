package com.cooldatasoft.chrome;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
/**
 * 
 * @author fatih mehmet ucar
 *
 */
public class ChromeMenu extends Panel {

	private int numberOfMenu;


	/**
	 * http://www.dynamicdrive.com/dynamicindex1/chrome/index.htm
	 * 
	 * First element of each list is assumed to be the top menu
	 * @param id
	 * @param menuListOfLinkList
	 */
	public ChromeMenu(String id, final List<List<LinkInfo>> menuListOfLinkList) {
		super(id);

		ListView menuView = new ListView("menuLinkList", menuListOfLinkList) {
			int itemCount = 0;

			public void populateItem(final ListItem item) {
				
				final LinkInfo linkInfo = ((List<LinkInfo>) item.getModelObject()).get(0);
				Link link = new Link("menuLink") {
					@Override
					public void onClick() {
						if (linkInfo.getResponsePage() != null) {
							setResponsePage(linkInfo.getResponsePage());
						}
					}
				};

				// Adding submenu to menu item
				link.add(new AttributeModifier("rel", true, new Model("dropmenu" + itemCount)));
				setNumberOfMenu(itemCount++);

				Label linkText = new Label("linkText", linkInfo.getLinkText());
				linkText.setRenderBodyOnly(true);
				link.add(linkText);
				item.add(link);
			}
		};
		menuView.setReuseItems(true);
		add(menuView);

		ListView submenuListView = new ListView("submenuList", menuListOfLinkList) {
			int itemCount = 0;
			
			public void populateItem(final ListItem item) {
				List<LinkInfo> linkInfoList = (List<LinkInfo>) item.getModelObject();
				List<LinkInfo> topMenuRemovedList = new ArrayList<LinkInfo>();
				topMenuRemovedList.addAll(linkInfoList);
				topMenuRemovedList.remove(0);
					
				
				WebMarkupContainer submenuDiv = new WebMarkupContainer("submenuDiv");
				submenuDiv.add(new AttributeModifier("id", true, new Model("dropmenu" + itemCount)));
				
				ListView submenuItem = new ListView("submenuItem",topMenuRemovedList) {
					public void populateItem(final ListItem item) {
						
						final LinkInfo linkInfo = (LinkInfo) item.getModelObject();
						
						Link link = new Link("menuLink") {
							@Override
							public void onClick() {
								setResponsePage(linkInfo.getResponsePage());
							}
						};

						Label linkText = new Label("linkText", linkInfo.getLinkText());
						linkText.setRenderBodyOnly(true);
						link.add(linkText);
						item.add(link);
						item.setRenderBodyOnly(true);
					}
				};

				submenuDiv.add(submenuItem);
				itemCount++;
				item.add(submenuDiv);
				item.setRenderBodyOnly(true);
				
			}
		};
		submenuListView.setReuseItems(true);
		add(submenuListView);
		setRenderBodyOnly(true);
	}


	public int getNumberOfMenu() {
		return numberOfMenu;
	}


	public void setNumberOfMenu(int numberOfMenu) {
		this.numberOfMenu = numberOfMenu;
	}
}
