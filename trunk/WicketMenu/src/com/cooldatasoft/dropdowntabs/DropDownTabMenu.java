package com.cooldatasoft.dropdowntabs;

import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;

public class DropDownTabMenu extends Panel implements IHeaderContributor{

	public DropDownTabMenu(String id) {
		super(id);
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		
	}

}
