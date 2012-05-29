package com.cooldatasoft.page.ajax;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;

import com.cooldatasoft.app.BasePage;
import com.cooldatasoft.common.MenuItem;
import com.cooldatasoft.horizontal.dropdown.sunrisegloss.SunriseGlossDropDownMenu;
import com.cooldatasoft.page.Index;

@Slf4j
public class SunriseGlossDropDownMenuDemoAjax extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 814225190142120804L;

	WebMarkupContainer ajaxPanel; 
		
	public SunriseGlossDropDownMenuDemoAjax() {
		
		ajaxPanel = new WebMarkupContainer("content");
		ajaxPanel.setOutputMarkupId(true);
		ajaxPanel.setOutputMarkupPlaceholderTag(true);
		
		List<MenuItem> primaryMenuList = buildMenu();
		//add your menu to your wicket page
		add(new SunriseGlossDropDownMenu("sunriseGlossMenu", primaryMenuList));
		add(ajaxPanel);
		log.info("Ajax page loaded");
	}

	/**
	 * Build Menu as a List of MenuItem objects
	 * @return List of MenuItem Objects
	 */
	private List<MenuItem> buildMenu() {
		
		AjaxFallbackLink<Void> ajaxFallbackLink = new AjaxFallbackLink<Void>("subMenuLink"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				SamplePanel1 samplePanel1 = new SamplePanel1("content");
				samplePanel1.setOutputMarkupId(true);
				samplePanel1.setOutputMarkupPlaceholderTag(true);
				ajaxPanel.replaceWith(samplePanel1);
				ajaxPanel = samplePanel1;
				target.add(ajaxPanel);
				log.info("Sample1 ajax executed");
			}			
		};
		
		AjaxFallbackLink<Void> ajaxFallbackLink2 = new AjaxFallbackLink<Void>("subMenuLink"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				SamplePanel2 samplePanel2 = new SamplePanel2("content");
				//set below 2 to make sure subsequent ajax calls work properly
				samplePanel2.setOutputMarkupId(true);
				samplePanel2.setOutputMarkupPlaceholderTag(true);
				//replace the existing panel with the new one
				ajaxPanel.replaceWith(samplePanel2);
				//you must assign reference to ajaxPanel again to make sure subsequent ajax calls work properly
				ajaxPanel = samplePanel2;
				target.add(ajaxPanel);
				log.info("Sample2 ajax executed");
			}			
		};
		
		//Define Primary Menu items (menuText,destinationWebPage)		
		MenuItem primaryMenu1 = new MenuItem("MENU 1");
		
		//Define submenu items
			MenuItem subMenu1 = new MenuItem("Ajax Sample page 1", ajaxFallbackLink);
			MenuItem subMenu2 = new MenuItem("Ajax Sample page 2", ajaxFallbackLink2);
			MenuItem subMenu3 = new MenuItem("Main page", new Index());
			
			//define submenu titles if you need one		
			MenuItem subMenuTitle1 = new MenuItem("Ajax links");
			MenuItem subMenuTitle2 = new MenuItem("Main menu link");
	    //Add submenus/submenu titles/seperators to the primary menu at your choice of order
		
		primaryMenu1.getSubMenuItemList().add(subMenuTitle1);
		primaryMenu1.getSubMenuItemList().add(subMenu1);
		primaryMenu1.getSubMenuItemList().add(subMenu2);
		primaryMenu1.getSubMenuItemList().add(MenuItem.getMenuSeperator());
		
		primaryMenu1.getSubMenuItemList().add(subMenuTitle2);
		primaryMenu1.getSubMenuItemList().add(subMenu3);
		
		//Create a List which contains the primary menu items in it.	
		List<MenuItem> primaryMenuList = new ArrayList<MenuItem>();
		primaryMenuList.add(primaryMenu1);
		
		return primaryMenuList;
	}
}
