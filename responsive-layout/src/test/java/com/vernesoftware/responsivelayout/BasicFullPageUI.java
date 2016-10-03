package com.vernesoftware.responsivelayout;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport;
import com.vaadin.annotations.ViewportGeneratorClass;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.addonhelpers.AbstractTest;

import java.util.Random;

@Theme("valo") // to test compatibility with out of the box valo?
@Viewport("width=device-width, initial-scale=1") // this is necessary , does it work here ?
public class BasicFullPageUI extends AbstractTest {



    @Override
    protected void init(VaadinRequest request) {
        // We need to override this method to set the content to our layout instead of the default vertial layout on used on the constructor of the superclass
        super.init(request);

        setSizeFull();


        ResponsiveLayout responsiveLayout = new ResponsiveLayout();


        //needed methods in Responsive Layout
        //verticalLayout.getComponentAlignment()
        //verticalLayout.addComponent(); should we add this? then in implementation just wrap it in a Column?
        //verticalLayout.setComponentAlignment(); - dont think possible only can set it for all in a row not for each individually


        responsiveLayout.setSizeFull(true);


        Row rootRow = new Row();
        rootRow.setHeight("100%");


        Column menuCol = new Column(12, 12, 2, 2);
        menuCol.addStyleName("bg-dark-grey");

        Column mainCol = new Column(12, 12, 10, 10);


        rootRow.addColumn(menuCol);
        rootRow.addColumn(mainCol);


        SideMenu sideMenu = new SideMenu();


        // get random Image
        Random rand = new Random();
        int number = rand.nextInt(10 - 1 + 1) + 1;
        Resource res = new ClassResource("/img/images-" + number + ".jpeg");
        Image image = new Image(null, res);

        Page.getCurrent().getStyles().add(".img-rounded { border-radius: 50%; }");
        image.setStyleName("img-rounded");

        image.setHeight("100px");
        image.setWidth("100px");
        //end get random image


        Column profileCol = new Column(12);
        profileCol.setComponent(image);
        profileCol.addStyleName("content-center");


        Column logoCol = new Column(12, 3, 12);
        Button mainlogobutton = getButtonofSize("LOGO", "100%", "100%", FontAwesome.APPLE);
        logoCol.setComponent(mainlogobutton);

        Column homeCol = new Column(12, 3, 12);
        homeCol.setComponent(getButtonofSize("Testers", "100%", "100%", FontAwesome.USERS));
        homeCol.setVisibility(Column.DisplaySize.XS, false);

        Column aboutCol = new Column(12, 3, 12);
        aboutCol.setComponent(getButtonofSize("Analyze", "100%", "100%", FontAwesome.AREA_CHART));
        aboutCol.setVisibility(Column.DisplaySize.XS, false);

        Column contactCol = new Column(12, 3, 12);
        contactCol.setComponent(getButtonofSize("Report", "100%", "100%", FontAwesome.INBOX));
        contactCol.setVisibility(Column.DisplaySize.XS, false);

        mainlogobutton.addClickListener(clickEvent -> {
            homeCol.setVisibility(Column.DisplaySize.XS, !homeCol.isVisibleForDisplaySize(Column.DisplaySize.XS));
            aboutCol.setVisibility(Column.DisplaySize.XS, !aboutCol.isVisibleForDisplaySize(Column.DisplaySize.XS));
            contactCol.setVisibility(Column.DisplaySize.XS, !contactCol.isVisibleForDisplaySize(Column.DisplaySize.XS));
        });


        sideMenu.addColumn(profileCol);
        sideMenu.addColumn(logoCol);
        sideMenu.addColumn(homeCol);
        sideMenu.addColumn(aboutCol);
        sideMenu.addColumn(contactCol);

        menuCol.setComponent(sideMenu);


        ResponsiveLayout mainSectionLayout = new ResponsiveLayout();


        mainCol.setComponent(mainSectionLayout);


        Row titleRow = new Row();
        Column titleCol = new Column(3);
        titleRow.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        titleCol.addStyleName("content-center");


        Label title = new Label("Test Subjects");
        title.setStyleName(ValoTheme.LABEL_HUGE);
        title.setWidthUndefined();

        titleCol.setComponent(title);
        titleRow.addColumn(titleCol);
        titleRow.setMargin(true);

        mainSectionLayout.addRow(titleRow);


        Row teamRow = new Row();

        for (int x = 0; x < 10; x++) {
            TeamMemberView teamMemberView = new TeamMemberView();
            teamRow.addColumn(teamMemberView.getInColumn(12, 6, 4, 3));
        }

        mainSectionLayout.addRow(teamRow);

        teamRow.setHorizontalSpacing(true);
        teamRow.setVerticalSpacing(true);
        teamRow.setMargin(true);


        responsiveLayout.addRow(rootRow);

        setContent(responsiveLayout);
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

    @Override
    public Component getTestComponent() {
        return new Label(""); // just dummy implementation, not really used
    }

    public static class SideMenu extends Row {


        //  private Row row;

        public SideMenu() {


            // was able to create a side menu with the given parts
            // not part of responsiveLayout lib


            setMargin(true);
            setVerticalSpacing(true);
            setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);


        }


    }

    public static class TeamMemberView extends Row {

        public TeamMemberView() {

            // was able to create a example with the given parts
            // not part of responsiveLayout lib

            Panel panel = new Panel();
            Column rootCol = new Column(12);
            panel.setWidth("100%");
            rootCol.setComponent(panel);
            addColumn(rootCol);


            ResponsiveLayout responsiveLayout = new ResponsiveLayout();


            Row row = new Row();
            row.setMargin(true);
            row.addStyleName("margin-small");
            Column imageCol = new Column(4, 4, 4, 4);
            imageCol.setComponent(getRandomTeamMember());
            Column titleCol = new Column(8, 4, 4, 4);
            titleCol.setComponent(new Label(getRandomTeamMemberName()));


            row.addColumn(imageCol);
            row.addColumn(titleCol);
            row.setHorizontalSpacing(true);
            row.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

            responsiveLayout.addRow(row);
            panel.setContent(responsiveLayout);

            setHorizontalSpacing(true);
            setVerticalSpacing(true);

        }


        private Image getRandomTeamMember() {

            Random rand = new Random();
            int number = rand.nextInt(10 - 1 + 1) + 1;


            Resource res = new ClassResource("/img/images-" + number + ".jpeg");

            // Display the image without caption
            Image image = new Image(null, res);
            image.setStyleName("img-rounded");
            image.setSizeFull();

            return image;


        }

        private String getRandomTeamMemberName() {

            String[] names = {"Bob", "Jill", "Tom", "Brandon","Jarek","David","John","Pat"};
            String[] lnames = {"Johnson", "Summersil", "Toro", "Spence","Carleton","Walton","Hofmann","Doe"};

            int index = new Random().nextInt(names.length);
            String name = names[index];

            int index1 = new Random().nextInt(names.length);
            String lname = lnames[index1];
            return name+" "+lname;

        }

        public Button getButtonofSize(String title, String h, String w) {
            Button button = new Button(title);
            button.setHeight(h);
            button.setWidth(w);

            button.addStyleName("primary");


            return button;

        }


        public Column getInColumn(int xs, int sm, int md, int lg) {

            Column col = new Column(xs, sm, md, lg);
            col.setComponent(this);

            return col;

        }
    }

}
