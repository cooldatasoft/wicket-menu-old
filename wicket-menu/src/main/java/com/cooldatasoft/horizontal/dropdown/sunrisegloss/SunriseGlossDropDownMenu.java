package com.cooldatasoft.horizontal.dropdown.sunrisegloss;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

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

/**
 * http://www.cssmenumaker.com/builder/menu_info.php?menu=003
 * 
 * @author Fatih Mehmet UCAR - fmucar@gmail.com
 * 
 */
@Slf4j
public class SunriseGlossDropDownMenu extends Panel implements
		IHeaderContributor {

	private static final long serialVersionUID = 1L;

	private final static ResourceReference CSS_PATH = new CssResourceReference(
			SunriseGlossDropDownMenu.class, "css/SunriseGloss.css");
	private final static ResourceReference BG_LEFT_IMG = new PackageResourceReference(
			SunriseGlossDropDownMenu.class, "images/nav-bg-l.jpg");
	private final static ResourceReference BG_RIGHT_IMG = new PackageResourceReference(
			SunriseGlossDropDownMenu.class, "images/nav-bg-r.jpg");

	@Override
	public void renderHead(IHeaderResponse container) {
		container.renderCSSReference(CSS_PATH);
	}

	public void processResponse(MenuItem menuItem) {
		switch (menuItem.getDestinationType()) {
		case EXTERNAL_LINK:
			// TODO forward to external link
			menuItem.getExternalLink();
			break;
		case WEB_PAGE_CLASS:
			setResponsePage(menuItem.getResponsePageClass());
			break;
		case WEB_PAGE_INSTANCE:
			setResponsePage(menuItem.getResponsePage());
			break;
		case AJAX_TARGET:
			// DO Nothing as ajax will execute
			break;
		case NONE:
			break;
		default:
			// TODO Throw new exception
			throw new RuntimeException("Destination type not valid!");
		}
	}

	public SunriseGlossDropDownMenu(String id, List<MenuItem> menuItemList) {
		super(id);

		String bgLeftImgPath = RequestCycle.get().urlFor(BG_LEFT_IMG, null)
				.toString();
		String bgRightImgPath = RequestCycle.get().urlFor(BG_RIGHT_IMG, null)
				.toString();

		log.debug("bgLeftImg : {} ", bgLeftImgPath);
		log.debug("bgRightImg : {} ", bgRightImgPath);

		StaticImage bgLeftImage = new StaticImage("bgLeft", new Model<String>(
				bgLeftImgPath));
		StaticImage bgRightImage = new StaticImage("bgRight",
				new Model<String>(bgRightImgPath));

		bgLeftImage.add(new AttributeModifier("class", new Model<String>(
				"float-left")));
		bgRightImage.add(new AttributeModifier("class", new Model<String>(
				"float-right")));

		add(bgLeftImage);
		add(bgRightImage);

		ListView<MenuItem> primaryMenuListView = new ListView<MenuItem>(
				"menuItem", menuItemList) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<MenuItem> item) {
				final MenuItem menuItem = (MenuItem) item.getModelObject();

				Link<MenuItem> link = null;
				
				if(DestinationType.AJAX_TARGET == menuItem.getDestinationType()){
					if("menuLink".equals(menuItem.getAjaxLink().getId())){
						throw new RuntimeException("MenuLink needs to have menuLink as wicket id!");
					}
					link = menuItem.getAjaxLink();
				}else{
					link = new Link<MenuItem>("menuLink") {
						private static final long serialVersionUID = 1L;
						@Override
						public void onClick() {
							if (menuItem != null) {
								processResponse(menuItem);
							}
						}
					};
				}
				
				
				Label seperator = new Label("menuSeperator");
				seperator.add(new AttributeModifier("class", new Model<String>(
						"divider divider-vert")));

				Label linkText = new Label("linkText");
				link.add(new AttributeModifier("class", new Model<String>(
						"item-primary")));

				if (menuItem != null && menuItem.getMenuText() != null
						&& !menuItem.isSeperator()) {
					linkText.setDefaultModel(new Model<String>(menuItem
							.getMenuText()));
					linkText.setRenderBodyOnly(true);
				}
				link.add(linkText);
				if (menuItem.isSeperator()) {
					link.setVisible(false);
				} else {
					seperator.setVisible(false);
				}

				WebMarkupContainer subMenuListContainer = new WebMarkupContainer(
						"subMenuListContainer");
				List<MenuItem> subMenuList = new ArrayList<MenuItem>();
				if (menuItem.getSubMenuItemList() != null) {
					subMenuList = menuItem.getSubMenuItemList();
				}
				ListView<MenuItem> subMenuListView = new ListView<MenuItem>(
						"subMenuItem", subMenuList) {
					private static final long serialVersionUID = 1L;

					@Override
					protected void populateItem(ListItem<MenuItem> item) {
						final MenuItem subMenuItem = (MenuItem) item
								.getModelObject();

						Link<MenuItem> subMenuLink = null;
						
						if(DestinationType.AJAX_TARGET == menuItem.getDestinationType()){
							if(!"subMenuLink".equals(menuItem.getAjaxLink().getId())){
								throw new RuntimeException("Needs to have id as subMenuLink");
							}
							subMenuLink = menuItem.getAjaxLink();
						}else{
							subMenuLink = new Link<MenuItem>(
									"subMenuLink") {
								private static final long serialVersionUID = 1L;

								@Override
								public void onClick() {
									if (subMenuItem != null) {
										processResponse(subMenuItem);
									}
								}
							};
						}
						
						
						
						Label subMenuSeperatorOrSecondaryTitle = new Label(
								"subMenuSeperatorOrSecondaryTitle");
						if (subMenuItem.isSeperator()) {
							subMenuSeperatorOrSecondaryTitle
									.add(new AttributeModifier("class",
											new Model<String>(
													"divider divider-horiz")));
						} else if (subMenuItem.isSubmenuTitle()) {
							subMenuSeperatorOrSecondaryTitle
									.add(new AttributeModifier("class",
											new Model<String>(
													"item-secondary-title")));
							subMenuSeperatorOrSecondaryTitle
									.setDefaultModel(new Model<String>(
											subMenuItem.getMenuText()));
						}
						Label subMenuLinkText = new Label("subMenuLinkText");
						if (subMenuItem != null
								&& subMenuItem.getMenuText() != null
								&& !subMenuItem.isSeperator()) {
							subMenuLinkText.setDefaultModel(new Model<String>(
									subMenuItem.getMenuText()));
							subMenuLinkText.setRenderBodyOnly(true);
						}
						subMenuLink.add(subMenuLinkText);
						if (subMenuItem.isSeperator()
								|| subMenuItem.isSubmenuTitle()) {
							subMenuLink.setVisible(false);
						} else {
							subMenuSeperatorOrSecondaryTitle.setVisible(false);
						}
						item.add(subMenuLink);
						item.add(subMenuSeperatorOrSecondaryTitle);
						item.add(subMenuSeperatorOrSecondaryTitle);
					}
				};
				subMenuListContainer.add(subMenuListView);
				if (menuItem != null && menuItem.getSubMenuItemList() != null
						&& menuItem.getSubMenuItemList().size() == 0) {
					subMenuListContainer.setVisible(false);
				}
				item.add(link);
				item.add(seperator);
				item.add(subMenuListContainer);
			}
		};
		add(primaryMenuListView);
	}
}
