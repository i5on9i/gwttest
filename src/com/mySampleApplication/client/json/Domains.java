package com.mySampleApplication.client.json;

import com.google.gwt.core.client.SingleJsoImpl;

/**
 * With GWT 2, JavaScript overlay objects are able to implement interfaces.
 * There are some strict rules, as explained in Ch09 such as including the
 * annotation below to indicate which JavaScript Overlay class implements 
 * this interface
 */
@SingleJsoImpl(value = DomainsJavaScriptObject.class)
public interface Domains {
	public String getUrl(int index);
    public int getSize();
}
