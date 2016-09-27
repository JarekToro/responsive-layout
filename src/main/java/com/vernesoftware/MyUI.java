package com.vernesoftware;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Random;


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
        container.setHeight("100%");

        Row layoutRow = new Row();

        layoutRow.setHeight("100%");
        Column menuCol = new Column(12, 12, 2, 2);
        menuCol.addStyleName("bg-dark-grey");


        Column mainCol = new Column(12, 12, 10, 10);

        layoutRow.addColumn(menuCol);
        layoutRow.addColumn(mainCol);

        SideMenu sideMenu = new SideMenu();


        Random rand = new Random();
        int number = rand.nextInt(10 - 1 + 1) + 1;


        Resource res = new ThemeResource("img/images-" + number + ".jpeg");

// Display the image without caption
        Image image = new Image(null, res);
        image.setStyleName("img-rounded");
        image.setHeight("100px");
        image.setWidth("100px");


        Column profileCol = new Column(12);
        profileCol.setComponent(image);
        profileCol.addStyleName("content-center");

        sideMenu.addColumn(profileCol);


        Column logoCol = new Column(12,3,12);


        Button mainlogobutton = getButtonofSize("LOGO", "100%", "100%", FontAwesome.APPLE);
        logoCol.setComponent(mainlogobutton);
        sideMenu.addColumn(logoCol);

        Column homeCol = new Column(12,3,12);
        //homeCol.setOffset(Column.DisplaySize.MD, 1);
        homeCol.setComponent(getButtonofSize("Testers", "100%", "100%", FontAwesome.USERS));
        homeCol.setVisibility(Column.DisplaySize.XS, false);
        sideMenu.addColumn(homeCol);

        Column aboutCol = new Column(12,3,12);
        aboutCol.setComponent(getButtonofSize("Analyze", "100%", "100%", FontAwesome.AREA_CHART));
        aboutCol.setVisibility(Column.DisplaySize.XS, false);
        sideMenu.addColumn(aboutCol);

        Column contactCol = new Column(12,3,12);
        contactCol.setComponent(getButtonofSize("Report", "100%", "100%", FontAwesome.INBOX));
        contactCol.setVisibility(Column.DisplaySize.XS, false);
        sideMenu.addColumn(contactCol);

        mainlogobutton.addClickListener(clickEvent -> {

            homeCol.setVisibility(Column.DisplaySize.XS, !homeCol.isVisibleForDisplaySize(Column.DisplaySize.XS));
            aboutCol.setVisibility(Column.DisplaySize.XS, !aboutCol.isVisibleForDisplaySize(Column.DisplaySize.XS));
            contactCol.setVisibility(Column.DisplaySize.XS, !contactCol.isVisibleForDisplaySize(Column.DisplaySize.XS));


        });


        menuCol.setComponent(sideMenu);


        ResponsiveLayout mainRLayout = new ResponsiveLayout();

        mainCol.setComponent(mainRLayout);


        Row titleRow = new Row();

        Column titleCol = new Column(3);

        titleCol.addStyleName("content-center");
        Label title = new Label("Test Subjects");
        title.setStyleName(ValoTheme.LABEL_HUGE);
        title.setWidthUndefined();

        titleCol.setComponent(title);
        titleRow.addColumn(titleCol);
        titleRow.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        titleRow.setMargin(Row.MarginDirection.top, 50);

        mainRLayout.addRow(titleRow);


        Row teamRow = new Row();

        for (int x = 0; x < 10; x++) {
            TeamMemberView teamMemberView = new TeamMemberView();
            teamRow.addColumn(teamMemberView.getInColumn(12, 6, 4, 3));
        }

        mainRLayout.addRow(teamRow);
        //teamRow.setMargin(50);

        teamRow.setHorizontalSpacing(15);
        teamRow.setVerticalSpacing(15);
        teamRow.setMargin(Row.MarginDirection.all, 50);
        container.addRow(layoutRow);

        setContent(container);
    }


    public Button getButtonofSize(String title, String h, String w, FontIcon icon) {
        Button button = new Button(title);
        button.setStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
        button.setStyleName(ValoTheme.BUTTON_QUIET);

        button.setIcon(icon);
        button.setHeight(h);
        button.setWidth(w);

        return button;

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
