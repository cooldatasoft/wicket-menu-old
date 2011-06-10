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
import org.apache.wicket.util.string.JavaScriptUtils;

import com.cooldatasoft.common.DestinationType;
import com.cooldatasoft.common.MenuItem;
/**
 * 
 * @author Fatih Mehmet UCAR - fmucar@gmail.com
 *
 */
public class ChromeDropDownMenu extends Panel implements IHeaderContributor {

	private static final long serialVersionUID = 1L;

	private final static ResourceReference DOWN_GIF = new PackageResourceReference(ChromeDropDownMenu.class, "images/down.gif");
	private static final ResourceReference MENU_JS= new JavaScriptResourceReference(ChromeDropDownMenu.class, "js/chrome.js");
	private final static CssResourceReference MENU_CSS_THEME1 = new CssResourceReference(ChromeDropDownMenu.class, "css/chrome1.css");
	private final static CssResourceReference MENU_CSS_THEME2 = new CssResourceReference(ChromeDropDownMenu.class, "css/chrome2.css");
	private final static CssResourceReference MENU_CSS_THEME3 = new CssResourceReference(ChromeDropDownMenu.class, "css/chrome3.css");
	private final static CssResourceReference MENU_CSS_THEME4 = new CssResourceReference(ChromeDropDownMenu.class, "css/chrome4.css");
	
	public enum CSS {
		THEME1, THEME2, THEME3, THEME4
	};
	
	private int numberOfMenu;
	private ResourceReference menuCssResourceReference;
	
	@Override
	public void renderHead(IHeaderResponse response) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("var downGifRelativeLocation='<img src=\"");
		buffer.append(RequestCycle.get().urlFor(DOWN_GIF, null));
		buffer.append("\" border=\"0\" />'; ");		

		response.getResponse().write(JavaScriptUtils.SCRIPT_OPEN_TAG);
        response.getResponse().write(buffer.toString());
        response.getResponse().write(JavaScriptUtils.SCRIPT_CLOSE_TAG); 
        
		
		response.renderJavaScriptReference(MENU_JS);
		response.renderCSSReference(menuCssResourceReference);

	}
	
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
		if (cssTheme == CSS.THEME1) {
			menuCssResourceReference = MENU_CSS_THEME1;
		} else if (cssTheme == CSS.THEME2) {
			menuCssResourceReference = MENU_CSS_THEME2;
		} else if (cssTheme == CSS.THEME3) {
			menuCssResourceReference = MENU_CSS_THEME3;
		} else if (cssTheme == CSS.THEME4) {
			menuCssResourceReference = MENU_CSS_THEME4;
		}else{
			menuCssResourceReference = MENU_CSS_THEME1;
		}

		ListView<MenuItem> chromePrimaryMenuListView = new ListView<MenuItem>("primaryMenuList", menuItemList) {

			private static final long serialVersionUID = 1L;
			int itemCount = 0;

			public void populateItem(final ListItem<MenuItem> item) {

				final MenuItem menuItem = ((MenuItem) item.getModelObject());
				Link<MenuItem> link = new Link<MenuItem>("menuLink") {
					private static final long serialVersionUID = 1L;

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
			private static final long serialVersionUID = 1L;
			int itemCount = 0;

			@Override
			public void populateItem(final ListItem<MenuItem> item) {
				MenuItem menuItem = (MenuItem) item.getModelObject();
				List<MenuItem> subMenuList = menuItem.getSubMenuItemList();

				WebMarkupContainer submenuDiv = new WebMarkupContainer("submenuDiv");
				submenuDiv.add(new AttributeModifier("id", true, new Model<String>("dropmenu" + itemCount)));

				ListView<MenuItem> submenuItem = new ListView<MenuItem>("submenuItem", subMenuList) {
					private static final long serialVersionUID = 1L;

					public void populateItem(final ListItem<MenuItem> item) {

						final MenuItem subMenuItem = (MenuItem) item.getModelObject();

						Link<MenuItem> link = new Link<MenuItem>("menuLink") {
							private static final long serialVersionUID = 1L;

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
}
