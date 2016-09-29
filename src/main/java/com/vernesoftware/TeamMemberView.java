package com.vernesoftware;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

import java.util.Random;

/**
 * Created by JarekToro on 9/23/16.
 */
public class TeamMemberView extends Row {

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


        Resource res = new ThemeResource("img/images-" + number + ".jpeg");

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
