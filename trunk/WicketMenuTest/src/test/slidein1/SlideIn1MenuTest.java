package test.slidein1;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;

import test.chrome.ChromeMenuTest;

import com.cooldatasoft.chrome.LinkInfo;
import com.cooldatasoft.slidein.SlideInMenu1;

public class SlideIn1MenuTest extends WebPage{

	public SlideIn1MenuTest(){
		
		LinkInfo menu1 = new LinkInfo(ChromeMenuTest.class,"menu1");
		LinkInfo menu2 = new LinkInfo(ChromeMenuTest.class,"menu2");
		LinkInfo menu3 = new LinkInfo(ChromeMenuTest.class,"menu3");
		LinkInfo menu4 = new LinkInfo(ChromeMenuTest.class,"menu4");
		
		List<LinkInfo> menuList=new ArrayList<LinkInfo>();
		menuList.add(menu1);
		menuList.add(menu2);
		menuList.add(menu3);
		menuList.add(menu4);
		
		
		SlideInMenu1 slideInMenu1 = new SlideInMenu1("slideInMenu1",menuList);
		add(slideInMenu1);
	}
}
