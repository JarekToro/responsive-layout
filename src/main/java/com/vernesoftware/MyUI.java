package com.vernesoftware;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.vernesoftware.Column;
import com.vernesoftware.ResponsiveLayout;
import com.vernesoftware.Row;
import com.vernesoftware.TeamMemberView;


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

        Row navRow = new Row();
        navRow.setMargin(Row.MarginDirection.top,15);

        Column logoCol = new Column(12, 3, 2);
        logoCol.setComponent(getButtonofSize("LOGO", "100%", "100%"));
        navRow.addColumn(logoCol);

        Column homeCol = new Column(12, 3);
        homeCol.setOffset(Column.DisplaySize.MD, 1);
        homeCol.setComponent(getButtonofSize("Home", "100%", "100%"));
        navRow.addColumn(homeCol);

        Column aboutCol = new Column(12, 3);
        aboutCol.setComponent(getButtonofSize("About Us", "100%", "100%"));
        navRow.addColumn(aboutCol);

        Column contactCol = new Column(12, 3);
        contactCol.setComponent(getButtonofSize("Contact", "100%", "100%"));
        navRow.addColumn(contactCol);

        navRow.setHorizontalSpacing(15);


        container.addRow(navRow);


        Row titleRow = new Row();

        Column titleCol = new Column(3);

        titleCol.addStyleName("content-center");
        Label title = new Label("Our Team");
title.setWidthUndefined();

        titleCol.setComponent(title);
        titleRow.addColumn(titleCol);
        titleRow.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        titleRow.setMargin(Row.MarginDirection.top, 50);

        container.addRow(titleRow);


        Row teamRow = new Row();

        for (int x = 0; x < 10; x++) {
            TeamMemberView teamMemberView = new TeamMemberView();
            teamRow.addColumn(teamMemberView.getInColumn(12, 6, 4, 3));
        }

        container.addRow(teamRow);
        //teamRow.setMargin(50);

        teamRow.setHorizontalSpacing(15);
        teamRow.setVerticalSpacing(15);
        teamRow.setMargin(Row.MarginDirection.all, 50);
        setContent(container);
    }


    public Button getButtonofSize(String title, String h, String w) {
        Button button = new Button(title);
        button.setStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
        button.setIcon(FontAwesome.APPLE);
        button.setHeight(h);
        button.setWidth(w);

        return button;

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
