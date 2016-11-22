package com.jarektoro.responsivelayout.Styleable;

import com.jarektoro.responsivelayout.ResponsiveLayout;
import com.jarektoro.responsivelayout.Styleable.CSSClassGroup;

/**
 * Created by jarektoro on 11/22/16.
 */


public class VisibilityCSSAdapter {


    private static final String CSS_VISIBLE_XS = "rl-visible-xs";
    private static final String CSS_VISIBLE_SM = "rl-visible-sm";
    private static final String CSS_VISIBLE_MD = "rl-visible-md";
    private static final String CSS_VISIBLE_LG = "rl-visible-lg";

    private static final String CSS_HIDDEN_XS = "rl-hidden-xs";
    private static final String CSS_HIDDEN_SM = "rl-hidden-sm";
    private static final String CSS_HIDDEN_MD = "rl-hidden-md";
    private static final String CSS_HIDDEN_LG = "rl-hidden-lg";

    public static CSSClassGroup xsClassGroup = new CSSClassGroup(CSS_VISIBLE_XS, CSS_HIDDEN_XS);
    public static CSSClassGroup smClassGroup = new CSSClassGroup(CSS_VISIBLE_SM, CSS_HIDDEN_SM);
    public static CSSClassGroup mdClassGroup = new CSSClassGroup(CSS_VISIBLE_MD, CSS_HIDDEN_MD);
    public static CSSClassGroup lgClassGroup = new CSSClassGroup(CSS_VISIBLE_LG, CSS_HIDDEN_LG);

    public ResponsiveLayout.DisplaySize displaySize;
    public boolean isVisible = false;

    public static String getCssForDisplaySize(ResponsiveLayout.DisplaySize displaySize, boolean isVisible) {
        if (isVisible) {
            switch (displaySize) {
                case XS:
                    return CSS_VISIBLE_XS;
                case SM:
                    return CSS_VISIBLE_SM;
                case MD:
                    return CSS_VISIBLE_MD;
                case LG:
                    return CSS_VISIBLE_LG;
                default:
                    return "";
            }
        } else {
            switch (displaySize) {
                case XS:
                    return CSS_HIDDEN_XS;
                case SM:
                    return CSS_HIDDEN_SM;
                case MD:
                    return CSS_HIDDEN_MD;
                case LG:
                    return CSS_HIDDEN_LG;
                default:
                    return " ";

            }
        }
    }
}
