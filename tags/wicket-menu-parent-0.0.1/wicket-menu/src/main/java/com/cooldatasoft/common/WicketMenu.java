package com.cooldatasoft.common;

import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.panel.Panel;
/**
 * 
 * @author Fatih Mehmet UCAR - fmucar@gmail.com
 *
 */
public abstract class WicketMenu extends Panel implements IHeaderContributor{

	private static final long serialVersionUID = 1L;

	public WicketMenu(String id) {
		super(id);
	}

}
