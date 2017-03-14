package com.jarektoro.responsivelayout;

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
        Page.getCurrent().getStyles().add(".img-rounded { border-radius: 50%; width:100% } .bg-dark-grey { background-color: #F0F0F0;}");


        ResponsiveLayout responsiveLayout = new ResponsiveLayout(ResponsiveLayout.ContainerType.FLUID);

        responsiveLayout.setScrollable(true);
        responsiveLayout.setSizeFull();

        ResponsiveRow rootResponsiveRow = responsiveLayout.addRow();
        rootResponsiveRow.setHeight("100%");


        ResponsiveColumn menuCol = rootResponsiveRow.addColumn()
                .withDisplayRules(12, 12, 2, 2);
        menuCol.addStyleName("bg-dark-grey");

        ResponsiveColumn mainCol = rootResponsiveRow.addColumn()
                .withDisplayRules(12, 12, 10, 10);


        SideMenu sideMenu = new SideMenu();
        menuCol.setComponent(sideMenu);


        // get random Image
        Random rand = new Random();
        int number = rand.nextInt(10 - 1 + 1) + 1;
        Resource res = new ClassResource("/img/images-" + number + ".jpeg");
        Image image = new Image(null, res);
        image.setStyleName("img-rounded");
        image.setHeight("100px");
        image.setWidth("100px");
        //end get random image


        ResponsiveColumn profileCol = sideMenu.addColumn()
                .withDisplayRules(12, 12, 12, 12)
                .withCenteredComponent(image).withVisibilityRules(true, true, true, true);


        Button logoButton = getButtonofSize("LOGO", "100%", "100%", FontAwesome.APPLE);

        ResponsiveColumn logoCol = sideMenu.addColumn()
                .withDisplayRules(12, 3, 12, 12)
                .withComponent(logoButton);


        ResponsiveColumn homeCol = sideMenu.addColumn()
                .withDisplayRules(12, 3, 12, 12)
                .withVisibilityRules(false, true, true, true)
                .withComponent(getButtonofSize("Testers", "100%", "100%", FontAwesome.USERS));

        ResponsiveColumn aboutCol = sideMenu.addColumn()
                .withDisplayRules(12, 3, 12, 12)
                .withVisibilityRules(false, true, true, true)
                .withComponent(getButtonofSize("Analyze", "100%", "100%", FontAwesome.AREA_CHART));

        ResponsiveColumn contactCol = sideMenu.addColumn()
                .withDisplayRules(12, 3, 12, 12)
                .withVisibilityRules(false, true, true, true)
                .withComponent(getButtonofSize("Report", "100%", "100%", FontAwesome.INBOX));

        logoButton.addClickListener(clickEvent -> {
            homeCol.setVisibility(ResponsiveLayout.DisplaySize.XS, !homeCol.isVisibleForDisplaySize(ResponsiveLayout.DisplaySize.XS));
            aboutCol.setVisibility(ResponsiveLayout.DisplaySize.XS, !aboutCol.isVisibleForDisplaySize(ResponsiveLayout.DisplaySize.XS));
            contactCol.setVisibility(ResponsiveLayout.DisplaySize.XS, !contactCol.isVisibleForDisplaySize(ResponsiveLayout.DisplaySize.XS));
        });


        ResponsiveLayout mainSectionLayout = new ResponsiveLayout();
        mainCol.setComponent(mainSectionLayout);


        Label title = new Label("Test Subjects");
        title.setStyleName(ValoTheme.LABEL_HUGE);
        title.setWidthUndefined();


        ResponsiveRow titleResponsiveRow = mainSectionLayout.addRow()
                .withAlignment(Alignment.MIDDLE_CENTER).withMargin(true);
        titleResponsiveRow.addColumn()
                .withComponent(title, ResponsiveColumn.ColumnComponentAlignment.CENTER)
                .withDisplayRules(3, 3, 3, 3);


        ResponsiveRow teamResponsiveRow = mainSectionLayout.addRow()
                .withSpacing(true)
                .withMargin(true);

        for (int x = 0; x < 10; x++) {
            TeamMemberView teamMemberView = new TeamMemberView();
            teamMemberView.setCaption("caption");

            TextField tf = new TextField("caption");


            teamResponsiveRow.addColumn().withDisplayRules(12, 6, 4, 2).withComponent(teamMemberView);
        }


        setContent(responsiveLayout);


    }

    public ResponsiveLayout createNestedLayout() {
        ResponsiveLayout nestedLayout = new ResponsiveLayout();
        ResponsiveRow nestedLayoutRow = nestedLayout.addRow();

        nestedLayoutRow.setSpacing(ResponsiveRow.SpacingSize.SMALL, true);
        nestedLayoutRow.setMargin(ResponsiveRow.MarginSize.SMALL, ResponsiveLayout.DisplaySize.XS);


        Label label = new Label("Title!");
        label.setSizeUndefined();

        Button button = new Button("", FontAwesome.ANCHOR);
        button.addStyleName(ValoTheme.BUTTON_PRIMARY);

        TextField field = new TextField();
        field.setInputPrompt("Description");

        Button button1 = new Button("", FontAwesome.ANCHOR);
        button1.addStyleName(ValoTheme.BUTTON_FRIENDLY);


        nestedLayoutRow.addComponents(button, label, field, button1);


        return nestedLayout;
    }

    public ResponsiveColumn wrapInColumn(Component component) {

        ResponsiveColumn col = new ResponsiveColumn().withComponent(component);
        col.setSizeUndefined();
        return col;

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

    public static class TeamMemberView extends Panel {

        public TeamMemberView() {

            // was able to create a example with the given parts
            // not part of responsiveLayout lib

            setWidth("100%");
            setHeightUndefined();

            ResponsiveLayout responsiveLayout = new ResponsiveLayout();


            ResponsiveRow responsiveRow = new ResponsiveRow();

            responsiveRow.setMargin(ResponsiveRow.MarginSize.SMALL, ResponsiveLayout.DisplaySize.XS);
            responsiveRow.setSpacing(ResponsiveRow.SpacingSize.SMALL, true);

            ResponsiveColumn imageCol = new ResponsiveColumn(4, 4, 4, 4);
            imageCol.setComponent(getRandomTeamMember());
            ResponsiveColumn titleCol = new ResponsiveColumn(4, 4, 4, 4);
            titleCol.setComponent(new Label(getRandomTeamMemberName()));


            responsiveRow.addColumn(imageCol);
            responsiveRow.addColumn(titleCol);
            responsiveRow.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

            responsiveLayout.addRow(responsiveRow);
            setContent(responsiveLayout);


        }


        private Image getRandomTeamMember() {

            Random rand = new Random();
            int number = rand.nextInt(10 - 1 + 1) + 1;


            Resource res = new ClassResource("/img/images-" + number + ".jpeg");

            // Display the image without caption
            Image image = new Image(null, res);
            image.setStyleName("img-rounded");
            image.setWidth("100%");

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
