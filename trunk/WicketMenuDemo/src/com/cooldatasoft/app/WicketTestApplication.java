package com.cooldatasoft.app;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import com.cooldatasoft.page.Index;

public class WicketTestApplication extends WebApplication {

	@Override
	public Class<? extends WebPage> getHomePage() {
		return Index.class;
	}

}
