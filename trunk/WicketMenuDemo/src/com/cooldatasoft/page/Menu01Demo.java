package com.cooldatasoft.page;

import java.util.ArrayList;

import org.apache.wicket.markup.html.WebPage;

import com.cooldatasoft.common.MenuItem;
import com.cooldatasoft.menu01.Menu01;

public class Menu01Demo extends WebPage {
	
	public Menu01Demo() {
		
		MenuItem primaryMenu1 = new MenuItem("",new Index(),new ArrayList<MenuItem>());
		
		
		add(new Menu01("menu01",new ArrayList<MenuItem>()));
	}

}
