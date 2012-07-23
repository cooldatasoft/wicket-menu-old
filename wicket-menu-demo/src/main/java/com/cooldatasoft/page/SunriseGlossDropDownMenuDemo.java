package com.cooldatasoft.page;

import java.util.ArrayList;
import java.util.List;

import com.cooldatasoft.app.BasePage;
import com.cooldatasoft.common.MenuItem;
import com.cooldatasoft.horizontal.dropdown.sunrisegloss.SunriseGlossDropDownMenu;

public class SunriseGlossDropDownMenuDemo extends BasePage {

	public SunriseGlossDropDownMenuDemo() {
		List<MenuItem> primaryMenuList = buildMenu();
		//add your menu to your wicket page
		add(new SunriseGlossDropDownMenu("sunriseGlossMenu", primaryMenuList));
	}

	/**
	 * Build Menu as a List of MenuItem objects
	 * @return List of MenuItem Objects
	 */
	private List<MenuItem> buildMenu() {
		//Define Primary Menu items (menuText,destinationWebPage)		
		MenuItem primaryMenu1 = new MenuItem("MENU 1", new Index());
		MenuItem primaryMenu2 = new MenuItem("MeNu 2", new Index());
		MenuItem primaryMenu3 = new MenuItem("Menu 3", new Index());
		MenuItem primaryMenu4 = new MenuItem("MenU 4", new Index());
		MenuItem primaryMenu5 = new MenuItem("menu 5", new Index());
		//Define submenu items
			MenuItem subMenu1 = new MenuItem("submenu 1", new Index());
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
