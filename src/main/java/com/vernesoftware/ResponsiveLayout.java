package com.vernesoftware;

import com.vaadin.annotations.StyleSheet;
import com.vernesoftware.StyledDocument.StyleAdapterCssLayout;

/**
 * Created by JarekToro on 9/23/16.
 */

@StyleSheet("styles.css")
public class ResponsiveLayout extends StyleAdapterCssLayout {


    public ResponsiveLayout() {
        super();
        setHeightUndefined();
        setWidth("100%");
    }


    public void addRow(Row row) {
        addComponent(row);
    }


}
