package com.jarektoro.responsivelayout;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.VerticalLayout;


/**
 * Created by JarekToro on 9/23/16.
 */
public class ResponsiveRow extends CssLayout {


    public enum MarginSize {
        NORMAL, SMALL
    }

    public enum SpacingSize {
        NORMAL, SMALL
    }

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

        super.addComponent(col);

    }


    public void setMargin(boolean margin) {


        if (margin) {
            addStyleName("margin");
        } else {
            removeStyleName("margin");
        }


    }


    public void setMargin(MarginSize marginSize, boolean margin) {

        if (margin){
            removeStyleName("margin");
            removeStyleName("margin-small");
            if (marginSize == MarginSize.NORMAL) {
                addStyleName("margin");

            } else if (marginSize == MarginSize.SMALL) {
                addStyleName("margin");
                addStyleName("margin-small");
            }
        }else{
            removeStyleName("margin");
            removeStyleName("margin-small");
        }


    }


    public void setSpacing(boolean spacing) {
        setVerticalSpacing(spacing);
        setHorizontalSpacing(spacing);
    }

    public void setSpacing(SpacingSize spacingSize, boolean spacing) {
        setVerticalSpacing(spacingSize,spacing);
        setHorizontalSpacing(spacingSize, spacing);
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

    public void setVerticalSpacing(SpacingSize spacingSize, boolean verticalSpacing) {




        if (verticalSpacing) {
            removeStyleName("v-col-spacing");
            removeStyleName("v-col-spacing-small");

            if (spacingSize == SpacingSize.NORMAL) {
                addStyleName("v-col-spacing");


            } else if (spacingSize == SpacingSize.SMALL) {
                addStyleName("v-col-spacing");
                addStyleName("v-col-spacing-small");
            }


        } else {

            removeStyleName("v-col-spacing");
            removeStyleName("v-col-spacing-small");

        }

    }

    public void setHorizontalSpacing(SpacingSize spacingSize, boolean horizontalSpacing) {



        if (horizontalSpacing) {
            removeStyleName("h-col-spacing");
            removeStyleName("h-col-spacing-small");

            if (spacingSize == SpacingSize.NORMAL) {
                addStyleName("h-col-spacing");


            } else if (spacingSize == SpacingSize.SMALL) {
                addStyleName("h-col-spacing");
                addStyleName("h-col-spacing-small");
            }


        } else {

            removeStyleName("h-col-spacing");
            removeStyleName("h-col-spacing-small");

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


    @Override public void addComponents(Component... components){

        for (Component component:components) {
            ResponsiveColumn col = new ResponsiveColumn().withComponent(component);
            col.setSizeUndefined();
            addColumn(col);
        }

    }
    @Override public void addComponent(Component component){

            ResponsiveColumn col = new ResponsiveColumn().withComponent(component);
            col.setSizeUndefined();
            addColumn(col);

    }
    // Convenience API

    public ResponsiveColumn addColumn() {
        ResponsiveColumn column = new ResponsiveColumn();
        addColumn(column);
        return column;
    }

    public ResponsiveRow withComponents(Component... components) {
        addComponents(components);
        return this;
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
        setMargin(MarginSize.SMALL,margin);;
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
