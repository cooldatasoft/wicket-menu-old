package com.cooldatasoft.css.horizontal.dropdown.SunriseGloss;

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

import com.cooldatasoft.common.MenuItem;

public class SunriseGlossDropDownMenu extends Panel implements IHeaderContributor {
	
	ResourceReference CSS_PATH = new CompressedResourceReference(SunriseGlossDropDownMenu.class,"css/SunriseGloss.css");
	ContextImage bgLeft = new ContextImage("bgLeft",new Model( "resources/com.cooldatasoft.css.horizontal.dropdown.SunriseGloss/images/nav-bg-l.jpg"));
	ContextImage bgRight = new ContextImage("bgRight",new Model( "resources/com.cooldatasoft.css.horizontal.dropdown.SunriseGloss/images/nav-bg-r.jpg"));
	
	
	
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
						if (menuItem != null && menuItem.getDestinationPage() != null) {
							setResponsePage(menuItem.getDestinationPage());
						}
					}
				};
				Label seperator = new Label("menuSeperator");
				seperator.add(new AttributeModifier("class",true,new Model("divider divider-vert")));
				
				Label linkText = new Label("linkText");
				link.add(new AttributeModifier("class",true,new Model("item-primary")));
				
				if(menuItem!=null && menuItem.getText()!=null && !menuItem.isSeperator()){
					linkText.setModel(new Model(menuItem.getText()));
					linkText.setRenderBodyOnly(true);
				}				
				link.add(linkText);
				if(menuItem.isSeperator()){
					link.setVisible(false);
				}else{
					seperator.setVisible(false);
				}
				
				WebMarkupContainer subMenuList = new WebMarkupContainer("subMenuList");
				if(menuItem.getSubMenuItemList() == null){
					menuItem.setSubMenuItemList(new ArrayList<MenuItem>());
				}
				
				ListView subMenuListView = new ListView("subMenuItem",menuItem.getSubMenuItemList()){
					@Override
					protected void populateItem(ListItem item) {
						final MenuItem subMenuItem = (MenuItem) item.getModelObject();
						
						Link subMenuLink = new Link("subMenuLink") {
							@Override
							public void onClick() {
								if (subMenuItem != null && subMenuItem.getDestinationPage() != null) {
									setResponsePage(subMenuItem.getDestinationPage());
								}
							}
						};
						Label subMenuSeperatorOrSecondaryTitle = new Label("subMenuSeperatorOrSecondaryTitle");
						if(subMenuItem.isSeperator()){						
							subMenuSeperatorOrSecondaryTitle.add(new AttributeModifier("class",true,new Model("divider divider-horiz")));
						}else if(subMenuItem.isTitle()){
							subMenuSeperatorOrSecondaryTitle.add(new AttributeModifier("class",true,new Model("item-secondary-title")));
							subMenuSeperatorOrSecondaryTitle.setModel(new Model(subMenuItem.getText()));
						}						
						Label subMenuLinkText = new Label("subMenuLinkText");						
						if(subMenuItem!=null && subMenuItem.getText()!=null && !subMenuItem.isSeperator()){
							subMenuLinkText.setModel(new Model(subMenuItem.getText()));
							subMenuLinkText.setRenderBodyOnly(true);
						}				
						subMenuLink.add(subMenuLinkText);
						if(subMenuItem.isSeperator() || subMenuItem.isTitle()){
							subMenuLink.setVisible(false);
						}else{
							subMenuSeperatorOrSecondaryTitle.setVisible(false);
						}						
						item.add(subMenuLink);
						item.add(subMenuSeperatorOrSecondaryTitle);
						item.add(subMenuSeperatorOrSecondaryTitle);
					}
				};				
				subMenuList.add(subMenuListView);
				if(menuItem.getSubMenuItemList().size()==0){
					subMenuList.setVisible(false);
				}				
				item.add(link);
				item.add(seperator);
				item.add(subMenuList);
			}
		};
		add(primaryMenuListView);
	}

	@Override
	public void renderHead(IHeaderResponse container) {
        container.renderCSSReference(CSS_PATH);
	}
}
