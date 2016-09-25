package com.vernesoftware.ResponsiveLayout;

import com.vernesoftware.ResponsiveLayout.cssModal.CssModal;

/**
 * Created by JarekToro on 9/23/16.
 */
public class RLRow extends RLCssLayout {


    public RLRow() {
        setPrimaryStyleName("row");
        setWidthUndefined();
    }

    private int margin_top = 0;
    private int margin_bottom = 0;
    private int margin_left = 0;
    private int margin_right = 0;

    private int horizontalSpacing = 0;
    private int verticalSpacing = 0;

    private CssModal myCssModal;

    public int getVerticalSpacing() {
        return verticalSpacing;
    }

    public int getHorizontalSpacing() {
        return horizontalSpacing;
    }


    public void addColumn(RLColumn col) {

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


        if (myCssModal == null) {
            switch (marginDirection) {
                case MarginDirection.all:
                    margin_top = pixals;
                    margin_bottom = pixals;
                    margin_left = pixals;
                    margin_right = pixals;
                    break;

                case MarginDirection.top:
                    margin_top = pixals;

                    break;
                case MarginDirection.bottom:
                    margin_bottom = pixals;
                    break;

                case MarginDirection.left:
                    margin_left = pixals;

                    break;
                case MarginDirection.right:
                    margin_right = pixals;

                    break;

                default:
                    break;
            }
            return;
        }

        switch (marginDirection) {
            case MarginDirection.all:
                myCssModal.addCssProperty("margin", pixals + "px");
                margin_top = pixals;
                margin_bottom = pixals;
                margin_left = pixals;
                margin_right = pixals;
                break;

            case MarginDirection.top:
                myCssModal.addCssProperty("margin-" + marginDirection, pixals + "px");
                margin_top = pixals;

                break;
            case MarginDirection.bottom:
                myCssModal.addCssProperty("margin-" + marginDirection, pixals + "px");
                margin_bottom = pixals;
                break;

            case MarginDirection.left:
                myCssModal.addCssProperty("margin-" + marginDirection, pixals + "px");
                margin_left = pixals;

                break;
            case MarginDirection.right:
                myCssModal.addCssProperty("margin-" + marginDirection, pixals + "px");
                margin_right = pixals;

                break;

            default:
                break;
        }


    }

    public void setCssModal(CssModal cssModal) {
        this.myCssModal = cssModal;
        setMargin(MarginDirection.top, margin_top);
        setMargin(MarginDirection.bottom, margin_bottom);
        setMargin(MarginDirection.right, margin_right);
        setMargin(MarginDirection.left, margin_left);

        setVerticalSpacing(verticalSpacing);
        setHorizontalSpacing(horizontalSpacing);
    }


    public void setVerticalSpacing(int pixals) {

        verticalSpacing = pixals;
        components.forEach(component -> {


            CssModal cssModal = getCssModalForComponant(component);

            cssModal.addCssProperty("padding-top", (pixals / 2) + "px");
            cssModal.addCssProperty("padding-bottom", (pixals / 2) + "px");

            return;

        });

    }

    public void setHorizontalSpacing(int pixals) {


        horizontalSpacing = pixals;

        setMargin(MarginDirection.left, margin_left - (horizontalSpacing));
        setMargin(MarginDirection.right, margin_right - (horizontalSpacing));

        components.forEach(component -> {

            CssModal cssModal = getCssModalForComponant(component);

            cssModal.addCssProperty("padding-right", (horizontalSpacing / 2) + "px");
            cssModal.addCssProperty("padding-left", (horizontalSpacing / 2) + "px");

            return;

        });

    }

}
