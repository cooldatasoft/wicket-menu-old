package com.cooldatasoft.common;

import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * 
 * @author Fatih Mehmet UCAR - fmucar@gmail.com
 * 
 */
public abstract class Menu extends Panel implements IHeaderContributor {

	private static final long serialVersionUID = 1L;

	public Menu(String id) {
		super(id);
	}

}
