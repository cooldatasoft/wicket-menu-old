package com.cooldatasoft.page;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

import com.cooldatasoft.app.BasePage;
import com.cooldatasoft.common.MenuItem;
import com.cooldatasoft.horizontal.dropdown.sunrisegloss.SunriseGlossDropDownMenu;

@Slf4j
public class SunriseGlossDropDownMenuDemoAjax extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 814225190142120804L;

	 Model<Integer> model = new Model<Integer>() {
         /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int counter = 0;
		@Override
		public Integer getObject() {
	         return new Integer(counter++);
		}
     };
     
     Label counterLabel ;
		
	public SunriseGlossDropDownMenuDemoAjax() {
		counterLabel = new Label("counter", model);
		counterLabel.setOutputMarkupId(true);
		counterLabel.setOutputMarkupPlaceholderTag(true);
		
		List<MenuItem> primaryMenuList = buildMenu();
		//add your menu to your wicket page
		add(new SunriseGlossDropDownMenu("sunriseGlossMenu", primaryMenuList));
		add(counterLabel);
	}

	/**
	 * Build Menu as a List of MenuItem objects
	 * @return List of MenuItem Objects
	 */
	private List<MenuItem> buildMenu() {
		
		AjaxFallbackLink<MenuItem> ajaxFallbackLink = new AjaxFallbackLink<MenuItem>("subMenuLink"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				log.error("----------------------");
				target.add(counterLabel);
			}			
		};
		ajaxFallbackLink.setOutputMarkupId(true);
		
		//Define Primary Menu items (menuText,destinationWebPage)		
		MenuItem primaryMenu1 = new MenuItem("MENU 1", new Index());
		MenuItem primaryMenu2 = new MenuItem("MeNu 2", new Index());
		MenuItem primaryMenu3 = new MenuItem("Menu 3", new Index());
		MenuItem primaryMenu4 = new MenuItem("MenU 4", new Index());
		MenuItem primaryMenu5 = new MenuItem("menu 5", new Index());
		//Define submenu items
			MenuItem subMenu1 = new MenuItem("submenu 1", ajaxFallbackLink);
			MenuItem subMenu2 = new MenuItem("subMENU 2", new Index());
			MenuItem subMenu3 = new MenuItem("SUBMENU 3", new Index());
			MenuItem subMenu4 = new MenuItem("Submenu 4", new Index());
			MenuItem subMenu5 = new MenuItem("SuBmEnU 5", new Index());
			//define submenu titles if you need one		
			MenuItem subMenuTitle1 = new MenuItem("Submenu Title 1");
			MenuItem subMenuTitle2 = new MenuItem("Submenu Title 2");
	    //Add submenus/submenu titles/seperators to the primary menu at your choice of order
		primaryMenu1.getSubMenuItemList().add(subMenu1);
		primaryMenu1.getSubMenuItemList().add(subMenu2);
		primaryMenu1.getSubMenuItemList().add(MenuItem.getMenuSeperator());
		primaryMenu1.getSubMenuItemList().add(subMenuTitle1);
		primaryMenu1.getSubMenuItemList().add(subMenu3);
		primaryMenu1.getSubMenuItemList().add(subMenu4);
		primaryMenu1.getSubMenuItemList().add(MenuItem.getMenuSeperator());
		primaryMenu1.getSubMenuItemList().add(subMenuTitle2);
		primaryMenu1.getSubMenuItemList().add(subMenu5);
		
		//Create a List which contains the primary menu items in it.	
		List<MenuItem> primaryMenuList = new ArrayList<MenuItem>();
		primaryMenuList.add(primaryMenu1);
		primaryMenuList.add(primaryMenu2);
		primaryMenuList.add(primaryMenu3);
		primaryMenuList.add(primaryMenu4);
		primaryMenuList.add(primaryMenu5);
		
		return primaryMenuList;
	}
}
