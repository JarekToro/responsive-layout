package com.vernesoftware.ResponsiveLayout;

import com.vernesoftware.ResponsiveLayout.StyledDocument.StyleDocument;
import com.vernesoftware.ResponsiveLayout.StyledDocument.StyleDocumentAdapter;

/**
 * Created by JarekToro on 9/23/16.
 */
public class Row extends StyleAdapterCssLayout implements StyleDocumentAdapter {


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

        setMargin(MarginDirection.all, margin_top);
//        setMargin(MarginDirection.bottom, margin_bottom);
//        setMargin(MarginDirection.right, margin_right);
//        setMargin(MarginDirection.left, margin_left);
//        setVerticalSpacing(verticalSpacing);
//        setHorizontalSpacing(horizontalSpacing);
    }

    private int margin_top = 0;
    private int margin_bottom = 0;
    private int margin_left = 0;
    private int margin_right = 0;

    private int horizontalSpacing = 0;
    private int verticalSpacing = 0;


    public int getVerticalSpacing() {
        return verticalSpacing;
    }

    public int getHorizontalSpacing() {
        return horizontalSpacing;
    }


    public void addColumn(Column col) {

        addComponent(col);
    }


    public interface MarginDirection {

        String all = "all";
        String top = "top";
        String bottom = "bottom";
        String right = "right";
        String left = "left";

    }

    public void setMargin(String marginDirection, int pixals) {

        switch (marginDirection) {
            case MarginDirection.all:
                this.getStyleDocument().addCssProperty("margin", pixals + "px");
                margin_top = (pixals - (verticalSpacing));
                margin_bottom = (pixals - (verticalSpacing));
                margin_left = (pixals - (horizontalSpacing));
                margin_right = (pixals - (horizontalSpacing));
                break;

            case MarginDirection.top:
                this.getStyleDocument().addCssProperty("margin-" + marginDirection, (pixals - (verticalSpacing)) + "px");
                margin_top = pixals;

                break;
            case MarginDirection.bottom:
                this.getStyleDocument().addCssProperty("margin-" + marginDirection, (pixals - (verticalSpacing)) + "px");
                margin_bottom = pixals;
                break;

            case MarginDirection.left:
                this.getStyleDocument().addCssProperty("margin-" + marginDirection, (pixals - (horizontalSpacing)) + "px");
                margin_left = pixals;

                break;
            case MarginDirection.right:
                this.getStyleDocument().addCssProperty("margin-" + marginDirection, (pixals - (horizontalSpacing)) + "px");
                margin_right = pixals;

                break;

            default:
                break;
        }


    }


    public void setVerticalSpacing(int pixals) {

        verticalSpacing = pixals;
        components.forEach(component -> {

            setMargin(MarginDirection.top, margin_top);
            setMargin(MarginDirection.bottom, margin_bottom);
            StyleDocumentAdapter cssModalComponant = getStyledDocumentAdapter(component);

            cssModalComponant.getStyleDocument().addCssProperty("padding-top", (pixals / 2) + "px");
            cssModalComponant.getStyleDocument().addCssProperty("padding-bottom", (pixals / 2) + "px");

            return;

        });

    }

    public void setHorizontalSpacing(int pixals) {


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

}
