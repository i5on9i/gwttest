package com.mySampleApplication.client.uibinder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Created by namhadmin on 14. 3. 24.
 */
public class SearchBox extends SimpleLayoutPanel{
    interface SearchBoxUiBinder extends UiBinder<HTMLPanel, SearchBox> {
    }

    private static SearchBoxUiBinder ourUiBinder = GWT.create(SearchBoxUiBinder.class);


    @UiField
    TextBox inputBox;
    @UiField
    Button searchButton;

    private HTMLPanel root;
    public SearchBox() {
        add(ourUiBinder.createAndBindUi(this));
    }


}