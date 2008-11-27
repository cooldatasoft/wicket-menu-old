package com.cooldatasoft.slidein;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.util.string.JavascriptUtils;

import com.cooldatasoft.chrome.LinkInfo;

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
		
//		sitems[0]=["<big><font face='Arial'>Site Menu</font></big>", ""]
//      sitems[1]=["Menus And Navigation", "http://www.dynamicdrive.com/dynamicindex1/"]
//      sitems[2]=["Document Effects", "http://www.dynamicdrive.com/dynamicindex3/"]
//      sitems[3]=["Scrollers", "http://www.dynamicdrive.com/dynamicindex2/"]
	}
	@Override
	public void renderHead(IHeaderResponse response) {
			
        
        response.getResponse().write(JavascriptUtils.SCRIPT_OPEN_TAG);
        int count=0;
        response.getResponse().write("var sitems=new Array();");
        
        for(LinkInfo linkInfo:menuList){
        	response.getResponse().write("sitems["+(count++)+"]=[\""+linkInfo.getLinkText()+"\"," +
        			"\""+count+"\"]\n");
        }
        response.getResponse().write(JavascriptUtils.SCRIPT_CLOSE_TAG);
        
        response.renderJavascriptReference(SHORTCUTS_JAVASCRIPT);
        response.renderCSSReference(SHORTCUTS_CSS);	
	}

}
