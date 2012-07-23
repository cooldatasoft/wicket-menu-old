package com.cooldatasoft.common;

import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.panel.Panel;

public abstract class WicketMenu extends Panel implements IHeaderContributor{

	public WicketMenu(String id) {
		super(id);
	}

}
