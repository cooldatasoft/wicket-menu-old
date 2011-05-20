package com.cooldatasoft.horizontal.dropdown.multiLevelCss;

import java.util.List;

import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import com.cooldatasoft.common.DestinationType;
import com.cooldatasoft.common.MenuItem;
/**
 * http://www.dynamicdrive.com/style/csslibrary/item/jquery_multi_level_css_menu_2/
 * @author fucar
 *
 */
public class MultiLevelCssMenu extends Panel implements IHeaderContributor {

	private ResourceReference SHORTCUTS_CSS = new CssResourceReference(MultiLevelCssMenu.class,"css/MultiLevelCssMenu.css");
	private ResourceReference SHORTCUTS_JAVASCRIPT = new JavaScriptResourceReference(MultiLevelCssMenu.class,"js/jqueryMin.js");
	private ResourceReference SHORTCUTS_JAVASCRIPT2 = new JavaScriptResourceReference(MultiLevelCssMenu.class,"js/MultiLevelCssMenu.js");
	
	public MultiLevelCssMenu(String id, List<MenuItem> menuItemList) {
		super(id);
		//TODO
		setRenderBodyOnly(true);
		MultiLevelMenu multiLevelMenu = new MultiLevelMenu("multiLevelMenu",menuItemList);
		multiLevelMenu.setRenderBodyOnly(true);
		add(multiLevelMenu);
	}
	
	
	
	@Override
	public void renderHead(IHeaderResponse response) {
		response.renderCSSReference(SHORTCUTS_CSS);
		response.renderJavaScriptReference(SHORTCUTS_JAVASCRIPT);
		response.renderJavaScriptReference(SHORTCUTS_JAVASCRIPT2);		 
	}

	
	private void processResponse(MenuItem menuItem){
		switch(menuItem.getDestinationType()){
			case DestinationType.EXTERNAL_LINK:	
				//forward to external link
				break;
			case DestinationType.WEB_PAGE_CLASS:
				setResponsePage(menuItem.getResponsePageClass());
				break;
			case DestinationType.WEB_PAGE_INSTANCE:
				setResponsePage(menuItem.getResponsePage());
				break;
			case DestinationType.NONE:
				//TODO throw exception 
				break;
		}
	}
	
	class MultiLevelMenu extends Panel {

		public MultiLevelMenu(String id,List<MenuItem> menuItemList) {
			super(id);
			if(menuItemList==null || menuItemList.size()==0) {
				return;
			}
			ListView menu = buildMultiLevelMenu("menuList", menuItemList);
			menu.setReuseItems(true);
			add(menu);
		}	
		
		private ListView buildMultiLevelMenu(String id,List<MenuItem> menuItemList) {
			return new ListView(id, menuItemList) {			
				public void populateItem(final ListItem item) {
					final MenuItem menuItem = ((MenuItem) item.getModelObject());
					Link link = new Link("menuLink") {
						@Override
						public void onClick() {
							if (menuItem!=null ) {
								processResponse(menuItem);
							}
						}
					};
					
					Label linkText = new Label("menuLinkText", menuItem.getMenuText());
					linkText.setRenderBodyOnly(true);
					link.add(linkText);
					item.add(link);
					
					
					List<MenuItem> submenuItemList = menuItem.getSubMenuItemList();
					//INFO If submenu exists, output it to html. If not, add empty markup container and hide it.
					if(submenuItemList != null && submenuItemList.size()>0) {
						MultiLevelMenu subLevelMenu = new MultiLevelMenu("submenuListContainer",submenuItemList);
						subLevelMenu.setRenderBodyOnly(true);
						item.add(subLevelMenu);
					}else {
						WebMarkupContainer submenuMarkupContainer = new WebMarkupContainer("submenuListContainer");
						submenuMarkupContainer.setRenderBodyOnly(true);
						item.add(submenuMarkupContainer);
					}
				}
			};
		}
	}
}




















