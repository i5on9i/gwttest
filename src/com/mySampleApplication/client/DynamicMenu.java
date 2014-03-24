package com.mySampleApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 * Created by namhadmin on 14. 3. 24.
 */
public class DynamicMenu extends Composite {
    interface DynamicMenuUiBinder extends UiBinder<Widget, DynamicMenu> {
    }

    private static DynamicMenuUiBinder ourUiBinder = GWT.create(DynamicMenuUiBinder.class);


    public DynamicMenu() {
        initWidget(ourUiBinder.createAndBindUi(this));

    }
}