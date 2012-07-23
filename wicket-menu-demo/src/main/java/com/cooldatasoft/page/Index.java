package com.cooldatasoft.page;

import org.apache.wicket.markup.html.link.Link;

import com.cooldatasoft.app.BasePage;

public class Index extends BasePage {

	public Index() {
		add(getDemoPageLink("sunriseGlossDropDownMenuLink",SunriseGlossDropDownMenuDemo.class));
		add(getDemoPageLink("chromeDropDownMenuLink",ChromeDropDownMenuDemo.class));
		add(getDemoPageLink("slideInMenuLink",SlideInMenuDemo.class));
		add(getDemoPageLink("multiLevelCssMenuLink",MultiLevelCssMenuDemo.class));
	}
	
	private Link  getDemoPageLink(String wicketId, final Class<? extends BasePage> demoPage) {
		return new Link(wicketId){
			private static final long serialVersionUID = 470307033803001707L;
			@Override
			public void onClick() {
				setResponsePage(demoPage);
			}
		};
	}
}
