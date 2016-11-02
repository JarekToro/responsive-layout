package com.jarektoro.responsivelayout;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.VerticalLayout;


/**
 * Created by JarekToro on 9/23/16.
 */
public class ResponsiveRow extends CssLayout {


    private static final String CSS_ROW = "rl-row";


    private static final String CSS_MARGIN = "margin";
    private static final String CSS_MARGIN_SMALL = "margin-small";

    private static final String CSS_V_COL_SPACING = "v-col-spacing";
    private static final String CSS_V_COL_SPACING_SMALL = "v-col-spacing-small";

    private static final String CSS_H_COL_SPACING = "h-col-spacing";
    private static final String CSS_H_COL_SPACING_SMALL = "h-col-spacing-small";

    private static final String CSS_ALIGNMENT_BOTTOM_LEFT = "rl-bottom-xs rl-start-xs";
    private static final String CSS_ALIGNMENT_BOTTOM_CENTER = "rl-bottom-xs rl-center-xs";
    private static final String CSS_ALIGNMENT_BOTTOM_RIGHT = "rl-bottom-xs rl-end-xs";

    private static final String CSS_ALIGNMENT_TOP_LEFT = "rl-top-xs rl-start-xs";
    private static final String CSS_ALIGNMENT_TOP_CENTER = "rl-top-xs rl-center-xs";
    private static final String CSS_ALIGNMENT_TOP_RIGHT = "rl-top-xs rl-end-xs";

    private static final String CSS_ALIGNMENT_MIDDLE_LEFT = "rl-middle-xs rl-start-xs";
    private static final String CSS_ALIGNMENT_MIDDLE_CENTER = "rl-middle-xs rl-center-xs";
    private static final String CSS_ALIGNMENT_MIDDLE_RIGHT = "rl-middle-xs rl-end-xs";

    public enum MarginSize {
        NORMAL, SMALL
    }

    public enum SpacingSize {
        NORMAL, SMALL
    }

