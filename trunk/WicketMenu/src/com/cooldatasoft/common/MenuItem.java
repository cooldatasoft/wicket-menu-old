package com.cooldatasoft.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
/**
 * Defines a Menu Item
 * @author fmucar
 * @version
 */
public class MenuItem {

	private static final MenuItem SEPERATOR = new MenuItem(true);
	private boolean seperator = false;
	private boolean title = false;
	private String menuText;
	private WebPage responsePage;
	private Class<? extends WebPage> responseClass;
	private AjaxLink ajaxLink;
	private String externalLinkHref;
	private Link link;
	private List<MenuItem> subMenuItemList;
	
	
	private DestinationType destinationType;
	
	public void addSubmenu(MenuItem subMenuItem){
		getSubMenuItemList().add(subMenuItem);
	}
	public List<MenuItem> getSubMenuItemList() {
		if(subMenuItemList == null){
			subMenuItemList = new ArrayList<MenuItem>();
		}
		return subMenuItemList;
	}
	private MenuItem setSubMenuItemList(List<MenuItem> subMenuItemList) {
		this.subMenuItemList = subMenuItemList;
		return this;
	}	
	//constructors
	private MenuItem(boolean seperator){
		setSeperator(true);
		setDestinationType(DestinationType.NONE);
	}
	private MenuItem(String menuText){
		setMenuText(menuText);
		setDestinationType(DestinationType.NONE);
	}
	private MenuItem(String menuText,String externalLinkHref){
		setMenuText(menuText);
		setExternalLinkHref(externalLinkHref);
		setDestinationType(DestinationType.EXTERNAL_LINK);
	}
	private MenuItem(String menuText,Class<? extends WebPage> responseClass){
		setMenuText(menuText);
		setResponseClass(responseClass);
		setDestinationType(DestinationType.WEB_PAGE_CLASS);
	}
	private <T extends WebPage>MenuItem(String menuText,T responsePage){
		setMenuText(menuText);
		setResponseClass(responseClass);
		setDestinationType(DestinationType.WEB_PAGE_INSTANCE);
	}
	private <T extends Link>MenuItem(String menuText,T link){
		setMenuText(menuText);
		setLink(link);
		setDestinationType(DestinationType.LINK);
	}
	private <T extends AjaxLink>MenuItem(String menuText,T ajaxLink){
		setMenuText(menuText);
		setAjaxLink(ajaxLink);
		setDestinationType(DestinationType.AJAX_LINK);
	}
	//GetInstance Methods
	public static MenuItem getMenuSeperator(){
		return MenuItem.SEPERATOR;
	}	
	public static MenuItem getSubMenuTitleInstance(String menuText){
		return MenuItem.getInstance(menuText).setTitle(true);
	}
	public static MenuItem getInstance(String menuText){
		return new MenuItem(menuText);
	}
	public static MenuItem getInstance(String menuText,String externalLinkHref){
		return new MenuItem(menuText,externalLinkHref);
	}
	public static MenuItem getInstance(String menuText,Class<? extends WebPage> responseClass){
		return new MenuItem(menuText,responseClass);
	}
	public static <T extends WebPage> MenuItem getInstance(String menuText,T responsePage){
		return new MenuItem(menuText,responsePage);
	}
	public static <T extends Link> MenuItem getInstance(String menuText,T link){
		return new MenuItem(menuText,link);
	}
	public static <T extends AjaxLink> MenuItem getInstance(String menuText,T ajaxLink){
		return new MenuItem(menuText,ajaxLink);
	}
	public static MenuItem getInstance(String menuText,List<MenuItem> subMenuItemList){
		return new MenuItem(menuText).setSubMenuItemList(subMenuItemList);
	}
	public static MenuItem getInstance(String menuText,String externalLinkHref,List<MenuItem> subMenuItemList){
		return new MenuItem(menuText,externalLinkHref).setSubMenuItemList(subMenuItemList);
	}
	public static MenuItem getInstance(String menuText,Class<? extends WebPage> responseClass,List<MenuItem> subMenuItemList){
		return new MenuItem(menuText,responseClass).setSubMenuItemList(subMenuItemList);
	}
	public static <T extends WebPage> MenuItem getInstance(String menuText,T responsePage,List<MenuItem> subMenuItemList){
		return new MenuItem(menuText,responsePage).setSubMenuItemList(subMenuItemList);
	}
	public static <T extends Link> MenuItem getInstance(String menuText,T link,List<MenuItem> subMenuItemList){
		return new MenuItem(menuText,link).setSubMenuItemList(subMenuItemList);
	}
	public static <T extends AjaxLink> MenuItem getInstance(String menuText,T ajaxLink,List<MenuItem> subMenuItemList){
		return new MenuItem(menuText,ajaxLink).setSubMenuItemList(subMenuItemList);
	}
	//getter/setter methods
	public String getMenuText() {
		return menuText;
	}
	public void setMenuText(String menuText) {
		this.menuText = menuText;
	}
	public boolean isSeperator() {
		return seperator;
	}
	public boolean isTitle() {
		return title;
	}
	private MenuItem setTitle(boolean title){
		this.title = title;
		return this;
	}
	private void setSeperator(boolean seperator){
		this.seperator = seperator;
	}
	public WebPage getResponsePage() {
		return responsePage;
	}
	public void setResponsePage(WebPage responsePage) {
		this.responsePage = responsePage;
	}
	public Class<? extends WebPage> getResponseClass() {
		return responseClass;
	}
	public void setResponseClass(Class<? extends WebPage> responseClass) {
		this.responseClass = responseClass;
	}
	public AjaxLink getAjaxLink() {
		return ajaxLink;
	}
	public void setAjaxLink(AjaxLink ajaxLink) {
		this.ajaxLink = ajaxLink;
	}
	public String getExternalLinkHref() {
		return externalLinkHref;
	}
	public void setExternalLinkHref(String externalLinkHref) {
		this.externalLinkHref = externalLinkHref;
	}
	public Link getLink() {
		return link;
	}
	public void setLink(Link link) {
		this.link = link;
	}
	public DestinationType getDestinationType() {
		return destinationType;
	}
	private void setDestinationType(DestinationType destinationType) {
		this.destinationType = destinationType;
	}	
}
