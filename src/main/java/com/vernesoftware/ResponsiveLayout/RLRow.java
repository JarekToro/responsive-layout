package com.vernesoftware.ResponsiveLayout;

import com.sun.rowset.internal.Row;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;

/**
 * Created by JarekToro on 9/23/16.
 */
public class RLRow extends CustomComponent {


    private CssLayout root;

    public RLRow() {
        root = new CssLayout();
        root.setPrimaryStyleName("row");
        root.setWidth("100%");
        setCompositionRoot(root);


    }

    public void addColumn(RLCol col) {

        root.addComponent(col);

    }


}
