package com.mySampleApplication.client.uibinder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.*;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.mySampleApplication.client.json.DomainsJavaScriptObject;

/**
 * Created by namhadmin on 14. 3. 24.
 */
public class CdnStatsPanel extends Composite{

    private MultiWordSuggestOracle suggestions;

    interface CdnStatsPanelUiBinder extends UiBinder<Widget, CdnStatsPanel> {
    }

    private static CdnStatsPanelUiBinder ourUiBinder = GWT.create(CdnStatsPanelUiBinder.class);



    public CdnStatsPanel() {

        initWidget(ourUiBinder.createAndBindUi(this));

    }






}