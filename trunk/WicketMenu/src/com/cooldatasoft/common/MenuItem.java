package com.cooldatasoft.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;

public class MenuItem {

	private int destinationType;
	private String menuText;
	private Class<? extends WebPage> responsePageClass;
	private WebPage responsePage;
	private String externalLink;
	
	private List<MenuItem> subMenuItemList;
	private boolean seperator = false;
	private boolean submenuTitle = false;
	
	
	public MenuItem(boolean seperator){
		setSeperator(true);
		setDestinationType(DestinationType.NONE);
	}
	public MenuItem(String submenuTitle){
		setSubmenuTitleTitle(true);
		setMenuText(submenuTitle);
		setDestinationType(DestinationType.NONE);
	}
	public <T extends WebPage>MenuItem(String menuText, T destinationPage) {
		setMenuText(menuText);
		setResponsePage(destinationPage);
		setSubMenuItemList(new ArrayList<MenuItem>());
		setDestinationType(DestinationType.WEB_PAGE_INSTANCE);
	}
	public MenuItem(String menuText, Class<? extends WebPage> destinationPageClass) {
		setMenuText(menuText);
		setResponsePageClass(destinationPageClass);
		setSubMenuItemList(new ArrayList<MenuItem>());
		setDestinationType(DestinationType.WEB_PAGE_CLASS);
	}
	
	public MenuItem(String menuText, Class<? extends WebPage> destinationWebPage,List<MenuItem> subMenuItemList) throws InstantiationException, IllegalAccessException {
		this(menuText,destinationWebPage.newInstance(),subMenuItemList);
		setDestinationType(DestinationType.WEB_PAGE_CLASS);
	}
	public <T extends WebPage>MenuItem(String menuText, T destinationPage,List<MenuItem> subMenuItemList) {
		setMenuText(menuText);
		setResponsePage(destinationPage);
		setSubMenuItemList(subMenuItemList);
		setDestinationType(DestinationType.WEB_PAGE_INSTANCE);
	}
	
	
	public static MenuItem getMenuSeperator(){
		return new MenuItem(true);
	}
	
	public String getMenuText() {
		return menuText;
	}
	public void setMenuText(String text) {
		this.menuText = text;
	}
	public WebPage getResponsePage() {
		return responsePage;
	}
	public <T extends WebPage> void setResponsePage(T destinationPage) {
		this.responsePage = destinationPage;
	}
	public void addSubmenu(MenuItem subMenuItem){
		getSubMenuItemList().add(subMenuItem);
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
	public boolean isSubmenuTitle() {
		return submenuTitle;
	}
	public void setSubmenuTitleTitle(boolean title) {
		this.submenuTitle = title;
	}
	public int getDestinationType() {
		return destinationType;
	}
	public void setDestinationType(int destinationType) {
		this.destinationType = destinationType;
	}
	public Class<? extends WebPage> getResponsePageClass() {
		return responsePageClass;
	}
	public void setResponsePageClass(
			Class<? extends WebPage> destinationPageClass) {
		this.responsePageClass = destinationPageClass;
	}
	public String getExternalLink() {
		return externalLink;
	}
	public void setExternalLink(String externalLink) {
		this.externalLink = externalLink;
	}
}
