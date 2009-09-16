package com.cooldatasoft.common;

import org.apache.wicket.markup.html.WebPage;

public class PrimaryMenuItem {

	private String linkText;
	private WebPage destinationPage;
	
	public PrimaryMenuItem(String linkText, Class<? extends WebPage> destinationWebPage) throws InstantiationException, IllegalAccessException {
		this(linkText,destinationWebPage.newInstance());
	}
	public <T extends WebPage>PrimaryMenuItem(String linkText, T destinationPage) {
		setLinkText(linkText);
		setDestinationPage(destinationPage);
	}
	public String getLinkText() {
		return linkText;
	}
	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}
	public WebPage getDestinationPage() {
		return destinationPage;
	}
	public void setDestinationPage(WebPage destinationPage) {
		this.destinationPage = destinationPage;
	}
	
	
}
