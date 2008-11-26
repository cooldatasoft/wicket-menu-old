package com.cooldatasoft.chrome;

import java.io.Serializable;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
/**
 * 
 * @author fatih mehmet ucar
 *
 */
public class LinkInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3228761071903265131L;
	
	private Class<? extends WebPage> responsePage = null;
	private String linkText = null;
	private IModel model = null;
	private PageParameters param = null;

	public LinkInfo(Class<? extends WebPage> linkPageClass, String linkText) {
		setResponsePage(linkPageClass);
		setLinkText(linkText);
	}

	public LinkInfo(Class<? extends WebPage> linkPageClass, String linkText, PageParameters param) {
		setResponsePage(linkPageClass);
		setLinkText(linkText);
		setParam(param);
	}

	public LinkInfo(Class<? extends WebPage> linkPageClass, IModel linkTextModel) {
		setResponsePage(linkPageClass);
		setLinkText(linkTextModel.getObject().toString());
	}

	public LinkInfo(Class<? extends WebPage> linkPageClass, IModel linkTextModel,
			IModel objectModel) {
		setResponsePage(linkPageClass);
		setLinkText(linkTextModel.getObject().toString());
		setModel(objectModel);
	}

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}

	public PageParameters getParam() {
		return param;
	}

	public void setParam(PageParameters param) {
		this.param = param;
	}

	public Class<? extends WebPage> getResponsePage() {
		return responsePage;
	}

	public void setResponsePage(Class<? extends WebPage> responsePage) {
		this.responsePage = responsePage;
	}
}
