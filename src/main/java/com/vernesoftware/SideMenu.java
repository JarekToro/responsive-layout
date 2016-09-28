package com.vernesoftware;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.FontIcon;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by JarekToro on 9/27/16.
 */
public class SideMenu extends ResponsiveLayout {


    private Row row;

    public SideMenu() {


        // was able to create a side menu with the given parts
        // not part of responsiveLayout lib


        row = new Row();

        row.setMargin(Row.MarginDirection.all, 25);
        row.setVerticalSpacing(25);
        row.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        addRow(row);


    }

    public void addColumn(Column column) {
        row.addColumn(column);

    }
}
