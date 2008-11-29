package test.app;
/**
 */
import org.apache.wicket.protocol.http.WebApplication;

import test.Main;
/**
 * 
 * @author fatih mehmet ucar
 *
 */

public class WicketMenuTestApp extends WebApplication {

	@Override
	public Class getHomePage() {
		// TODO Auto-generated method stub
		return Main.class;
	}

	@Override
	protected void init() {
		super.init();
		getMarkupSettings().setStripWicketTags(true);
	}
	
	

}
