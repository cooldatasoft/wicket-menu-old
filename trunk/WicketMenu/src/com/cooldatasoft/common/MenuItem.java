package com.cooldatasoft.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;

public class MenuItem {

	private String text;
	private WebPage destinationPage;
	private List<MenuItem> subMenuItemList;
	private boolean seperator = false;
	private boolean title = false;
	

	public MenuItem(boolean seperator){
		setSeperator(true);
	}
	public MenuItem(String title){
		setTitle(true);
		setText(title);
	}
	public <T extends WebPage>MenuItem(String linkText, T destinationPage) {
		setText(linkText);
		setDestinationPage(destinationPage);
		setSubMenuItemList(new ArrayList<MenuItem>());
	}
	public MenuItem(String linkText, Class<? extends WebPage> destinationWebPage,List<MenuItem> subMenuItemList) throws InstantiationException, IllegalAccessException {
		this(linkText,destinationWebPage.newInstance(),subMenuItemList);
	}
	public <T extends WebPage>MenuItem(String linkText, T destinationPage,List<MenuItem> subMenuItemList) {
		setText(linkText);
		setDestinationPage(destinationPage);
		setSubMenuItemList(subMenuItemList);
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
	public boolean isSeperator() {
		return seperator;
	}
	public void setSeperator(boolean seperator) {
		this.seperator = seperator;
	}
	public boolean isTitle() {
		return title;
	}
	public void setTitle(boolean title) {
		this.title = title;
	}
}
