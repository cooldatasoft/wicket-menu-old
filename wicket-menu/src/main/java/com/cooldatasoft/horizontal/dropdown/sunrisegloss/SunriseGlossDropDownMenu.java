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
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import com.cooldatasoft.common.DestinationType;
import com.cooldatasoft.common.MenuItem;
import com.cooldatasoft.common.StaticImage;

public class SunriseGlossDropDownMenu extends Panel implements IHeaderContributor {
	
	private static final long serialVersionUID = 8698968844637387754L;
	
	private final ResourceReference CSS_PATH = new CssResourceReference(SunriseGlossDropDownMenu.class,"css/SunriseGloss.css");
	private final ResourceReference bgLeft = new PackageResourceReference(SunriseGlossDropDownMenu.class,"images/nav-bg-l.jpg");
	private final ResourceReference bgRight = new PackageResourceReference(SunriseGlossDropDownMenu.class,"images/nav-bg-r.jpg");
	
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
			default:
				//TODO Throw new exception
				throw new RuntimeException("Destination type not valid!");
		}
	}
	
	public SunriseGlossDropDownMenu(String id, List<MenuItem> menuItemList) {
		super(id);
		
		StaticImage bgLeftImage = new StaticImage("bgLeft", new Model<String>( RequestCycle.get().urlFor(bgLeft,null).toString()));
		StaticImage bgRightImage = new StaticImage("bgRight", new Model<String>( RequestCycle.get().urlFor(bgRight,null).toString()));
		
		bgLeftImage.add(new AttributeModifier("class",true,new Model<String>("float-left")));
		bgRightImage.add(new AttributeModifier("class",true,new Model<String>("float-right")));
		   
		add(bgLeftImage);
		add(bgRightImage);
		
		
		ListView<MenuItem> primaryMenuListView = new ListView<MenuItem>("menuItem",menuItemList){
			/**
			 * 
			 */
			private static final long serialVersionUID = -6244245389232575173L;

			@Override
			protected void populateItem(ListItem<MenuItem> item) {
				final MenuItem menuItem = (MenuItem) item.getModelObject();
				
				Link<MenuItem> link = new Link<MenuItem>("menuLink") {
					/**
					 * 
					 */
					private static final long serialVersionUID = -9163180393954821969L;

					@Override
					public void onClick() {
						if (menuItem != null ) {
							processResponse(menuItem);														
						}
					}
				};
				Label seperator = new Label("menuSeperator");
				seperator.add(new AttributeModifier("class",true,new Model<String>("divider divider-vert")));
				
				Label linkText = new Label("linkText");
				link.add(new AttributeModifier("class",true,new Model<String>("item-primary")));
				
				if(menuItem!=null && menuItem.getMenuText()!=null && !menuItem.isSeperator()){
					linkText.setDefaultModel(new Model<String>(menuItem.getMenuText()));
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
				ListView<MenuItem> subMenuListView = new ListView<MenuItem>("subMenuItem",subMenuList){
					/**
					 * 
					 */
					private static final long serialVersionUID = -2371408396442359366L;

					@Override
					protected void populateItem(ListItem<MenuItem> item) {
						final MenuItem subMenuItem = (MenuItem) item.getModelObject();
						
						Link<MenuItem> subMenuLink = new Link<MenuItem>("subMenuLink") {
							/**
							 * 
							 */
							private static final long serialVersionUID = 7343227367644127834L;

							@Override
							public void onClick() {
								if (subMenuItem != null) {
									processResponse(subMenuItem);
								}
							}
						};
						Label subMenuSeperatorOrSecondaryTitle = new Label("subMenuSeperatorOrSecondaryTitle");
						if(subMenuItem.isSeperator()){						
							subMenuSeperatorOrSecondaryTitle.add(new AttributeModifier("class",true,new Model<String>("divider divider-horiz")));
						}else if(subMenuItem.isSubmenuTitle()){
							subMenuSeperatorOrSecondaryTitle.add(new AttributeModifier("class",true,new Model<String>("item-secondary-title")));
							subMenuSeperatorOrSecondaryTitle.setDefaultModel(new Model<String>(subMenuItem.getMenuText()));
						}						
						Label subMenuLinkText = new Label("subMenuLinkText");						
						if(subMenuItem!=null && subMenuItem.getMenuText()!=null && !subMenuItem.isSeperator()){
							subMenuLinkText.setDefaultModel(new Model<String>(subMenuItem.getMenuText()));
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
