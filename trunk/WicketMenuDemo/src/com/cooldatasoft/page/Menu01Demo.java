package com.cooldatasoft.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

import com.cooldatasoft.menu01.Menu01;

public class Menu01Demo extends WebPage {
	
	public Menu01Demo() {
		add(new Menu01("menu01",new Model()));
	}

}
