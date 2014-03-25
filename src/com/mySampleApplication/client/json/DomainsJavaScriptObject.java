/**
 * 
 */
package com.mySampleApplication.client.json;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import java.util.List;

/**
 * This is a JavaScript overlay class - you would probably give it a better name in your code,
 * such as PersonImpl, but we make it a mouthful so it is easier to track in the example.
 * 
 * Note that it implements Person interface - the ability for overlays to implement interfaces
 * is new in GWT 2.
 *
 */
public class DomainsJavaScriptObject extends JavaScriptObject implements Domains {

	// The required protected constructor of a JavaScript overlay.
	protected DomainsJavaScriptObject(){}

	/**
	 * Method to get the career by simply returning the underlying element
	 * There is a tacit assumption this element exists.
	 */
    @Override
	final public native String getUrl(int index)/*-{
		return this.domains[index];
	}-*/;

    @Override
    final public native int getSize()/*-{
        return this.domains.length;
    }-*/;





}