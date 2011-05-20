package com.cooldatasoft.page;

import org.apache.wicket.markup.html.link.Link;

import com.cooldatasoft.app.BasePage;

public class Index extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4519957423656132736L;

	public Index() {
		add(getDemoPageLink("sunriseGlossDropDownMenuLink",SunriseGlossDropDownMenuDemo.class));
		add(getDemoPageLink("chromeDropDownMenuLink",ChromeDropDownMenuDemo.class));
		add(getDemoPageLink("slideInMenuLink",SlideInMenuDemo.class));
		add(getDemoPageLink("multiLevelCssMenuLink",MultiLevelCssMenuDemo.class));
	}
	
	private <T extends BasePage> Link<T> getDemoPageLink(String wicketId, final Class<T> demoPage) {
		return new Link<T>(wicketId){
			private static final long serialVersionUID = 470307033803001707L;
			public void onClick() {
				setResponsePage(demoPage);
			}
		};
	}
}
