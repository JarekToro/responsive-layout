package com.jarektoro.responsivelayout.Styleable;

import com.jarektoro.responsivelayout.ResponsiveLayout;
import com.vaadin.ui.CssLayout;

/**
 * Created by jarektoro on 11/22/16.
 */
public class StyleableLayout extends CssLayout {

	private static final long serialVersionUID = -7409720799484798627L;
	
	private final VisibilityCSSAdapter visibilityCSSAdapter;

    public StyleableLayout() {
        visibilityCSSAdapter = new VisibilityCSSAdapter(this);
    }

    public boolean isVisibleForDisplaySize(ResponsiveLayout.DisplaySize displaySize) {
        return visibilityCSSAdapter.isVisibleForDisplaySize(displaySize);
    }

    public void setVisibility(ResponsiveLayout.DisplaySize displaySize, boolean isVisible) {
        visibilityCSSAdapter.setVisibility(displaySize, isVisible);
    }
}
