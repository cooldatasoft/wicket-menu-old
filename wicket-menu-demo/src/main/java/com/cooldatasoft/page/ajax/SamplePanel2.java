package com.cooldatasoft.page.ajax;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class SamplePanel2 extends Panel {

	public SamplePanel2(String id) {
		super(id);
		
		add(new Label("label","Second panel"));
	}

}
