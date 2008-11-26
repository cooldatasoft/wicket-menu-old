package test.chrome;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;

import com.cooldatasoft.chrome.ChromeMenu;
import com.cooldatasoft.chrome.LinkInfo;
/**
 * 
 * @author fatih mehmet ucar
 *
 */
public class TestMenu extends WebPage {


	public TestMenu(){
		
		LinkInfo menu1 = new LinkInfo(TestMenu.class,"menu1");
		LinkInfo menu1_1 = new LinkInfo(TestMenu.class,"menu1_1");
		LinkInfo menu1_2 = new LinkInfo(TestMenu.class,"menu1_2");
		LinkInfo menu1_3 = new LinkInfo(TestMenu.class,"menu1_3");
		
		List<LinkInfo> list1=new ArrayList<LinkInfo>();
		list1.add(menu1);
		list1.add(menu1_1);
		list1.add(menu1_2);
		list1.add(menu1_3);
		
		LinkInfo menu2 = new LinkInfo(TestMenu.class,"menu2");
		LinkInfo menu2_1 = new LinkInfo(TestMenu.class,"menu2_1");
		LinkInfo menu2_2 = new LinkInfo(TestMenu.class,"menu2_2");
		
		List<LinkInfo> list2=new ArrayList<LinkInfo>();
		list2.add(menu2);
		list2.add(menu2_1);
		list2.add(menu2_2);
		
		
		LinkInfo menu3 = new LinkInfo(TestMenu.class,"menu3");
		LinkInfo menu3_1 = new LinkInfo(TestMenu.class,"menu3_1");
		LinkInfo menu3_2 = new LinkInfo(TestMenu.class,"menu3_2");
		
		List<LinkInfo> list3=new ArrayList<LinkInfo>();
		list3.add(menu3);
		list3.add(menu3_1);
		list3.add(menu3_2);
		
		
		List<List<LinkInfo>> menuList = new ArrayList<List<LinkInfo>>();
		
		menuList.add(list1);
		menuList.add(list2);
		menuList.add(list3);
		
		ChromeMenu ch = new ChromeMenu("menuPanel",menuList,ChromeMenu.CSS.THEME2);
		add(ch);
	}
}
