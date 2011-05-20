package com.cooldatasoft.horizontal.dropdown.chrome;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import com.cooldatasoft.common.DestinationType;
import com.cooldatasoft.common.MenuItem;

public class ChromeDropDownMenu extends Panel implements IHeaderContributor {

	private static final long serialVersionUID = -2273238307940469075L;

	private final static ResourceReference DOWN_GIF = new PackageResourceReference(ChromeDropDownMenu.class, "images/down.gif");
	
	private int numberOfMenu;
	private ResourceReference javaScriptResourceReference;
	private ResourceReference cssResourceReference;
	
	public enum CSS {
		THEME1, THEME2, THEME3, THEME4
	};

	private void processResponse(MenuItem menuItem) {
		switch (menuItem.getDestinationType()) {
		case DestinationType.EXTERNAL_LINK:
			break;
		case DestinationType.WEB_PAGE_CLASS:
			setResponsePage(menuItem.getResponsePageClass());
			break;
		case DestinationType.WEB_PAGE_INSTANCE:
			setResponsePage(menuItem.getResponsePage());
			break;
		case DestinationType.NONE:
			break;
		}
	}

	public ChromeDropDownMenu(String id, List<MenuItem> menuItemList) {
		this(id, menuItemList, CSS.THEME1);
	}

	/**
	 * http://www.dynamicdrive.com/dynamicindex1/chrome/index.htm
	 * 
	 * First element of each list is assumed to be the top menu Use ChromeMenu.CSS.THEME1-4 for different css themes
	 * 
	 * @param id
	 * @param menuListOfLinkList
	 */

	public ChromeDropDownMenu(String id, List<MenuItem> menuItemList, CSS cssTheme) {
		super(id);
		javaScriptResourceReference = new JavaScriptResourceReference(ChromeDropDownMenu.class, "js/chrome.js");
		if (cssTheme == CSS.THEME1) {
			cssResourceReference = new CssResourceReference(ChromeDropDownMenu.class, "css/chrome1.css");
		} else if (cssTheme == CSS.THEME2) {
			cssResourceReference = new CssResourceReference(ChromeDropDownMenu.class, "css/chrome2.css");
		} else if (cssTheme == CSS.THEME3) {
			cssResourceReference = new CssResourceReference(ChromeDropDownMenu.class, "css/chrome3.css");
		} else if (cssTheme == CSS.THEME4) {
			cssResourceReference = new CssResourceReference(ChromeDropDownMenu.class, "css/chrome4.css");
		}

		ListView<MenuItem> chromePrimaryMenuListView = new ListView<MenuItem>("primaryMenuList", menuItemList) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -7286734385469675250L;
			int itemCount = 0;

			public void populateItem(final ListItem<MenuItem> item) {

				final MenuItem menuItem = ((MenuItem) item.getModelObject());
				Link<MenuItem> link = new Link<MenuItem>("menuLink") {
					/**
					 * 
					 */
					private static final long serialVersionUID = 5670656306063413870L;

					@Override
					public void onClick() {
						if (menuItem != null) {
							processResponse(menuItem);
						}
					}
				};

				// Adding submenu to menu item
				link.add(new AttributeModifier("rel", true, new Model<String>("dropmenu" + itemCount)));
				setNumberOfMenu(itemCount++);

				Label linkText = new Label("linkText", menuItem.getMenuText());
				linkText.setRenderBodyOnly(true);
				link.add(linkText);
				item.add(link);
			}
		};
		chromePrimaryMenuListView.setReuseItems(true);
		add(chromePrimaryMenuListView);

		ListView<MenuItem> submenuListView = new ListView<MenuItem>("submenuList", menuItemList) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 6300774999837764921L;
			int itemCount = 0;

			@Override
			public void populateItem(final ListItem<MenuItem> item) {
				MenuItem menuItem = (MenuItem) item.getModelObject();
				List<MenuItem> subMenuList = menuItem.getSubMenuItemList();

				WebMarkupContainer submenuDiv = new WebMarkupContainer("submenuDiv");
				submenuDiv.add(new AttributeModifier("id", true, new Model<String>("dropmenu" + itemCount)));

				ListView<MenuItem> submenuItem = new ListView<MenuItem>("submenuItem", subMenuList) {
					/**
					 * 
					 */
					private static final long serialVersionUID = -1961867163230691751L;

					public void populateItem(final ListItem<MenuItem> item) {

						final MenuItem subMenuItem = (MenuItem) item.getModelObject();

						Link<MenuItem> link = new Link<MenuItem>("menuLink") {
							/**
							 * 
							 */
							private static final long serialVersionUID = 3662635374288288132L;

							@Override
							public void onClick() {
								if (subMenuItem != null) {
									processResponse(subMenuItem);
								}
							}
						};

						Label linkText = new Label("linkText", subMenuItem.getMenuText());
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

		StringBuffer buffer = new StringBuffer();
		buffer.append("<script type=\"text/javascript\" >var downGifRelativeLocation='<img src=\"");
		buffer.append(RequestCycle.get().urlFor(DOWN_GIF, null));
		buffer.append("\" border=\"0\" />';</script> ");		
		response.renderString(buffer.toString());
		
		response.renderJavaScriptReference(javaScriptResourceReference);
		response.renderCSSReference(cssResourceReference);

	}
}
