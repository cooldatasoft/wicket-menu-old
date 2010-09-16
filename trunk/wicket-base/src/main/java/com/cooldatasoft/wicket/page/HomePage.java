package com.cooldatasoft.wicket.page;

import org.apache.log4j.Logger;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

import com.cooldatasoft.wicket.Start;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static Logger logger = Logger.getLogger(HomePage.class);
	
	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {

        // Add the simplest type of label
        add(new Label("message", "If you see this message wicket is properly configured and running"));
        logger.info("Page rendered....");
        // TODO Add your page's components here
    }
}
