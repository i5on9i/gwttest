package com.mySampleApplication.client.uibinder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SuggestBox;
import com.mySampleApplication.client.json.DomainsJavaScriptObject;
import com.mySampleApplication.client.presenter.DomainSuggestOracle;

/**
 * Created by namhadmin on 14. 3. 25.
 */
public class SuggestWithListBox extends Composite {

    private final ComboSuggestBox comboSuggestBox;
    private final static int SUGGESTION_LIMIT = 10;   // 20 looks heavy.

    public SuggestWithListBox() {

        comboSuggestBox = new ComboSuggestBox();
        comboSuggestBox.setLimit(SUGGESTION_LIMIT);
//        comboSuggestBox.getValueBox().addFocusHandler(new FocusHandler() {
//            @Override
//            public void onFocus(FocusEvent event) {
//                comboSuggestBox.showSuggestionList();
//            }
//        });
        initWidget(comboSuggestBox);
        setSuggestions(comboSuggestBox);


    }

    private void setSuggestions(final SuggestBox box) {


        /**
         * <inherits name="com.google.gwt.http.HTTP"/>
         * is needed
         */
        RequestBuilder rb = new RequestBuilder(
                RequestBuilder.POST,
                GWT.getHostPageBaseURL() + "testDomains.js");
        rb.setRequestData("test1=data1&test2=data2");
        rb.setCallback(new RequestCallback() {

            @Override
            public void onResponseReceived(Request req, Response res) {
                if (200 == res.getStatusCode()) {


                    DomainsJavaScriptObject domains = JsonUtils.safeEval(res.getText());
                    DomainSuggestOracle oracle = (DomainSuggestOracle) box.getSuggestOracle();
                    int len = domains.getSize();
                    for (int j = 0; j < len; j++) {
                        oracle.add(domains.getUrl(j));
                    }


                } else {

                }

            }

            @Override
            public void onError(Request request, Throwable exception) {

            }
        });
        try {
            rb.send();
        } catch (RequestException e) {
//            output.setText("FETCH ERROR: " + e.getMessage());
        }


    }


}