package com.jarektoro.responsivelayout.Styleable;


import com.jarektoro.responsivelayout.ResponsiveLayout;
import com.vaadin.ui.CustomComponent;

/**
 * Created by jarektoro on 11/22/16.
 */
public class StyleableComponent extends CustomComponent {

	private static final long serialVersionUID = -5820909402047704207L;
	
	private final VisibilityCSSAdapter visibilityCSSAdapter;

    public StyleableComponent() {

        visibilityCSSAdapter = new VisibilityCSSAdapter(this);
    }

    public boolean isVisibleForDisplaySize(ResponsiveLayout.DisplaySize displaySize) {
        return visibilityCSSAdapter.isVisibleForDisplaySize(displaySize);
    }

    public void setVisibility(ResponsiveLayout.DisplaySize displaySize, boolean isVisible) {
        visibilityCSSAdapter.setVisibility(displaySize, isVisible);
    }
}
