package com.cooldatasoft.css.horizontal.dropdown.chrome;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.model.Model;

import com.cooldatasoft.common.MenuItem;


public class ChromeDropDownMenu extends Panel implements IHeaderContributor {


	private int numberOfMenu;

	private ResourceReference SHORTCUTS_JAVASCRIPT;
	private ResourceReference SHORTCUTS_CSS;
	public enum CSS{THEME1,THEME2,THEME3,THEME4};
	
	
	public ChromeDropDownMenu(String id, List<MenuItem> menuItemList ) {
		this(id, menuItemList, CSS.THEME1);
	}
	/**
	 * http://www.dynamicdrive.com/dynamicindex1/chrome/index.htm
	 * 
	 * First element of each list is assumed to be the top menu
	 * Use ChromeMenu.CSS.THEME1-4 for different css themes
	 * 
	 * @param id
	 * @param menuListOfLinkList
	 */
	public ChromeDropDownMenu(String id, List<MenuItem> menuItemList, CSS cssTheme ) {
		super(id);
		
		SHORTCUTS_JAVASCRIPT = new CompressedResourceReference(ChromeDropDownMenu.class,"js/chrome.js");
		
		if(cssTheme == CSS.THEME1){
			SHORTCUTS_CSS = new CompressedResourceReference(ChromeDropDownMenu.class,"css/chrome1.css");
		}else if(cssTheme == CSS.THEME2){
			SHORTCUTS_CSS = new CompressedResourceReference(ChromeDropDownMenu.class,"css/chrome2.css");
		}else if(cssTheme == CSS.THEME3){
			SHORTCUTS_CSS = new CompressedResourceReference(ChromeDropDownMenu.class,"css/chrome3.css");
		}else if(cssTheme == CSS.THEME4){
			SHORTCUTS_CSS = new CompressedResourceReference(ChromeDropDownMenu.class,"css/chrome4.css");
		}
		
		ListView chromePrimaryMenuListView = new ListView("primaryMenuList", menuItemList) {
			int itemCount = 0;

			public void populateItem(final ListItem item) {
				
				final MenuItem menuItem = ((MenuItem) item.getModelObject());
				Link link = new Link("menuLink") {
					@Override
					public void onClick() {
						if (menuItem!=null && menuItem.getDestinationPage() != null) {
							setResponsePage(menuItem.getDestinationPage());
						}
					}
				};

				// Adding submenu to menu item
				link.add(new AttributeModifier("rel", true, new Model("dropmenu" + itemCount)));
				setNumberOfMenu(itemCount++);

				Label linkText = new Label("linkText", menuItem.getText());
				linkText.setRenderBodyOnly(true);
				link.add(linkText);
				item.add(link);
			}
		};
		chromePrimaryMenuListView.setReuseItems(true);
		add(chromePrimaryMenuListView);

		ListView submenuListView = new ListView("submenuList", menuItemList) {
			int itemCount = 0;
			@Override
			public void populateItem(final ListItem item) {
				MenuItem menuItem = (MenuItem) item.getModelObject();
				List<MenuItem> subMenuList = menuItem.getSubMenuItemList();
					
				
				WebMarkupContainer submenuDiv = new WebMarkupContainer("submenuDiv");
				submenuDiv.add(new AttributeModifier("id", true, new Model("dropmenu" + itemCount)));
				
				ListView submenuItem = new ListView("submenuItem",subMenuList) {
					public void populateItem(final ListItem item) {
						
						final MenuItem subMenuItem = (MenuItem) item.getModelObject();
						
						Link link = new Link("menuLink") {
							@Override
							public void onClick() {
								if(subMenuItem != null && subMenuItem.getDestinationPage() != null){
									setResponsePage(subMenuItem.getDestinationPage());									
								}								
							}
						};

						Label linkText = new Label("linkText", subMenuItem.getText());
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
	
	@Override
	public void renderHead(IHeaderResponse response) {
        response.renderJavascriptReference(SHORTCUTS_JAVASCRIPT);
        response.renderCSSReference(SHORTCUTS_CSS);
	}

}
