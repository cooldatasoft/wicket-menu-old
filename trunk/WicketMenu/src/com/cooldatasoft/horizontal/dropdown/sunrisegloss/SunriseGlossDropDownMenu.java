package com.cooldatasoft.horizontal.dropdown.sunrisegloss;

/**
 * http://www.cssmenumaker.com/builder/menu_info.php?menu=003
 * 
 * Drop Down Menus : Sunrise Gloss
 * 
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.model.Model;

import com.cooldatasoft.common.DestinationType;
import com.cooldatasoft.common.MenuItem;

public class SunriseGlossDropDownMenu extends Panel implements IHeaderContributor {
	
	ResourceReference CSS_PATH = new CompressedResourceReference(SunriseGlossDropDownMenu.class,"css/SunriseGloss.css");
	ContextImage bgLeft = new ContextImage("bgLeft",new Model( "resources/com.cooldatasoft.horizontal.dropdown.sunrisegloss.SunriseGlossDropDownMenu/images/nav-bg-l.jpg"));
	ContextImage bgRight = new ContextImage("bgRight",new Model( "resources/com.cooldatasoft.horizontal.dropdown.sunrisegloss.SunriseGlossDropDownMenu/images/nav-bg-r.jpg"));
	
	public void processResponse(MenuItem menuItem){
		switch(menuItem.getDestinationType()){
			case DestinationType.EXTERNAL_LINK:	
				//TODO forward to external link
				menuItem.getExternalLink();
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
	
	public SunriseGlossDropDownMenu(String id, List<MenuItem> menuItemList) {
		super(id);
		
		bgLeft.add(new AttributeModifier("class",new Model("float-left")));
		bgRight.add(new AttributeModifier("class",new Model("float-right")));
		   
		add(bgLeft);
		add(bgRight);
		
		
		ListView primaryMenuListView = new ListView("menuItem",menuItemList){
			@Override
			protected void populateItem(ListItem item) {
				final MenuItem menuItem = (MenuItem) item.getModelObject();
				
				Link link = new Link("menuLink") {
					@Override
					public void onClick() {
						if (menuItem != null ) {
							processResponse(menuItem);														
						}
					}
				};
				Label seperator = new Label("menuSeperator");
				seperator.add(new AttributeModifier("class",true,new Model("divider divider-vert")));
				
				Label linkText = new Label("linkText");
				link.add(new AttributeModifier("class",true,new Model("item-primary")));
				
				if(menuItem!=null && menuItem.getMenuText()!=null && !menuItem.isSeperator()){
					linkText.setModel(new Model(menuItem.getMenuText()));
					linkText.setRenderBodyOnly(true);
				}				
				link.add(linkText);
				if(menuItem.isSeperator()){
					link.setVisible(false);
				}else{
					seperator.setVisible(false);
				}
				
				WebMarkupContainer subMenuListContainer = new WebMarkupContainer("subMenuListContainer");
				List<MenuItem> subMenuList = new ArrayList<MenuItem>();
				if(menuItem.getSubMenuItemList() != null){
					subMenuList = menuItem.getSubMenuItemList();
				}				
				ListView subMenuListView = new ListView("subMenuItem",subMenuList){
					@Override
					protected void populateItem(ListItem item) {
						final MenuItem subMenuItem = (MenuItem) item.getModelObject();
						
						Link subMenuLink = new Link("subMenuLink") {
							@Override
							public void onClick() {
								if (subMenuItem != null) {
									processResponse(subMenuItem);
								}
							}
						};
						Label subMenuSeperatorOrSecondaryTitle = new Label("subMenuSeperatorOrSecondaryTitle");
						if(subMenuItem.isSeperator()){						
							subMenuSeperatorOrSecondaryTitle.add(new AttributeModifier("class",true,new Model("divider divider-horiz")));
						}else if(subMenuItem.isSubmenuTitle()){
							subMenuSeperatorOrSecondaryTitle.add(new AttributeModifier("class",true,new Model("item-secondary-title")));
							subMenuSeperatorOrSecondaryTitle.setModel(new Model(subMenuItem.getMenuText()));
						}						
						Label subMenuLinkText = new Label("subMenuLinkText");						
						if(subMenuItem!=null && subMenuItem.getMenuText()!=null && !subMenuItem.isSeperator()){
							subMenuLinkText.setModel(new Model(subMenuItem.getMenuText()));
							subMenuLinkText.setRenderBodyOnly(true);
						}				
						subMenuLink.add(subMenuLinkText);
						if(subMenuItem.isSeperator() || subMenuItem.isSubmenuTitle()){
							subMenuLink.setVisible(false);
						}else{
							subMenuSeperatorOrSecondaryTitle.setVisible(false);
						}						
						item.add(subMenuLink);
						item.add(subMenuSeperatorOrSecondaryTitle);
						item.add(subMenuSeperatorOrSecondaryTitle);
					}
				};				
				subMenuListContainer.add(subMenuListView);
				if(menuItem!=null && menuItem.getSubMenuItemList() != null && menuItem.getSubMenuItemList().size()==0){
					subMenuListContainer.setVisible(false);
				}				
				item.add(link);
				item.add(seperator);
				item.add(subMenuListContainer);
			}
		};
		add(primaryMenuListView);
	}

	@Override
	public void renderHead(IHeaderResponse container) {
        container.renderCSSReference(CSS_PATH);
	}
}
