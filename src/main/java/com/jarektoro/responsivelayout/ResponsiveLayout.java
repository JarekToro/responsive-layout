package com.jarektoro.responsivelayout;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.CssLayout;

/**
 * Created by JarekToro on 9/23/16.
 */

@StyleSheet("styles.css")
public class ResponsiveLayout extends CssLayout {


    // just about the same as a StyleAdpterCssLayout
    // mainly syntax diffs.
    public ResponsiveLayout() {
        super();
        setHeightUndefined();
        setWidth("100%");
    }


    //when size is set to full. It sets the css property 'overflow' to 'hidden'
    // this inhibits scrolling to counter act that you can set a boolean var to add scrolling
    public void setSizeFull(boolean scrollable) {
        super.setSizeFull();

        if (scrollable) {
            addStyleName("scrollable-anyway");
        } else {
            removeStyleName("scrollable-anyway");
        }

    }

    /**
     * Adds the {@code ResponsiveRow} provided as a component.
     *
     * @param responsiveRow A {@code ResponsiveRow}
     */
    public void addRow(ResponsiveRow responsiveRow) {
        addComponent(responsiveRow);
    }

    public ResponsiveRow addRow() {

        ResponsiveRow row = new ResponsiveRow();

        addComponent(row);

        return row;
    }

}
