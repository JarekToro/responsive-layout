package com.vernesoftware.ResponsiveLayout;

import com.sun.rowset.internal.Row;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vernesoftware.ResponsiveLayout.cssModal.CssModal;

/**
 * Created by JarekToro on 9/23/16.
 */
public class RLRow extends RLCssLayout {


    public RLRow() {
        setPrimaryStyleName("row");
        setWidthUndefined();
    }

    private int margin = 0;
    private int horizontalSpacing = 0;
    private int verticalSpacing = 0;

    public int getVerticalSpacing() {
        return verticalSpacing;
    }

    public int getHorizontalSpacing() {
        return horizontalSpacing;
    }


    public CssModal myCssModal;


    public void addColumn(RLCol col) {

        addComponent(col);
    }


    public void setMargin(int pixals) {
        margin = pixals;
        if (myCssModal != null) {
            myCssModal.addCssProperty("margin", pixals + "px");
        }
    }

    public void setCssModal(CssModal cssModal) {
        this.myCssModal = cssModal;
        setMargin(margin);
        setVerticalSpacing(verticalSpacing);
        setHorizontalSpacing(horizontalSpacing);
    }


    public void setVerticalSpacing(int pixals) {

        verticalSpacing = pixals;
        components.forEach(component -> {


            CssModal cssModal = cssModalHashMap.get(getComponentIndex(component));


            if (cssModal == null) {
                cssModal = new CssModal();
            }

            cssModal.addCssProperty("padding-top", (pixals / 2) + "px");
            cssModal.addCssProperty("padding-bottom", (pixals / 2) + "px");
            setCssModalForComponant(cssModal, components.indexOf(component));
            return;

        });

    }

    public void setHorizontalSpacing(int pixals) {


        horizontalSpacing = pixals;

        setMargin(margin - (pixals));

        components.forEach(component -> {


            CssModal cssModal = cssModalHashMap.get(getComponentIndex(component));


            if (cssModal == null) {
                cssModal = new CssModal();
            }

            cssModal.addCssProperty("padding-right", (pixals / 2) + "px");
            cssModal.addCssProperty("padding-left", (pixals / 2) + "px");
            setCssModalForComponant(cssModal, components.indexOf(component));
            return;

        });

    }

}
