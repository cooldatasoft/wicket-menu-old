# Introduction #

Name: Chrome DropDown

Class Name: ChromeDropDownMenu

Pakcage : com.cooldatasoft.horizontal.dropdown.chrome

Type: Dropdown Css Menu



For a demo of the menu follow the link :
http://www.dynamicdrive.com/dynamicindex1/chrome/index.htm

# Screenshot #
![http://img684.imageshack.us/img684/7365/chromeb.jpg](http://img684.imageshack.us/img684/7365/chromeb.jpg)

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
import com.cooldatasoft.horizontal.dropdown.chrome.ChromeDropDownMenu;

public class ChromeDropDownMenuDemo extends BasePage {

	public ChromeDropDownMenuDemo(){
		List<MenuItem> primaryMenuList = buildMenu();
		//add your menu to your wicket page
		add(new ChromeDropDownMenu("chromeMenu", primaryMenuList));
	}
	
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
		//Add submenus/submenu titles/seperators to the primary menu at your choice of order
		primaryMenu1.getSubMenuItemList().add(subMenu1);
		primaryMenu1.getSubMenuItemList().add(subMenu2);
		primaryMenu1.getSubMenuItemList().add(subMenu3);
		primaryMenu1.getSubMenuItemList().add(subMenu4);
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


```


Html Markup :


```
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:wicket="http://wicket.apache.org/dtds.data/wicket-xhtml1.3-strict.dtd"
	xml:lang="en" lang="en">
	<head>
		<title><wicket:message key="wicketmenu.version"/></title>
	</head>
	<body>
		<div wicket:id="chromeMenu"></div>
	</body>
</html>

```