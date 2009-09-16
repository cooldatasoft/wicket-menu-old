package com.cooldatasoft.menu01;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.model.Model;

import com.cooldatasoft.common.MenuItem;

public class Menu01 extends Panel implements IHeaderContributor {
	
	ResourceReference CSS_PATH = new CompressedResourceReference(Menu01.class,"css/style.css");
	ContextImage bgLeft = new ContextImage("bgLeft",new Model( "resources/com.cooldatasoft.menu01.Menu01/images/nav-bg-l.jpg"));
	ContextImage bgRight = new ContextImage("bgRight",new Model( "resources/com.cooldatasoft.menu01.Menu01/images/nav-bg-r.jpg"));
	
	public Menu01(String id, List<MenuItem> menuItemList) {
		super(id);
		
		bgLeft.add(new AttributeModifier("class",new Model("float-left")));
		bgRight.add(new AttributeModifier("class",new Model("float-right")));
		   
		add(bgLeft);
		add(bgRight);
		
//		ListView menuView = new ListView("menuLinkList", menuListOfLinkList) {
//			int itemCount = 0;
//
//			public void populateItem(final ListItem item) {
//				
//				final LinkInfo linkInfo = ((List<LinkInfo>) item.getModelObject()).get(0);
//				Link link = new Link("menuLink") {
//					@Override
//					public void onClick() {
//						if (linkInfo.getResponsePage() != null) {
//							setResponsePage(linkInfo.getResponsePage());
//						}
//					}
//				};
//
//				// Adding submenu to menu item
//				link.add(new AttributeModifier("rel", true, new Model("dropmenu" + itemCount)));
//				setNumberOfMenu(itemCount++);
//
//				Label linkText = new Label("linkText", linkInfo.getLinkText());
//				linkText.setRenderBodyOnly(true);
//				link.add(linkText);
//				item.add(link);
//			}
//		};
	}

	@Override
	public void renderHead(IHeaderResponse container) {
        container.renderCSSReference(CSS_PATH);
	}
}
