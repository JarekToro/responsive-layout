package com.vernesoftware;

import com.vaadin.ui.Alignment;
import com.vernesoftware.StyledDocument.StyleAdapterCssLayout;
import com.vernesoftware.StyledDocument.StyleDocument;
import com.vernesoftware.StyledDocument.StyleDocumentAdapter;


/**
 * Created by JarekToro on 9/23/16.
 */
public class Row extends StyleAdapterCssLayout implements StyleDocumentAdapter {

    private int margin_top = 0;
    private int margin_bottom = 0;
    private int margin_left = 0;
    private int margin_right = 0;
    private int horizontalSpacing = 0;
    private int verticalSpacing = 0;

    public StyleDocument styleDocument;

    public StyleDocument getStyleDocument() {
        return styleDocument;
    }

    public void setStyleDocument(StyleDocument styleDocument) {
        this.styleDocument = styleDocument;
    }


    public Row() {


        setPrimaryStyleName("row");
        setWidthUndefined();
        this.styleDocument = new StyleDocument();

        //set default 0px margin
        setMargin(MarginDirection.all, margin_top);

    }




    public int getVerticalSpacing() {
        return verticalSpacing;
    }

    public int getHorizontalSpacing() {
        return horizontalSpacing;
    }


    public void addColumn(Column col) {

        //add Column to Component List then recalulates the margin and spacing to match

        addComponent(col);

        setMargin(MarginDirection.left, margin_left);
        setMargin(MarginDirection.right, margin_right);
        setMargin(MarginDirection.top, margin_top);
        setMargin(MarginDirection.bottom, margin_bottom);
        setVerticalSpacing(verticalSpacing);
        setHorizontalSpacing(horizontalSpacing);
    }


    public interface MarginDirection {

        String all = "all";
        String top = "top";
        String bottom = "bottom";
        String right = "right";
        String left = "left";

    }

    public void setMargin(String marginDirection, int pixals) {

        // Adds the margin property to the StyleDocument of the Row -See StyleDocument Class

        switch (marginDirection) {
            case MarginDirection.all:
                this.getStyleDocument().addCssProperty("margin", pixals + "px");
                margin_top = (pixals - (verticalSpacing/2));
                margin_bottom = (pixals - (verticalSpacing/2));
                margin_left = (pixals - (horizontalSpacing/2));
                margin_right = (pixals - (horizontalSpacing/2));
                break;

            case MarginDirection.top:
                this.getStyleDocument().addCssProperty("margin-" + marginDirection, (pixals - (verticalSpacing/2)) + "px");
                margin_top = pixals;

                break;
            case MarginDirection.bottom:
                this.getStyleDocument().addCssProperty("margin-" + marginDirection, (pixals - (verticalSpacing/2)) + "px");
                margin_bottom = pixals;
                break;

            case MarginDirection.left:
                this.getStyleDocument().addCssProperty("margin-" + marginDirection, (pixals - (horizontalSpacing/2)) + "px");
                margin_left = pixals;

                break;
            case MarginDirection.right:
                this.getStyleDocument().addCssProperty("margin-" + marginDirection, (pixals - (horizontalSpacing/2)) + "px");
                margin_right = pixals;

                break;

            default:
                break;
        }


    }

    public void setVerticalSpacing(int pixals) {

        // sets padding on each of the children to add spacing between them

        verticalSpacing = pixals;
        components.forEach(component -> {

            setMargin(MarginDirection.top, margin_top);
            setMargin(MarginDirection.bottom, margin_bottom);
            StyleDocumentAdapter cssModalComponant = getStyledDocumentAdapter(component);

            cssModalComponant.getStyleDocument().addCssProperty("padding-top", (verticalSpacing / 2) + "px");
            cssModalComponant.getStyleDocument().addCssProperty("padding-bottom", (verticalSpacing / 2) + "px");

            return;

        });

    }

    public void setHorizontalSpacing(int pixals) {

        // sets padding on each of the children to add spacing between them


        horizontalSpacing = pixals;

        setMargin(MarginDirection.left, margin_left);
        setMargin(MarginDirection.right, margin_right);

        components.forEach(component -> {

            StyleDocumentAdapter cssModalComponant = getStyledDocumentAdapter(component);

            cssModalComponant.getStyleDocument().addCssProperty("padding-right", (horizontalSpacing / 2) + "px");
            cssModalComponant.getStyleDocument().addCssProperty("padding-left", (horizontalSpacing / 2) + "px");

            return;

        });

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

}
