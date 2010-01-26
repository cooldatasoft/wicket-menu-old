package com.cooldatasoft.vertical.slidein;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.RequestCycle;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.util.string.JavascriptUtils;

import com.cooldatasoft.common.DestinationType;
import com.cooldatasoft.common.MenuItem;
/**
 * Configuring the menu
 * To change the contents of the menu to your own, edit the sitems[] array. 
 * You may now also specify a target for the links, if you wish them to be loaded 
 * in a new window or frame.
 * 
 * To change the appearance of the menu, edit the style sheet in Step 1 plus the 
 * first few variables listed in script of Step 2. Here's a brief description of 
 * the editable parts within the style sheet:
 * 
 * border:1.5px solid green;
 * background-color:lightyellow;
 * layer-background-color:lightyellow;
 * font:bold 12px Verdana;
 * line-height:20px;
 * 
 * The first line determines the appearance of the border that surrounds the menu 
 * (change 1.5px and green as desired). The second and third line effects the background 
 * color of the menu. The fourth line determines the font of the menu 
 * (change 12px and Verdana as desired). The last line deterines the spacing between 
 * each line of text in the menu.
 * 
 * @author fmucar
 *
 */
public class SlideInMenu extends Panel implements IHeaderContributor {

	private final ResourceReference SHORTCUTS_JAVASCRIPT;
	private final ResourceReference SHORTCUTS_CSS;
	private List<MenuItem> menuItemList = null;
	
	public SlideInMenu(String id, List<MenuItem> menuItemList ){
		super(id);
		setMenuItemList(menuItemList);
		SHORTCUTS_JAVASCRIPT = new CompressedResourceReference(SlideInMenu.class,"js/SlideInMenu.js");
		SHORTCUTS_CSS = new CompressedResourceReference(SlideInMenu.class,"css/SlideInMenu.css");
		
		setRenderBodyOnly(true);
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {

		response.getResponse().write(JavascriptUtils.SCRIPT_OPEN_TAG);
        int count=0;
        response.getResponse().write("var sitems = new Array();\n");
        
        for(MenuItem menuItem:getMenuItemList()){
        	if(menuItem.getDestinationType() == DestinationType.WEB_PAGE_CLASS ){
        		response.getResponse().write("sitems["+(count++)+"]=[\""+menuItem.getMenuText()+"\"," +	"\""+RequestCycle.get().urlFor(menuItem.getResponsePageClass(),null)+"\"];\n");
        	}else if(menuItem.getDestinationType() == DestinationType.WEB_PAGE_INSTANCE ){
        		response.getResponse().write("sitems["+(count++)+"]=[\""+menuItem.getMenuText()+"\"," +	"\""+RequestCycle.get().urlFor(menuItem.getResponsePage())+"\"];\n");
        	}else{
        		System.err.println(menuItem.getDestinationType());
        		throw new RuntimeException("This menu can only be applied to wicket web pages");
        	}        	
        }
        
        response.getResponse().write(JavascriptUtils.SCRIPT_CLOSE_TAG);        
        response.renderJavascriptReference(SHORTCUTS_JAVASCRIPT);
        response.renderCSSReference(SHORTCUTS_CSS);	
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		if(menuItemList ==null) {
			this.menuItemList = new ArrayList<MenuItem>();
		}else {
			this.menuItemList = menuItemList;
		}
	}

}
