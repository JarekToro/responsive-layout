package com.vernesoftware.ResponsiveLayout;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;

/**
 * Created by JarekToro on 9/23/16.
 */
public class RLCol extends CustomComponent {


    public enum DisplaySize {
        XS, SM, MD, LG
    }


    public RLCol() {
        setPrimaryStyleName("col");


    }

    public void addRule(DisplaySize displaySize, int width) {

        setPrimaryStyleName("col");

        switch (displaySize) {
            case XS:
                addStyleName("xs-" + width);
                break;
            case SM:
                addStyleName("sm-" + width);
                break;
            case MD:
                addStyleName("md-" + width);
                break;
            case LG:
                addStyleName("lg-" + width);
                break;
            default:
                break;
        }


    }

    public void setComponent(Component component) {


        component.setSizeFull();
        component.setHeight("200px");

        setCompositionRoot(component);

    }


}
