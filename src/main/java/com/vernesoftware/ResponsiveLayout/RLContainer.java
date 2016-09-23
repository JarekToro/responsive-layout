package com.vernesoftware.ResponsiveLayout;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;

/**
 * Created by JarekToro on 9/23/16.
 */
public class RLContainer extends CustomComponent {

    private CssLayout root;


    public RLContainer() {

        root = new CssLayout();
        root.setSizeFull();
        setCompositionRoot(root);
    }


    public void addRow(RLRow row) {
        root.addComponent(row);
    }


}
