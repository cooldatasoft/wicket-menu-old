# Introduction #

Name: Sunrise Gloss

Class Name: SunriseGlossDropDownMenu

Pakcage : com.cooldatasoft.css.horizontal.dropdown.SunriseGloss

Type: Dropdown Css Menu



For a demo of the menu follow the link :
http://www.cssmenumaker.com/builder/menu_info.php?menu=003

# Screenshot #
![http://img142.imageshack.us/img142/1036/menu01z.jpg](http://img142.imageshack.us/img142/1036/menu01z.jpg)

# How to use it: #

  * Download the demo war
  * Deploy it to your AS (Easiest one is tomcat)
  * See source for example usage.

or see the example below:


Java Code:

```
package com.cooldatasoft.page;

import java.util.ArrayList;
import java.util.List;

import com.cooldatasoft.app.BasePage;
import com.cooldatasoft.common.MenuItem;
import com.cooldatasoft.css.horizontal.dropdown.SunriseGloss.SunriseGlossDropDownMenu;

public class SunriseGlossDropDownMenuDemo extends BasePage {

	public SunriseGlossDropDownMenuDemo() {
		List<MenuItem> primaryMenuList = buildMenu();
		//add your menu to your wicket page
		add(new SunriseGlossDropDownMenu("sunriseGlossMenu", primaryMenuList));
	}

	private List<MenuItem> buildMenu() {
		//Create one seperator menu item
		MenuItem seperatorMenuItem = new MenuItem(true);
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
		primaryMenu1.getSubMenuItemList().add(seperatorMenuItem);
		primaryMenu1.getSubMenuItemList().add(subMenuTitle1);
		primaryMenu1.getSubMenuItemList().add(subMenu3);
		primaryMenu1.getSubMenuItemList().add(subMenu4);
		primaryMenu1.getSubMenuItemList().add(seperatorMenuItem);
		primaryMenu1.getSubMenuItemList().add(subMenuTitle2);
		primaryMenu1.getSubMenuItemList().add(subMenu5);
		
		//Create a List which contains the primary menu items in it.	
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
		
		return primaryMenuList;
	}
}

```


Html Markup :


```
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:wicket="http://wicket.apache.org/dtds.data/wicket-xhtml1.3-strict.dtd"
	xml:lang="en" lang="en">
	<head>
		<title>WicketMenu-0.0.1 Demo</title>
	</head>
	<body>
		<div wicket:id="sunriseGlossMenu"></div>
	</body>
</html>
```