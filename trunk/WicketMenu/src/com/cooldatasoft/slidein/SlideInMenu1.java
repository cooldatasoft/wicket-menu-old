package com.cooldatasoft.slidein;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.RequestCycle;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.util.string.JavascriptUtils;

import com.cooldatasoft.chrome.LinkInfo;
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
 * @author fatih mehmet ucar
 *
 */
public class SlideInMenu1 extends Panel implements IHeaderContributor{

	private ResourceReference SHORTCUTS_JAVASCRIPT;
	private ResourceReference SHORTCUTS_CSS;
	private List<LinkInfo> menuList = new ArrayList<LinkInfo>();
	
	public SlideInMenu1(String id,List<LinkInfo> menuList){
		super(id);
		
		if(menuList!=null){
			this.menuList = menuList;
		}
		SHORTCUTS_JAVASCRIPT = new CompressedResourceReference(SlideInMenu1.class,"js/SlideInMenu1.js");
		SHORTCUTS_CSS = new CompressedResourceReference(SlideInMenu1.class,"css/SlideInMenu1.css");
		
		setRenderBodyOnly(true);
	}
	@Override
	public void renderHead(IHeaderResponse response) {

		response.getResponse().write(JavascriptUtils.SCRIPT_OPEN_TAG);
        int count=0;
        response.getResponse().write("var sitems = new Array();\n");
        
        for(final LinkInfo linkInfo:menuList){
        	response.getResponse().write("sitems["+(count++)+"]=[\""+linkInfo.getLinkText()+"\"," +	"\""+RequestCycle.get().urlFor(linkInfo.getResponsePage(),null)+"\"];\n");
        }
        
        response.getResponse().write(JavascriptUtils.SCRIPT_CLOSE_TAG);
        
        response.renderJavascriptReference(SHORTCUTS_JAVASCRIPT);
        response.renderCSSReference(SHORTCUTS_CSS);	
	}

}
