package com.vernesoftware;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vernesoftware.ResponsiveLayout.RLColumn;
import com.vernesoftware.ResponsiveLayout.ResponsiveLayout;
import com.vernesoftware.ResponsiveLayout.RLRow;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Viewport("width=device-width, initial-scale=1") // this is necessary
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setSizeFull();


        ResponsiveLayout container = new ResponsiveLayout();

        RLRow navRow = new RLRow();

        RLColumn logoCol = new RLColumn(12, 3, 2);
        logoCol.setComponent(getButtonofSize("LOGO", "100%", "100%"));
        navRow.addColumn(logoCol);

        RLColumn homeCol = new RLColumn(12, 3);
        homeCol.setOffset(RLColumn.DisplaySize.MD, 1);
        homeCol.setComponent(getButtonofSize("Home", "100%", "100%"));
        navRow.addColumn(homeCol);

        RLColumn aboutCol = new RLColumn(12, 3);
        aboutCol.setComponent(getButtonofSize("About Us", "100%", "100%"));
        navRow.addColumn(aboutCol);

        RLColumn contactCol = new RLColumn(12, 3);
        contactCol.setComponent(getButtonofSize("Contact", "100%", "100%"));
        navRow.addColumn(contactCol);

        navRow.setHorizontalSpacing(0);
        container.addRow(navRow);


        RLRow titleRow = new RLRow();

        RLColumn titleCol = new RLColumn(12);
        titleCol.setComponent(getButtonofSize("Our Team", "100%", "100%"));
        titleRow.addColumn(titleCol);

        titleRow.setMargin(RLRow.MarginDirection.top, 50);

        container.addRow(titleRow);


        RLRow teamRow = new RLRow();

        for (int x = 0; x < 10; x++) {
            TeamMemberView teamMemberView = new TeamMemberView();
            teamRow.addColumn(teamMemberView.getInColumn(12, 6, 4, 3));
        }

        container.addRow(teamRow);
        //teamRow.setMargin(50);

        teamRow.setHorizontalSpacing(15);
        teamRow.setVerticalSpacing(15);

        setContent(container);
    }


    public Button getButtonofSize(String title, String h, String w) {
        Button button = new Button(title);
        button.setHeight(h);
        button.setWidth(w);

        return button;

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
