package com.cooldatasoft.page;

import java.util.ArrayList;
import java.util.List;

import com.cooldatasoft.app.BasePage;
import com.cooldatasoft.common.MenuItem;
import com.cooldatasoft.horizontal.dropdown.multiLevelCss.MultiLevelCssMenu;

public class MultiLevelCssMenuDemo extends BasePage {

	public MultiLevelCssMenuDemo(){
		List<MenuItem> primaryMenuList = buildMenu();
		//add your menu to your wicket page
		add(new MultiLevelCssMenu("multiLevelCssMenuDemo", primaryMenuList));
	}
	private List<MenuItem> buildMenu() {
		//Define Primary Menu items (menuText,destinationWebPage)		
		MenuItem primaryMenu1 = new MenuItem("MENU 1", new Index());
		MenuItem primaryMenu2 = new MenuItem("MeNu 2", new Index());
		MenuItem primaryMenu3 = new MenuItem("Menu 3", new Index());
		MenuItem primaryMenu4 = new MenuItem("MenU 4", new Index());
		MenuItem primaryMenu5 = new MenuItem("menu 5", new Index());
		
		
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
