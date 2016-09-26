package com.vernesoftware.ResponsiveLayout;

import com.vernesoftware.ResponsiveLayout.StyledDocument.StyleAdapterCssLayout;

/**
 * Created by JarekToro on 9/23/16.
 */
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
