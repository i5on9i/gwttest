package com.mySampleApplication.client.uibinder;

import com.google.gwt.user.client.ui.*;
import com.mySampleApplication.client.presenter.DomainSuggestOracle;


/**
 * Created by namhadmin on 14. 3. 25.
 */
public class ComboSuggestBox extends SuggestBox {


    public ComboSuggestBox() {
        super(new DomainSuggestOracle());
    }


}