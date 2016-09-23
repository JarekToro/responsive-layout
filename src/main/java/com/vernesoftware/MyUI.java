package com.vernesoftware;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vernesoftware.ResponsiveLayout.RLCol;
import com.vernesoftware.ResponsiveLayout.RLContainer;
import com.vernesoftware.ResponsiveLayout.RLRow;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {


        RLContainer container = new RLContainer();

        RLRow topRow = new RLRow();

        RLCol col1 = new RLCol();
        col1.addRule(RLCol.DisplaySize.SM, 6);
        col1.addRule(RLCol.DisplaySize.XS, 12);

        col1.setComponent(new Panel("hey"));

        topRow.addColumn(col1);


        RLCol col2 = new RLCol();
        col2.addRule(RLCol.DisplaySize.SM, 6);
        col2.addRule(RLCol.DisplaySize.XS, 6);

        col2.setComponent(new Panel("Whats up"));

        topRow.addColumn(col2);

        container.addRow(topRow);


        RLRow bottomRow = new RLRow();

        RLCol col3 = new RLCol();
        col3.addRule(RLCol.DisplaySize.SM, 3);
        col3.addRule(RLCol.DisplaySize.XS, 6);

        col3.setComponent(new Panel("hey"));

        bottomRow.addColumn(col3);


        RLCol col4 = new RLCol();
        col4.addRule(RLCol.DisplaySize.SM, 9);
        col4.addRule(RLCol.DisplaySize.XS, 6);

        col4.setComponent(new Panel("Whats up"));

        bottomRow.addColumn(col4);

        container.addRow(bottomRow);


        setContent(container);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
