package com.mySampleApplication.client.presenter;

import com.google.gwt.user.client.ui.SuggestOracle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class DomainSuggestOracle extends SuggestOracle {


    public static class DomainSuggestion implements Suggestion {
        private String displayString;
        private String replacementString;

        public DomainSuggestion(String s) {
            this.displayString = s;
        }

        /**
         * Constructor for <code>DomainSuggestion</code>.
         *
         * @param replacementString the string to enter into the SuggestBox's text
         *                          box if the suggestion is chosen
         * @param displayString     the display string
         */
        public DomainSuggestion(String replacementString, String displayString) {
            this.replacementString = replacementString;
            this.displayString = displayString;
        }

        public String getDisplayString() {
            return displayString;
        }

        public String getReplacementString() {
            return replacementString;
        }
    }


    private static final char WHITESPACE_CHAR = ' ';
    private List<DomainSuggestion> domainSuggestions = null;

    @Override
    public void requestSuggestions(Request request, Callback callback) {
        Response resp = new Response(getCandidates(request.getQuery(),
                request.getLimit()));

        callback.onSuggestionsReady(request, resp);
    }

    /**
     * @param query The current text being entered into the suggest box
     * @param limit The maximum number of results to return
     * @return A collection of people suggestions that match.
     */
    public Collection<DomainSuggestion> getCandidates(String query, int limit) {

        List<DomainSuggestion> candidates = new ArrayList<DomainSuggestion>(limit);

        // only begin to search after the user has type two characters
        if (query.length() > 0) {
            String q = query.toLowerCase();

            int i = 0;
            int s = domainSuggestions.size();

            int count = 0;

            while (i < s && count < limit) {

                DomainSuggestion item = domainSuggestions.get(i);
                if (item.getDisplayString().toLowerCase().contains(q)) {
                    candidates.add(item);
                    count++;
                }
                i++;
            }

        }

        return candidates;
    }


    /**
     * @param o
     * @return
     * @see java.util.List#add(java.lang.Object)
     */
    public boolean add(String o) {
        if (domainSuggestions == null) {
            domainSuggestions = new ArrayList<DomainSuggestion>();
        }


        return domainSuggestions.add(new DomainSuggestion(o));
    }


    /**
     * @param o
     * @return
     * @see java.util.List#remove(java.lang.Object)
     */
    public boolean remove(Object o) {
        if (domainSuggestions != null) {
            return domainSuggestions.remove(o);
        }

        return false;
    }

}
