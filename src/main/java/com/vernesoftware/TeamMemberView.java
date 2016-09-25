package com.vernesoftware;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vernesoftware.ResponsiveLayout.Column;
import com.vernesoftware.ResponsiveLayout.Row;

/**
 * Created by JarekToro on 9/23/16.
 */
public class TeamMemberView extends Row {

    public TeamMemberView() {

        Column imageCol = new Column(4, 4, 4, 4);
        imageCol.setComponent(getButtonofSize("image", "100px", "100%"));
        Column titleCol = new Column(8, 4, 4, 4);
        titleCol.setComponent(new Label("Jarek Toro"));
        Column buttonCol = new Column(12, 4, 4, 4);
        buttonCol.setComponent(getButtonofSize("View", "100%", "100%"));
        addColumn(imageCol);
        addColumn(titleCol);
        addColumn(buttonCol);
        setHorizontalSpacing(15);
        setVerticalSpacing(15);


    }

    public Button getButtonofSize(String title, String h, String w) {
        Button button = new Button(title);
        button.setHeight(h);
        button.setWidth(w);

        button.addStyleName("primary");

//        int num = new Random().nextInt(3);
//
//        if (num == 0) {
//            button.addStyleName("primary");
//
//        } else if (num == 1) {
//            button.addStyleName("friendly");
//        } else {
//            button.addStyleName("danger");
//
//        }


        return button;

    }


    public Column getInColumn(int xs, int sm, int md, int lg) {

        Column col = new Column(xs, sm, md, lg);
        col.setComponent(this);

        return col;

    }
}
