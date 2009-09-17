package com.cooldatasoft.page;

import org.apache.wicket.markup.html.link.Link;

import com.cooldatasoft.app.BasePage;

public class Index extends BasePage {

	public Index() {
		Link menu01Demo = new Link("menu01Demo"){
			@Override
			public void onClick() {
				setResponsePage(SunriseGlossDropDownMenuDemo.class);
			}
		};
		
		add(menu01Demo);
	}
}
