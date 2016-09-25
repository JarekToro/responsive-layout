package com.vernesoftware.ResponsiveLayout;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vernesoftware.ResponsiveLayout.cssModal.CssModal;

/**
 * Created by JarekToro on 9/23/16.
 */
public class ResponsiveLayout extends RLCssLayout {


    public ResponsiveLayout() {
        super();
        setHeightUndefined();
        setSizeFull();
    }


    public void addRow(RLRow row) {
        addComponent(row);
        giveStyleControlToRow(row);
    }


    //Container is a cssLayout which gives it control of the css of its children.
    //so if you wanted to set the margin of each individual row you would have to go through ResponsiveLayout
    //but i think usage-wise using: Row row.setMargin(15); if better and easier to read then Container.setMarginforRow(row,15);
    public void giveStyleControlToRow(RLRow row) {


        CssModal cssModal = new CssModal();

        setCssModalForComponant(cssModal, components.indexOf(row));

        row.setCssModal(cssModal);

        return;

    }


}
