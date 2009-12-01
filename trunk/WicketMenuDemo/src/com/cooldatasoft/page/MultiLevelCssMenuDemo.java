package com.cooldatasoft.page;

import java.util.ArrayList;
import java.util.List;

import com.cooldatasoft.app.BasePage;
import com.cooldatasoft.common.MenuItem;
import com.cooldatasoft.horizontal.dropdown.multiLevelCss.MultiLevelCssMenu;
/**
 * http://www.dynamicdrive.com/style/csslibrary/item/jquery_multi_level_css_menu_2/
 * @author fucar
 *
 */
public class MultiLevelCssMenuDemo extends BasePage {

	public MultiLevelCssMenuDemo(){
		List<MenuItem> primaryMenuList = buildMenu();
		//add your menu to your wicket page
		add(new MultiLevelCssMenu("multiLevelCssMenu", primaryMenuList));
	}
	
	private List<MenuItem> buildMenu() {
		//Define Primary Menu items (menuText,destinationWebPage)		
		MenuItem primaryMenu1 = new MenuItem("MENU 1", new Index());
		MenuItem primaryMenu2 = new MenuItem("MeNu 2", new Index());
		MenuItem primaryMenu3 = new MenuItem("Menu 3", new Index());
		MenuItem primaryMenu4 = new MenuItem("MenU 4", new Index());
		MenuItem primaryMenu5 = new MenuItem("menu 5", new Index());
		
		MenuItem menu51 = new MenuItem("menu 5.1", new Index());
		MenuItem menu52 = new MenuItem("menu 5.2", new Index());
		
		MenuItem menu521 = new MenuItem("menu 5.2.1", new Index());
		MenuItem menu522 = new MenuItem("menu 5.2.2", new Index());
		
		MenuItem menu5211 = new MenuItem("menu 5.2.1.1", new Index());
		MenuItem menu5212 = new MenuItem("menu 5.2.1.2", new Index());
		MenuItem menu5213 = new MenuItem("menu 5.2.1.3", new Index());
		
		//Create a List which contains the primary menu items in it.	
		List<MenuItem> primaryMenuList = new ArrayList<MenuItem>();
		List<MenuItem> subMenuList5 = new ArrayList<MenuItem>();
		List<MenuItem> subMenuList52 = new ArrayList<MenuItem>();
		List<MenuItem> subMenuList521 = new ArrayList<MenuItem>();
		
		primaryMenuList.add(primaryMenu1);
		primaryMenuList.add(primaryMenu2);
		primaryMenuList.add(primaryMenu3);
		primaryMenuList.add(primaryMenu4);
		primaryMenuList.add(primaryMenu5);
		
		subMenuList5.add(menu51);
		subMenuList5.add(menu52);
		
		subMenuList52.add(menu521);
		subMenuList52.add(menu522);
		
		subMenuList521.add(menu5211);
		subMenuList521.add(menu5212);
		subMenuList521.add(menu5213);
		
		primaryMenu5.setSubMenuItemList(subMenuList5);
			menu52.setSubMenuItemList(subMenuList52);
				menu521.setSubMenuItemList(subMenuList521);
		
		return primaryMenuList;
	}
}
