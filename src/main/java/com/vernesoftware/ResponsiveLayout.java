package com.vernesoftware;

import com.vaadin.annotations.StyleSheet;
import com.vernesoftware.StyledDocument.StyleAdapterCssLayout;

/**
 * Created by JarekToro on 9/23/16.
 */

@StyleSheet("styles.css")
public class ResponsiveLayout extends StyleAdapterCssLayout {


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
            setStyleName("scrollable-anyway");
        } else {
            removeStyleName("scrollable-anyway");
        }

    }

    /**
     * Adds the {@code Row} provided as a component.
     *
     * @param row A {@code Row}
     */
    public void addRow(Row row) {
        addComponent(row);
    }


}
