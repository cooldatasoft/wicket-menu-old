package com.cooldatasoft.page;

import org.apache.wicket.markup.html.link.Link;

import com.cooldatasoft.app.BasePage;

public class Index extends BasePage {

	public Index() {
		Link sunriseGlossDropDownMenuLink = new Link("sunriseGlossDropDownMenuLink"){
			@Override
			public void onClick() {
				setResponsePage(SunriseGlossDropDownMenuDemo.class);
			}
		};
		
		Link chromeDropDownMenuLink = new Link("chromeDropDownMenuLink"){
			@Override
			public void onClick() {
				setResponsePage(ChromeDropDownMenuDemo.class);
			}
		};
		
		Link slideInMenuLink = new Link("slideInLink"){
			@Override
			public void onClick() {
				setResponsePage(SlideInMenuDemo.class);
			}
		};
		
		add(sunriseGlossDropDownMenuLink);
		add(chromeDropDownMenuLink);
		add(slideInMenuLink);
	}
}
