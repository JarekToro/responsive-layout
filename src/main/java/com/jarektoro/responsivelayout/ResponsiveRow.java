package com.jarektoro.responsivelayout;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.VerticalLayout;


/**
 * Created by JarekToro on 9/23/16.
 */
public class ResponsiveRow extends CssLayout {


    public ResponsiveRow() {


        setPrimaryStyleName("row");
        setWidthUndefined();


        VerticalLayout verticalLayout = new VerticalLayout();
    }


    public void setExpandRatio(ResponsiveColumn responsiveColumn, ResponsiveColumn.DisplaySize displaySize, int width) {
        if (components.contains(responsiveColumn)) {
            responsiveColumn.addRule(displaySize, width);
        }
    }


    public void addColumn(ResponsiveColumn col) {

        //add ResponsiveColumn to Component List then recalulates the margin and spacing to match

        addComponent(col);

    }


    public void setMargin(boolean margin) {


        if (margin) {
            addStyleName("margin");
        } else {
            removeStyleName("margin");
        }


    }

    public void setMarginSmall(boolean small) {


        if (small) {
            addStyleName("margin-small");
        } else {
            removeStyleName("margin-small");
        }


    }

    public void setSpacing(boolean spacing) {
        setVerticalSpacing(spacing);
        setHorizontalSpacing(spacing);
    }

    public void setVerticalSpacing(boolean verticalSpacing) {


        if (verticalSpacing) {
            addStyleName("v-col-spacing");
        } else {
            removeStyleName("v-col-spacing");
        }

    }

    public void setHorizontalSpacing(boolean horizontalSpacing) {


        if (horizontalSpacing) {
            addStyleName("h-col-spacing");
        } else {
            removeStyleName("h-col-spacing");
        }


    }

    public void setDefaultComponentAlignment(Alignment defaultAlignment) {


        //Makes use of the Alignment Property Vaadin already made and converts it to the Css Style Name

        removeStyleName("top-xs middle-xs bottom-xs start-xs center-xs end-xs");

        if (defaultAlignment.equals(Alignment.BOTTOM_LEFT)) {

            addStyleName("bottom-xs start-xs");

        } else if (defaultAlignment.equals(Alignment.BOTTOM_CENTER)) {

            addStyleName("bottom-xs center-xs");

        } else if (defaultAlignment.equals(Alignment.BOTTOM_RIGHT)) {

            addStyleName("bottom-xs end-xs");

        } else if (defaultAlignment.equals(Alignment.TOP_LEFT)) {

            addStyleName("top-xs start-xs");

        } else if (defaultAlignment.equals(Alignment.TOP_CENTER)) {

            addStyleName("top-xs center-xs");

        } else if (defaultAlignment.equals(Alignment.TOP_RIGHT)) {

            addStyleName("top-xs end-xs");

        } else if (defaultAlignment.equals(Alignment.MIDDLE_LEFT)) {

            addStyleName("middle-xs start-xs");

        } else if (defaultAlignment.equals(Alignment.MIDDLE_CENTER)) {

            addStyleName("middle-xs center-xs");

        } else if (defaultAlignment.equals(Alignment.MIDDLE_RIGHT)) {

            addStyleName("middle-xs end-xs");

        }


    }


    // Convenience API

    public ResponsiveColumn addColumn() {
        ResponsiveColumn column = new ResponsiveColumn();
        addColumn(column);
        return column;
    }

    public ResponsiveRow withAlignment(Alignment alignment) {
        setDefaultComponentAlignment(alignment);
        return this;
    }

    public ResponsiveRow withMargin(boolean margin) {
        setMargin(margin);
        return this;
    }

    public ResponsiveRow withSmallMargin(boolean margin) {
        setMargin(margin);
        setMarginSmall(margin);
        return this;
    }

    public ResponsiveRow withSpacing(boolean spacing) {
        setVerticalSpacing(spacing);
        setHorizontalSpacing(spacing);
        return this;
    }

    public ResponsiveRow withVerticalSpacing(boolean spacing) {
        setVerticalSpacing(spacing);
        return this;
    }

    public ResponsiveRow withHorizontalSpacing(boolean spacing) {
        setHorizontalSpacing(spacing);
        return this;
    }

}
