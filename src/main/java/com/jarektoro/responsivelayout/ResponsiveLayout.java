package com.jarektoro.responsivelayout;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.CssLayout;

/**
 * Created by JarekToro on 9/23/16.
 */

@StyleSheet("styles.css")
public class ResponsiveLayout extends CssLayout {


    private static final String CSS_CONTAINER = "rl-container";
    private static final String CSS_CONTAINER_FLUID = "fluid";
    private static final String CSS_CONTAINER_FIXED = "fixed";
    private static final String CSS_CONTAINER_SCROLLABLE = "scrollable";

    public enum DisplaySize {
        XS, SM, MD, LG
    }


    public enum ContainerType {
        FIXED, FLUID
    }


    public ResponsiveLayout(ContainerType containerType) {
        super();
        setHeightUndefined();
        setPrimaryStyleName(CSS_CONTAINER);
        setContainerType(containerType);
    }

    public ResponsiveLayout() {
        super();
        setHeightUndefined();
        setPrimaryStyleName(CSS_CONTAINER);
        setContainerType(ContainerType.FLUID);
    }

    public void setContainerType(ContainerType containerType) {
        removeStyleName(CSS_CONTAINER_FIXED);
        removeStyleName(CSS_CONTAINER_FLUID);

        if (containerType == ContainerType.FLUID) {
            addStyleName(CSS_CONTAINER_FLUID);
        } else if (containerType == ContainerType.FIXED) {
            addStyleName(CSS_CONTAINER_FIXED);

        }
    }


    public void setScrollable(boolean scrollable) {
        if (scrollable) {
            addStyleName(CSS_CONTAINER_SCROLLABLE);
        } else {
            removeStyleName(CSS_CONTAINER_SCROLLABLE);
        }
    }
    
    public ResponsiveLayout withStyleName(String styleName) {
        addStyleName(styleName); 
        return this; 
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