    public ResponsiveRow() {

        setPrimaryStyleName(CSS_ROW);
        setWidthUndefined();
        addStyleName(CSS_MARGIN);


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
            setMargin(MarginSize.NORMAL, ResponsiveColumn.DisplaySize.XS, margin);
        } else {
            removeStyleName(CSS_MARGIN + "-xs");
        }


    }


    public void setMargin(MarginSize marginSize, ResponsiveColumn.DisplaySize displaySize, boolean margin) {

        String suffix = "";

        switch (displaySize) {
            case XS:
                suffix = "-xs";
                break;
            case SM:
                suffix = "-sm";
                break;
            case MD:
                suffix = "-md";
                break;
            case LG:
                suffix = "-lg";
                break;
        }

        if (margin) {
            removeStyleName(CSS_MARGIN + suffix);
            removeStyleName(CSS_MARGIN + suffix +"-"+ CSS_MARGIN_SMALL + suffix);
            if (marginSize == MarginSize.NORMAL) {
                addStyleName(CSS_MARGIN + suffix);


            } else if (marginSize == MarginSize.SMALL) {
                addStyleName(CSS_MARGIN + suffix);
                addStyleName(CSS_MARGIN + suffix +"-"+ CSS_MARGIN_SMALL + suffix);
            }
        } else {
            removeStyleName(CSS_MARGIN + suffix);
            removeStyleName(CSS_MARGIN + suffix +"-"+ CSS_MARGIN_SMALL + suffix);
        }


    }


    public void setSpacing(boolean spacing) {
        setVerticalSpacing(spacing);
        setHorizontalSpacing(spacing);
    }

    public void setSpacing(SpacingSize spacingSize, boolean spacing) {
        setVerticalSpacing(spacingSize, spacing);
        setHorizontalSpacing(spacingSize, spacing);
    }

    public void setVerticalSpacing(boolean verticalSpacing) {


        if (verticalSpacing) {
            addStyleName(CSS_V_COL_SPACING);
        } else {
            removeStyleName(CSS_V_COL_SPACING);
        }

    }

    public void setHorizontalSpacing(boolean horizontalSpacing) {


        if (horizontalSpacing) {
            addStyleName(CSS_H_COL_SPACING);
        } else {
            removeStyleName(CSS_H_COL_SPACING);
        }


    }

    public void setVerticalSpacing(SpacingSize spacingSize, boolean verticalSpacing) {


        if (verticalSpacing) {
            removeStyleName(CSS_V_COL_SPACING);
            removeStyleName(CSS_V_COL_SPACING_SMALL);

            if (spacingSize == SpacingSize.NORMAL) {
                addStyleName(CSS_V_COL_SPACING);


            } else if (spacingSize == SpacingSize.SMALL) {
                addStyleName(CSS_V_COL_SPACING);
                addStyleName(CSS_V_COL_SPACING_SMALL);
            }


        } else {

            removeStyleName(CSS_V_COL_SPACING);
            removeStyleName(CSS_V_COL_SPACING_SMALL);

        }

    }

    public void setHorizontalSpacing(SpacingSize spacingSize, boolean horizontalSpacing) {


        if (horizontalSpacing) {
            removeStyleName(CSS_H_COL_SPACING);
            removeStyleName(CSS_H_COL_SPACING_SMALL);

            if (spacingSize == SpacingSize.NORMAL) {
                addStyleName(CSS_H_COL_SPACING);


            } else if (spacingSize == SpacingSize.SMALL) {
                addStyleName(CSS_H_COL_SPACING);
                addStyleName(CSS_H_COL_SPACING_SMALL);
            }


        } else {

            removeStyleName(CSS_H_COL_SPACING);
            removeStyleName(CSS_H_COL_SPACING_SMALL);

        }


    }


    public void setDefaultComponentAlignment(Alignment defaultAlignment) {

        //Makes use of the Alignment Property Vaadin already made and converts it to the Css Style Name

        removeStyleName(CSS_ALIGNMENT_BOTTOM_LEFT);
        removeStyleName(CSS_ALIGNMENT_BOTTOM_CENTER);
        removeStyleName(CSS_ALIGNMENT_BOTTOM_RIGHT);

        removeStyleName(CSS_ALIGNMENT_TOP_LEFT);
        removeStyleName(CSS_ALIGNMENT_TOP_CENTER);
        removeStyleName(CSS_ALIGNMENT_TOP_RIGHT);

        removeStyleName(CSS_ALIGNMENT_MIDDLE_LEFT);
        removeStyleName(CSS_ALIGNMENT_MIDDLE_CENTER);
        removeStyleName(CSS_ALIGNMENT_MIDDLE_RIGHT);

        if (defaultAlignment.equals(Alignment.BOTTOM_LEFT)) {

            addStyleName(CSS_ALIGNMENT_BOTTOM_LEFT);

        } else if (defaultAlignment.equals(Alignment.BOTTOM_CENTER)) {

            addStyleName(CSS_ALIGNMENT_BOTTOM_CENTER);

        } else if (defaultAlignment.equals(Alignment.BOTTOM_RIGHT)) {

            addStyleName(CSS_ALIGNMENT_BOTTOM_RIGHT);

        } else if (defaultAlignment.equals(Alignment.TOP_LEFT)) {

            addStyleName(CSS_ALIGNMENT_TOP_LEFT);

        } else if (defaultAlignment.equals(Alignment.TOP_CENTER)) {

            addStyleName(CSS_ALIGNMENT_TOP_CENTER);

        } else if (defaultAlignment.equals(Alignment.TOP_RIGHT)) {

            addStyleName(CSS_ALIGNMENT_TOP_RIGHT);

        } else if (defaultAlignment.equals(Alignment.MIDDLE_LEFT)) {

            addStyleName(CSS_ALIGNMENT_MIDDLE_LEFT);

        } else if (defaultAlignment.equals(Alignment.MIDDLE_CENTER)) {

            addStyleName(CSS_ALIGNMENT_MIDDLE_CENTER);

        } else if (defaultAlignment.equals(Alignment.MIDDLE_RIGHT)) {

            addStyleName(CSS_ALIGNMENT_MIDDLE_RIGHT);

        }


    }


    @Override
    public void addComponents(Component... components) {

        for (Component component : components) {
            ResponsiveColumn col = new ResponsiveColumn().withComponent(component);
            col.setSizeUndefined();
            addColumn(col);
        }

    }

    @Override
    public void addComponent(Component component) {

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

    public ResponsiveRow withMargin(MarginSize size, ResponsiveColumn.DisplaySize displaySize, boolean margin) {
        setMargin(size,displaySize, margin);
        return this;
    }

    public ResponsiveRow withSpacing(boolean spacing) {
        setVerticalSpacing(spacing);
        setHorizontalSpacing(spacing);
        return this;
    }

    public ResponsiveRow withSpacing(SpacingSize size, boolean spacing) {
        setSpacing(size, spacing);
        return this;
    }

    public ResponsiveRow withVerticalSpacing(boolean spacing) {
        setVerticalSpacing(spacing);
        return this;
    }

    public ResponsiveRow withVerticalSpacing(SpacingSize size, boolean spacing) {
        setVerticalSpacing(size, spacing);
        return this;
    }

    public ResponsiveRow withHorizontalSpacing(boolean spacing) {
        setHorizontalSpacing(spacing);
        return this;
    }

    public ResponsiveRow withHorizontalSpacing(SpacingSize size, boolean spacing) {
        setHorizontalSpacing(size, spacing);
        return this;
    }


}
