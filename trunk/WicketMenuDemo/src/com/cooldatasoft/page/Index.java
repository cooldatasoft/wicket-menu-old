package com.cooldatasoft.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class Index extends WebPage {

	public Index() {
		Link menu01Demo = new Link("menu01Demo"){
			@Override
			public void onClick() {
				setResponsePage(Menu01Demo.class);
			}
		};
		
		add(menu01Demo);
	}
}
