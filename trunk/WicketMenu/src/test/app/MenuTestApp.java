package test.app;

import org.apache.wicket.protocol.http.WebApplication;

import test.page.TestMenu;


public class MenuTestApp extends WebApplication {

	@Override
	public Class getHomePage() {
		// TODO Auto-generated method stub
		return TestMenu.class;
	}

}
