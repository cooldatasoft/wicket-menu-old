package com.cooldatasoft.app;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import com.cooldatasoft.page.Index;

public class WicketMenuDemoApplication extends WebApplication {

	@Override
	public Class<? extends WebPage> getHomePage() {
		return Index.class;
	}

	@Override
	protected void init() {
		super.init();
		getMarkupSettings().setStripWicketTags(true);
	}
	
	

}
