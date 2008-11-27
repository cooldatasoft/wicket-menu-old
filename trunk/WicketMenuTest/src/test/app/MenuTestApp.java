package test.app;
/**
 */
import org.apache.wicket.protocol.http.WebApplication;

import test.chrome.TestMenu;
/**
 * 
 * @author fatih mehmet ucar
 *
 */

public class MenuTestApp extends WebApplication {

	@Override
	public Class getHomePage() {
		// TODO Auto-generated method stub
		return TestMenu.class;
	}

	@Override
	protected void init() {
		super.init();
		getMarkupSettings().setStripWicketTags(true);
	}
	
	

}
