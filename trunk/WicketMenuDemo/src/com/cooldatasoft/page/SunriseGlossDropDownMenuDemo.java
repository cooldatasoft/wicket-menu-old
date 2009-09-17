package com.cooldatasoft.page;

import java.util.ArrayList;
import java.util.List;

import com.cooldatasoft.app.BasePage;
import com.cooldatasoft.common.MenuItem;
import com.cooldatasoft.css.horizontal.dropdown.SunriseGloss.SunriseGlossDropDownMenu;

public class SunriseGlossDropDownMenuDemo extends BasePage {

	public SunriseGlossDropDownMenuDemo() {

		MenuItem seperatorMenuItem = new MenuItem(true);

		MenuItem primaryMenu1 = new MenuItem("MENU 1", new Index());
		MenuItem primaryMenu2 = new MenuItem("MeNu 2", new Index());
		MenuItem primaryMenu3 = new MenuItem("Menu 3", new Index());
		MenuItem primaryMenu4 = new MenuItem("MenU 4", new Index());
		MenuItem primaryMenu5 = new MenuItem("menu 5", new Index());
			MenuItem subMenu1 = new MenuItem("submenu 1", new Index());
			MenuItem subMenu2 = new MenuItem("subMENU 2", new Index());
			MenuItem subMenu3 = new MenuItem("SUBMENU 3", new Index());
			MenuItem subMenu4 = new MenuItem("Submenu 4", new Index());
			MenuItem subMenu5 = new MenuItem("SuBmEnU 5", new Index());

		MenuItem subMenuTitle1 = new MenuItem("Submenu Title 1");
		MenuItem subMenuTitle2 = new MenuItem("Submenu Title 2");

		primaryMenu1.getSubMenuItemList().add(subMenu1);
		primaryMenu1.getSubMenuItemList().add(subMenu2);
		primaryMenu1.getSubMenuItemList().add(seperatorMenuItem);
		primaryMenu1.getSubMenuItemList().add(subMenuTitle1);
		primaryMenu1.getSubMenuItemList().add(subMenu3);
		primaryMenu1.getSubMenuItemList().add(subMenu4);
		primaryMenu1.getSubMenuItemList().add(seperatorMenuItem);
		primaryMenu1.getSubMenuItemList().add(subMenuTitle2);
		primaryMenu1.getSubMenuItemList().add(subMenu5);

		List<MenuItem> primaryMenuList = new ArrayList<MenuItem>();
		primaryMenuList.add(primaryMenu1);
		primaryMenuList.add(seperatorMenuItem);
		primaryMenuList.add(primaryMenu2);
		primaryMenuList.add(seperatorMenuItem);
		primaryMenuList.add(primaryMenu3);
		primaryMenuList.add(seperatorMenuItem);
		primaryMenuList.add(primaryMenu4);
		primaryMenuList.add(seperatorMenuItem);
		primaryMenuList.add(primaryMenu5);
		primaryMenuList.add(seperatorMenuItem);

		add(new SunriseGlossDropDownMenu("sunriseGlossMenu", primaryMenuList));
	}

}
