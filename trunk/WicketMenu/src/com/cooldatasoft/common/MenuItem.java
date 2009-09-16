package com.cooldatasoft.common;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;

public class MenuItem {

	private String linkText;
	private WebPage destinationPage;
	private List<MenuItem> subMenuItemList;
	

	public <T extends WebPage>MenuItem(String linkText, T destinationPage) {
		setLinkText(linkText);
		setDestinationPage(destinationPage);
	}
	public MenuItem(String linkText, Class<? extends WebPage> destinationWebPage,List<MenuItem> subMenuItemList) throws InstantiationException, IllegalAccessException {
		this(linkText,destinationWebPage.newInstance(),subMenuItemList);
	}
	public <T extends WebPage>MenuItem(String linkText, T destinationPage,List<MenuItem> subMenuItemList) {
		setLinkText(linkText);
		setDestinationPage(destinationPage);
		setSubMenuItemList(subMenuItemList);
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
	public <T extends WebPage> void setDestinationPage(T destinationPage) {
		this.destinationPage = destinationPage;
	}
	public List<MenuItem> getSubMenuItemList() {
		return subMenuItemList;
	}
	public void setSubMenuItemList(List<MenuItem> subMenuItemList) {
		this.subMenuItemList = subMenuItemList;
	}
}
