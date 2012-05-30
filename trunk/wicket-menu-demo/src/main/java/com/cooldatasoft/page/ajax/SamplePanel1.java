package com.cooldatasoft.page.ajax;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class SamplePanel1 extends Panel {

	public SamplePanel1(String id) {
		super(id);
		
		add(new Label("label","First panel - Some content here"));
	}

}
