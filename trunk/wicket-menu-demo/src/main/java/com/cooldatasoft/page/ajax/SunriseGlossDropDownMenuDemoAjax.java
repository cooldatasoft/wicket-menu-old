package com.cooldatasoft.page.ajax;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;

import com.cooldatasoft.app.BasePage;
import com.cooldatasoft.common.MenuItem;
import com.cooldatasoft.horizontal.dropdown.sunrisegloss.SunriseGlossDropDownMenu;
import com.cooldatasoft.page.Index;

public class SunriseGlossDropDownMenuDemoAjax extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 814225190142120804L;

	WebMarkupContainer ajaxPanel; 
		
	public SunriseGlossDropDownMenuDemoAjax() {
		ajaxPanel = new WebMarkupContainer("content",new Model<Serializable>());
		ajaxPanel.setOutputMarkupId(true);
		ajaxPanel.setOutputMarkupPlaceholderTag(true);
		
		List<MenuItem> primaryMenuList = buildMenu();
		//add your menu to your wicket page
		add(new SunriseGlossDropDownMenu("sunriseGlossMenu", primaryMenuList));
		add(ajaxPanel);
	}

	/**
	 * Build Menu as a List of MenuItem objects
	 * @return List of MenuItem Objects
	 */
	private List<MenuItem> buildMenu() {
		
		AjaxFallbackLink<Void> ajaxFallbackLink = new AjaxFallbackLink<Void>("subMenuLink"){
			@Override
			public void onClick(AjaxRequestTarget target) {
				add(new SamplePanel1("content"));				
				target.add(ajaxPanel);
			}			
		};
		
		AjaxFallbackLink<Void> ajaxFallbackLink2 = new AjaxFallbackLink<Void>("subMenuLink"){
			@Override
			public void onClick(AjaxRequestTarget target) {
				add(new SamplePanel2("content"));				
				target.add(ajaxPanel);
			}			
		};
		
		//Define Primary Menu items (menuText,destinationWebPage)		
		MenuItem primaryMenu1 = new MenuItem("MENU 1");
		MenuItem primaryMenu2 = new MenuItem("MeNu 2");
		
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
		primaryMenuList.add(primaryMenu2);
		
		return primaryMenuList;
	}
}
