package com.cooldatasoft.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

/**
 * 
 * @author Fatih Mehmet UCAR - fmucar@gmail.com
 * 
 */

@Data
@Slf4j
public class MenuItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String menuText;
	// possible menu inputs
	private Class<? extends WebPage> responsePageClass;
	private WebPage responsePage;
	private String externalLink;
	private Link<MenuItem> ajaxLink;

	private DestinationType destinationType;
	// submenu list
	private List<MenuItem> subMenuItemList = new ArrayList<MenuItem>();

	private boolean seperator = false;
	private boolean submenuTitle = false;

	public MenuItem(boolean seperator) {
		log.trace("Creating MenuItem with seperator = {} ", seperator);
		setSeperator(true);
		setDestinationType(DestinationType.NONE);
	}

	public MenuItem(Link<MenuItem> ajaxLink) {
		setAjaxLink(ajaxLink);
		setDestinationType(DestinationType.AJAX_TARGET);
	}

	public MenuItem(String menuText,Link<MenuItem> ajaxLink) {
		setMenuText(menuText);
		setAjaxLink(ajaxLink);
		setDestinationType(DestinationType.AJAX_TARGET);
	}
	
	public MenuItem(final Component... componentsToUpdate) {

		// TODO id needs to be on html
		setAjaxLink(new AjaxFallbackLink<MenuItem>("menuLink") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				target.add(componentsToUpdate);
			}
		});
		setDestinationType(DestinationType.AJAX_TARGET);
	}

	public MenuItem(String submenuTitle) {
		setSubmenuTitle(true);
		setMenuText(submenuTitle);
		setDestinationType(DestinationType.NONE);
	}

	public <T extends WebPage> MenuItem(String menuText, T destinationPage) {
		setMenuText(menuText);
		setResponsePage(destinationPage);
		setSubMenuItemList(new ArrayList<MenuItem>());
		setDestinationType(DestinationType.WEB_PAGE_INSTANCE);
	}

	public MenuItem(String menuText,
			Class<? extends WebPage> destinationPageClass) {
		setMenuText(menuText);
		setResponsePageClass(destinationPageClass);
		setSubMenuItemList(new ArrayList<MenuItem>());
		setDestinationType(DestinationType.WEB_PAGE_CLASS);
	}

	public MenuItem(String menuText,
			Class<? extends WebPage> destinationWebPage,
			List<MenuItem> subMenuItemList) throws InstantiationException,
			IllegalAccessException {
		this(menuText, destinationWebPage.newInstance(), subMenuItemList);
		setDestinationType(DestinationType.WEB_PAGE_CLASS);
	}

	public <T extends WebPage> MenuItem(String menuText, T destinationPage,
			List<MenuItem> subMenuItemList) {
		setMenuText(menuText);
		setResponsePage(destinationPage);
		setSubMenuItemList(subMenuItemList);
		setDestinationType(DestinationType.WEB_PAGE_INSTANCE);
	}

	public static MenuItem getMenuSeperator() {
		return new MenuItem(true);
	}
}
