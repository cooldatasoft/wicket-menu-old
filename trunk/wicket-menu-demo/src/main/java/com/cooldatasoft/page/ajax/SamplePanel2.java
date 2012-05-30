package com.cooldatasoft.page.ajax;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class SamplePanel2 extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SamplePanel2(String id) {
		super(id);
		
		add(new Label("label","Second panel -  this is the second panel which is replaced using ajax"));
	}

}
