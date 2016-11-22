package com.jarektoro.responsivelayout.Styleable;


import com.jarektoro.responsivelayout.ResponsiveLayout;
import com.vaadin.ui.CustomComponent;

/**
 * Created by jarektoro on 11/22/16.
 */
public class StyleableComponent extends CustomComponent {

    public StyleableComponent() {


    }

    public boolean isVisibleForDisplaySize(ResponsiveLayout.DisplaySize displaySize) {
        if (displaySize == ResponsiveLayout.DisplaySize.XS) {
            for (String clazz : VisibilityCSSAdapter.xsClassGroup.classes) {

                String styles = getStyleName();
                if (styles.contains(clazz)) {
                    if (clazz.contains("hidden")) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        } else if (displaySize == ResponsiveLayout.DisplaySize.SM) {
            for (String clazz : VisibilityCSSAdapter.smClassGroup.classes) {
                if (getStyleName().contains(clazz)) {
                    if (clazz.contains("hidden")) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        } else if (displaySize == ResponsiveLayout.DisplaySize.MD) {
            for (String clazz : VisibilityCSSAdapter.mdClassGroup.classes) {
                if (getStyleName().contains(clazz)) {
                    if (clazz.contains("hidden")) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        } else if (displaySize == ResponsiveLayout.DisplaySize.LG) {
            for (String clazz : VisibilityCSSAdapter.lgClassGroup.classes) {
                if (getStyleName().contains(clazz)) {
                    if (clazz.contains("hidden")) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return true;
    }

    public void setVisibility(ResponsiveLayout.DisplaySize displaySize, boolean isVisible) {

        if (displaySize == ResponsiveLayout.DisplaySize.XS) {
            for (String clazz : VisibilityCSSAdapter.xsClassGroup.classes) {
                removeStyleName(clazz);
            }
        }
        if (displaySize == ResponsiveLayout.DisplaySize.SM) {
            for (String clazz : VisibilityCSSAdapter.smClassGroup.classes) {
                removeStyleName(clazz);
            }
        }
        if (displaySize == ResponsiveLayout.DisplaySize.MD) {
            for (String clazz : VisibilityCSSAdapter.mdClassGroup.classes) {
                removeStyleName(clazz);
            }
        }
        if (displaySize == ResponsiveLayout.DisplaySize.LG) {
            for (String clazz : VisibilityCSSAdapter.lgClassGroup.classes) {
                removeStyleName(clazz);
            }
        }


        addStyleName(VisibilityCSSAdapter.getCssForDisplaySize(displaySize, isVisible));


    }
}
