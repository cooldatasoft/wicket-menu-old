package com.cooldatasoft.horizontal.dropdown.multiLevelCss;

import java.util.List;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;

import com.cooldatasoft.common.MenuItem;
/**
 * http://www.dynamicdrive.com/style/csslibrary/item/jquery_multi_level_css_menu_2/
 * @author fucar
 *
 */
public class MultiLevelCssMenu extends Panel implements IHeaderContributor {

	private ResourceReference SHORTCUTS_JAVASCRIPT = new CompressedResourceReference(MultiLevelCssMenu.class,"js/MultiLevelCssMenu.js");
	private ResourceReference SHORTCUTS_CSS = new CompressedResourceReference(MultiLevelCssMenu.class,"css/MultiLevelCssMenu.css");
	
	private ResourceReference SHORTCUTS_JAVASCRIPT2 = new CompressedResourceReference(MultiLevelCssMenu.class,"js/jqueryMin.js");
	

	
	
	public MultiLevelCssMenu(String id, List<MenuItem> menuItemList) {
		super(id);
	}
	
	
	@Override
	public void renderHead(IHeaderResponse response) {
		response.renderJavascriptReference(SHORTCUTS_JAVASCRIPT);
		response.renderJavascriptReference(SHORTCUTS_JAVASCRIPT2);
        response.renderCSSReference(SHORTCUTS_CSS);
	}

}
