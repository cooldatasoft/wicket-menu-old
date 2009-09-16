package com.cooldatasoft.menu01;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class Menu01 extends Panel implements IHeaderContributor {
	
	ResourceReference CSS_PATH = new CompressedResourceReference(Menu01.class,"css/style.css");
	ContextImage bgLeft = new ContextImage("bgLeft",new Model( "resources/com.cooldatasoft.menu01.Menu01/images/nav-bg-l.jpg"));
	ContextImage bgRight = new ContextImage("bgRight",new Model( "resources/com.cooldatasoft.menu01.Menu01/images/nav-bg-r.jpg"));
	
	public Menu01(String id, IModel model) {
		super(id, model);
		
		bgLeft.add(new AttributeModifier("class",new Model("float-left")));
		bgRight.add(new AttributeModifier("class",new Model("float-right")));
		   
		add(bgLeft);
		add(bgRight);
	}

	@Override
	public void renderHead(IHeaderResponse container) {
        container.renderCSSReference(CSS_PATH);
	}
}
