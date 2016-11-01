package com.jarektoro.responsivelayout;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import org.vaadin.addonhelpers.AbstractTest;


/**
 * Created by JarekToro on 11/1/16.
 */
@Theme("valo")
@Viewport("width=device-width, initial-scale=1")
public class ColumnTest extends AbstractTest {
    @Override
    protected void init(VaadinRequest request) {
        // We need to override this method to set the content to our layout instead of the default vertial layout on used on the constructor of the superclass
        super.init(request);
        Page.getCurrent().getStyles().add(".red { background-color:red;  border-style: dashed; border-width: 1px; } .blue { background-color: blue;    border-style: dashed; border-width: 1px;} .green { background-color: green;   border-style: dashed; border-width: 1px;}");

        ResponsiveLayout responsiveLayout = new ResponsiveLayout();
        responsiveLayout.addStyleName("red");


        ResponsiveRow firstRow = responsiveLayout.addRow();

        for (int x = 0; x < 12; x++){
            firstRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-"+(x+1)))).addStyleName("green");

        }
        firstRow.setCaption("Row with 12 Columns");
        firstRow.addStyleName("blue");


        ResponsiveRow secondRow = responsiveLayout.addRow();

        for (int x = 0; x < 11; x++){
            secondRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-"+(x+1)))).addStyleName("green");

        }
        secondRow.setCaption("Row with 11 Columns");
        secondRow.addStyleName("blue");


        ResponsiveRow thirdRow = responsiveLayout.addRow();

        for (int x = 0; x < 10; x++){
            thirdRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-"+(x+1)))).addStyleName("green");

        }
        thirdRow.setCaption("Row with 10 Columns");
        thirdRow.addStyleName("blue");


        ResponsiveRow fourthRow = responsiveLayout.addRow();

        for (int x = 0; x < 9; x++){
            fourthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-"+(x+1)))).addStyleName("green");

        }
        fourthRow.setCaption("Row with 9 Columns");
        fourthRow.addStyleName("blue");

        ResponsiveRow fifthRow = responsiveLayout.addRow();

        for (int x = 0; x < 8; x++){
            fifthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-"+(x+1)))).addStyleName("green");

        }
        fifthRow.setCaption("Row with 8 Columns");
        fifthRow.addStyleName("blue");

        ResponsiveRow sixthRow = responsiveLayout.addRow();

        for (int x = 0; x < 7; x++){
            sixthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-"+(x+1)))).addStyleName("green");

        }
        sixthRow.setCaption("Row with 7 Columns");
        sixthRow.addStyleName("blue");

        ResponsiveRow seventhRow = responsiveLayout.addRow();

        for (int x = 0; x < 6; x++){
            seventhRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-"+(x+1)))).addStyleName("green");

        }
        seventhRow.setCaption("Row with 6 Columns");
        seventhRow.addStyleName("blue");

        ResponsiveRow eighthRow = responsiveLayout.addRow();

        for (int x = 0; x < 5; x++){
            eighthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-"+(x+1)))).addStyleName("green");

        }
        eighthRow.setCaption("Row with 5 Columns");
        eighthRow.addStyleName("blue");

        ResponsiveRow ninthRow = responsiveLayout.addRow();

        for (int x = 0; x < 4; x++){
            ninthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-"+(x+1)))).addStyleName("green");

        }
        ninthRow.setCaption("Row with 4 Columns");
        ninthRow.addStyleName("blue");

        ResponsiveRow tenthRow = responsiveLayout.addRow();

        for (int x = 0; x < 3; x++){
            tenthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-"+(x+1)))).addStyleName("green");

        }
        tenthRow.setCaption("Row with 3 Columns");
        tenthRow.addStyleName("blue");

        ResponsiveRow eleventhRow = responsiveLayout.addRow();

        for (int x = 0; x < 2; x++){
            eleventhRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-"+(x+1)))).addStyleName("green");

        }
        eleventhRow.setCaption("Row with 2 Columns");
        eleventhRow.addStyleName("blue");

        ResponsiveRow TwelfthRow = responsiveLayout.addRow();

        for (int x = 0; x < 1; x++){
            TwelfthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-"+(x+1)))).addStyleName("green");

        }
        TwelfthRow.setCaption("Row with 1 Columns");
        TwelfthRow.addStyleName("blue");



        setContent(responsiveLayout);
    }

    public Component fullWidth(Component component) {
        component.setWidth("100%");
        return component;
    }

    @Override
    public Component getTestComponent() {
        return new Label(""); // just dummy implementation, not really used
    }


}

