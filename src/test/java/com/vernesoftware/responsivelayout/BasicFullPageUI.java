package com.vernesoftware.responsivelayout;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport;
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



        responsiveLayout.setSizeFull(true);


        ResponsiveRow rootResponsiveRow = new ResponsiveRow();
        rootResponsiveRow.setHeight("100%");


        ResponsiveColumn menuCol = new ResponsiveColumn(12, 12, 2, 2);
        menuCol.addStyleName("bg-dark-grey");

        ResponsiveColumn mainCol = new ResponsiveColumn(12, 12, 10, 10);


        rootResponsiveRow.addColumn(menuCol);
        rootResponsiveRow.addColumn(mainCol);


        SideMenu sideMenu = new SideMenu();


        // get random Image
        Random rand = new Random();
        int number = rand.nextInt(10 - 1 + 1) + 1;
        Resource res = new ClassResource("/img/images-" + number + ".jpeg");
        Image image = new Image(null, res);

        Page.getCurrent().getStyles().add(".img-rounded { border-radius: 50%; } .bg-dark-grey { background-color: #F0F0F0;}");


        image.setStyleName("img-rounded");

        image.setHeight("100px");
        image.setWidth("100px");
        //end get random image


        ResponsiveColumn profileCol = new ResponsiveColumn(12);
        profileCol.setComponent(image);
        profileCol.addStyleName("content-center");


        ResponsiveColumn logoCol = new ResponsiveColumn(12, 3, 12);
        Button mainlogobutton = getButtonofSize("LOGO", "100%", "100%", FontAwesome.APPLE);
        logoCol.setComponent(mainlogobutton);

        ResponsiveColumn homeCol = new ResponsiveColumn(12, 3, 12);
        homeCol.setComponent(getButtonofSize("Testers", "100%", "100%", FontAwesome.USERS));
        homeCol.setVisibility(ResponsiveColumn.DisplaySize.XS, false);

        ResponsiveColumn aboutCol = new ResponsiveColumn(12, 3, 12);
        aboutCol.setComponent(getButtonofSize("Analyze", "100%", "100%", FontAwesome.AREA_CHART));
        aboutCol.setVisibility(ResponsiveColumn.DisplaySize.XS, false);

        ResponsiveColumn contactCol = new ResponsiveColumn(12, 3, 12);
        contactCol.setComponent(getButtonofSize("Report", "100%", "100%", FontAwesome.INBOX));
        contactCol.setVisibility(ResponsiveColumn.DisplaySize.XS, false);

        mainlogobutton.addClickListener(clickEvent -> {
            homeCol.setVisibility(ResponsiveColumn.DisplaySize.XS, !homeCol.isVisibleForDisplaySize(ResponsiveColumn.DisplaySize.XS));
            aboutCol.setVisibility(ResponsiveColumn.DisplaySize.XS, !aboutCol.isVisibleForDisplaySize(ResponsiveColumn.DisplaySize.XS));
            contactCol.setVisibility(ResponsiveColumn.DisplaySize.XS, !contactCol.isVisibleForDisplaySize(ResponsiveColumn.DisplaySize.XS));
        });


        sideMenu.addColumn(profileCol);
        sideMenu.addColumn(logoCol);
        sideMenu.addColumn(homeCol);
        sideMenu.addColumn(aboutCol);
        sideMenu.addColumn(contactCol);

        menuCol.setComponent(sideMenu);


        ResponsiveLayout mainSectionLayout = new ResponsiveLayout();


        mainCol.setComponent(mainSectionLayout);


        ResponsiveRow titleResponsiveRow = new ResponsiveRow();
        ResponsiveColumn titleCol = new ResponsiveColumn(3);
        titleResponsiveRow.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        titleCol.centerContent(true);


        Label title = new Label("Test Subjects");
        title.setStyleName(ValoTheme.LABEL_HUGE);
        title.setWidthUndefined();

        titleCol.setComponent(title);
        titleResponsiveRow.addColumn(titleCol);
        titleResponsiveRow.setMargin(true);

        mainSectionLayout.addRow(titleResponsiveRow);


        ResponsiveRow teamResponsiveRow = new ResponsiveRow();

        for (int x = 0; x < 10; x++) {
            TeamMemberView teamMemberView = new TeamMemberView();
            teamResponsiveRow.addColumn(teamMemberView.getInColumn(12, 6, 4, 3));
        }

        mainSectionLayout.addRow(teamResponsiveRow);

        teamResponsiveRow.setHorizontalSpacing(true);
        teamResponsiveRow.setVerticalSpacing(true);
        teamResponsiveRow.setMargin(true);


        responsiveLayout.addRow(rootResponsiveRow);

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

    public static class SideMenu extends ResponsiveRow {


        //  private ResponsiveRow row;

        public SideMenu() {


            // was able to create a side menu with the given parts
            // not part of responsiveLayout lib


            setMargin(true);
            setVerticalSpacing(true);
            setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);


        }


    }

    public static class TeamMemberView extends ResponsiveRow {

        public TeamMemberView() {

            // was able to create a example with the given parts
            // not part of responsiveLayout lib

            Panel panel = new Panel();
            ResponsiveColumn rootCol = new ResponsiveColumn(12);
            panel.setWidth("100%");
            rootCol.setComponent(panel);
            addColumn(rootCol);


            ResponsiveLayout responsiveLayout = new ResponsiveLayout();


            ResponsiveRow responsiveRow = new ResponsiveRow();
            responsiveRow.setMargin(true);
            responsiveRow.addStyleName("margin-small");
            ResponsiveColumn imageCol = new ResponsiveColumn(4, 4, 4, 4);
            imageCol.setComponent(getRandomTeamMember());
            ResponsiveColumn titleCol = new ResponsiveColumn(4, 4, 4, 4);
            titleCol.setComponent(new Label(getRandomTeamMemberName()));


            responsiveRow.addColumn(imageCol);
            responsiveRow.addColumn(titleCol);
            responsiveRow.setHorizontalSpacing(true);
            responsiveRow.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

            responsiveLayout.addRow(responsiveRow);
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

            String[] names = {"Bob", "Jill", "Tom", "Brandon", "Jarek", "David", "John", "Pat"};
            String[] lnames = {"Johnson", "Summersil", "Toro", "Spence", "Carleton", "Walton", "Hofmann", "Doe"};

            int index = new Random().nextInt(names.length);
            String name = names[index];

            int index1 = new Random().nextInt(names.length);
            String lname = lnames[index1];
            return name + " " + lname;

        }

        public Button getButtonofSize(String title, String h, String w) {
            Button button = new Button(title);
            button.setHeight(h);
            button.setWidth(w);

            button.addStyleName("primary");


            return button;

        }


        public ResponsiveColumn getInColumn(int xs, int sm, int md, int lg) {

            ResponsiveColumn col = new ResponsiveColumn(xs, sm, md, lg);
            col.setComponent(this);

            return col;

        }
    }

}
