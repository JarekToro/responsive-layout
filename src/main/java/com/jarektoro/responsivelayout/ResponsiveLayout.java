package com.jarektoro.responsivelayout;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.CssLayout;

/**
 * Created by JarekToro on 9/23/16.
 */

@StyleSheet("styles.css")
public class ResponsiveLayout extends CssLayout {

    public enum ContainerType {
        FIXED, FLUID
    }


    public ResponsiveLayout(ContainerType containerType) {
        super();
        setHeightUndefined();
        setContainerType(containerType);
    }

    public ResponsiveLayout() {
        super();
        setHeightUndefined();
    }

    public void setContainerType(ContainerType containerType) {
        if (containerType == ContainerType.FLUID) {
            setStyleName("container-fluid");
        } else if (containerType == ContainerType.FIXED) {
            setStyleName("container");

        }
    }


    public void setScrollable(boolean scrollable) {
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
