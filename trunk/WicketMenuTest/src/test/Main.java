package test;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import test.chrome.ChromeMenuTest;
import test.slidein1.SlideIn1MenuTest;

public class Main extends WebPage{

	public Main(){
		add(new MyLink("chromeMenu",ChromeMenuTest.class));
		add(new MyLink("slideInMenu1",SlideIn1MenuTest.class));
		
	}
	
	class MyLink extends Link{

		private Class<? extends WebPage> responsePage;
		public MyLink(String id, Class<? extends WebPage> responsePage) {
			super(id);
			this.responsePage=responsePage;
		}

		@Override
		public void onClick() {
			setResponsePage(responsePage);		
		}
		
	}
}
