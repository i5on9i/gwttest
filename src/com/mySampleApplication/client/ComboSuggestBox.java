package com.mySampleApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.mySampleApplication.client.presenter.DomainSuggestOracle;
import com.mySampleApplication.client.view.CommandIcon;

/**
 * Created by namhadmin on 14. 3. 25.
 */
public class ComboSuggestBox extends Composite {
    interface ComboSuggestBoxUiBinder extends UiBinder<Widget, ComboSuggestBox> {
    }

    private static ComboSuggestBoxUiBinder ourUiBinder = GWT.create(ComboSuggestBoxUiBinder.class);

    private int selectedIndex = -1;

    @UiField(provided = true)
    SuggestBox suggestBox;
    @UiField(provided = true)
    FocusPanel iconWrapper;


//    public ComboSuggestBox(final Image openIconImage, final DomainSuggestOracle oracle) {
    public ComboSuggestBox(final Image openIconImage, final DomainSuggestOracle oracle) {
        suggestBox = new SuggestBox(oracle);
        iconWrapper = new FocusPanel();


        openIcon = new CommandIcon(openIconImage, new ClickHandler(){

            @Override
            public void onClick(ClickEvent event) {

                command.execute();
            }
        });



        iconWrapper.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                selectedIndex = -1;
                iconWrapper.setFocus(true);
                command.execute();
            }
        });

        initWidget(ourUiBinder.createAndBindUi(this));

    }
}