# Introduction #

Name: Slide In

Class Name: SlideInMenu

Pakcage : com.cooldatasoft.vertical.slidein

Type: Slide in Menu



For a demo of the menu follow the link :
http://www.dynamicdrive.com/dynamicindex1/slideinmenu.htm



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
import com.cooldatasoft.vertical.slidein.SlideInMenu;

public class SlideInMenuDemo extends BasePage{

	public SlideInMenuDemo(){
		List<MenuItem> primaryMenuList = buildMenu();
		//add your menu to your wicket page
		add(new SlideInMenu("slideInMenu", primaryMenuList));
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
		<div wicket:id="slideInMenu"></div>
	</body>
</html>

```