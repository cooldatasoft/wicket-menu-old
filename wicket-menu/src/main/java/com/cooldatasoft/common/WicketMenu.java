package com.cooldatasoft.common;

import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.panel.Panel;

public abstract class WicketMenu extends Panel implements IHeaderContributor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6467578940301195136L;

	public WicketMenu(String id) {
		super(id);
	}

}
