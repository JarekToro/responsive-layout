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
public class ColumnOffsetTest extends AbstractTest {
    @Override
    protected void init(VaadinRequest request) {
        // We need to override this method to set the content to our layout instead of the default vertial layout on used on the constructor of the superclass
        super.init(request);
        Page.getCurrent().getStyles().add(".red { background-color:red;  border-style: dashed; border-width: 1px; } .blue { background-color: blue;    border-style: dashed; border-width: 1px;} .green { background-color: green;   border-style: dashed; border-width: 1px;}");

        ResponsiveLayout responsiveLayout = new ResponsiveLayout();
        responsiveLayout.addStyleName("red");


        ResponsiveRow firstRow = responsiveLayout.addRow();

        for (int x = 0; x < 12; x++) {
            if (x == 0) {
                firstRow.addColumn().withDisplayRules(1, 1, 1, 1).withOffset(ResponsiveColumn.DisplaySize.SM, 0).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            } else {
                firstRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            }

        }
        firstRow.setCaption("Row with 12 Columns and offset of 0");
        firstRow.addStyleName("blue");


        ResponsiveRow secondRow = responsiveLayout.addRow();

        for (int x = 0; x < 11; x++) {
            if (x == 0) {
                secondRow.addColumn().withDisplayRules(1, 1, 1, 1).withOffset(ResponsiveColumn.DisplaySize.SM, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            } else {
                secondRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            }

        }
        secondRow.setCaption("Row with 11 Columns and offset of 1");
        secondRow.addStyleName("blue");


        ResponsiveRow thirdRow = responsiveLayout.addRow();

        for (int x = 0; x < 10; x++) {
            if (x == 0) {
                thirdRow.addColumn().withDisplayRules(1, 1, 1, 1).withOffset(ResponsiveColumn.DisplaySize.SM, 2).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");
            } else {
                thirdRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");
            }

        }
        thirdRow.setCaption("Row with 10 Columns and offset of 2");
        thirdRow.addStyleName("blue");


        ResponsiveRow fourthRow = responsiveLayout.addRow();

        for (int x = 0; x < 9; x++) {
            if (x == 0) {
                fourthRow.addColumn().withDisplayRules(1, 1, 1, 1).withOffset(ResponsiveColumn.DisplaySize.SM, 3).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");
            } else {
                fourthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");
            }

        }
        fourthRow.setCaption("Row with 9 Columns and offset of 3");
        fourthRow.addStyleName("blue");

        ResponsiveRow fifthRow = responsiveLayout.addRow();

        for (int x = 0; x < 8; x++) {
            if (x == 0) {
                fifthRow.addColumn().withDisplayRules(1, 1, 1, 1).withOffset(ResponsiveColumn.DisplaySize.SM, 4).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            } else {
                fifthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            }

        }
        fifthRow.setCaption("Row with 8 Columns and offset of 4");
        fifthRow.addStyleName("blue");

        ResponsiveRow sixthRow = responsiveLayout.addRow();

        for (int x = 0; x < 7; x++) {
            if (x == 0) {
                sixthRow.addColumn().withDisplayRules(1, 1, 1, 1).withOffset(ResponsiveColumn.DisplaySize.SM, 5).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            } else {
                sixthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            }

        }
        sixthRow.setCaption("Row with 7 Columns and offset of 5");
        sixthRow.addStyleName("blue");

        ResponsiveRow seventhRow = responsiveLayout.addRow();

        for (int x = 0; x < 6; x++) {
            if (x == 0) {
                seventhRow.addColumn().withDisplayRules(1, 1, 1, 1).withOffset(ResponsiveColumn.DisplaySize.SM, 6).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            } else {
                seventhRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            }

        }
        seventhRow.setCaption("Row with 6 Columns and offset of 6");
        seventhRow.addStyleName("blue");

        ResponsiveRow eighthRow = responsiveLayout.addRow();

        for (int x = 0; x < 5; x++) {
            if (x == 0) {
                eighthRow.addColumn().withDisplayRules(1, 1, 1, 1).withOffset(ResponsiveColumn.DisplaySize.SM, 7).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            } else {
                eighthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            }

        }
        eighthRow.setCaption("Row with 5 Columns and offset of 7");
        eighthRow.addStyleName("blue");

        ResponsiveRow ninthRow = responsiveLayout.addRow();

        for (int x = 0; x < 4; x++) {
            if (x == 0) {
                ninthRow.addColumn().withDisplayRules(1, 1, 1, 1).withOffset(ResponsiveColumn.DisplaySize.SM, 8).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            } else {
                ninthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            }

        }
        ninthRow.setCaption("Row with 4 Columns and offset of 8");
        ninthRow.addStyleName("blue");

        ResponsiveRow tenthRow = responsiveLayout.addRow();

        for (int x = 0; x < 3; x++) {
            if (x == 0) {
                tenthRow.addColumn().withDisplayRules(1, 1, 1, 1).withOffset(ResponsiveColumn.DisplaySize.SM, 9).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            } else {
                tenthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            }

        }
        tenthRow.setCaption("Row with 3 Columns and offset of 9");
        tenthRow.addStyleName("blue");

        ResponsiveRow eleventhRow = responsiveLayout.addRow();

        for (int x = 0; x < 2; x++) {
            if (x == 0) {
                eleventhRow.addColumn().withDisplayRules(1, 1, 1, 1).withOffset(ResponsiveColumn.DisplaySize.SM, 10).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            } else {
                eleventhRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            }

        }
        eleventhRow.setCaption("Row with 2 Columns and offset of 10");
        eleventhRow.addStyleName("blue");

        ResponsiveRow TwelfthRow = responsiveLayout.addRow();

        for (int x = 0; x < 1; x++) {
            if (x == 0) {
                TwelfthRow.addColumn().withDisplayRules(1, 1, 1, 1).withOffset(ResponsiveColumn.DisplaySize.SM, 11).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            } else {
                TwelfthRow.addColumn().withDisplayRules(1, 1, 1, 1).withComponent(fullWidth(new Label("col-" + (x + 1)))).addStyleName("green");

            }

        }
        TwelfthRow.setCaption("Row with 1 Columns and offset of 11");
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

