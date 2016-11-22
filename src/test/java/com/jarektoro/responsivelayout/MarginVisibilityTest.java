package com.jarektoro.responsivelayout;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import org.vaadin.addonhelpers.AbstractTest;

@Theme("valo")
@Viewport("width=device-width, initial-scale=1")
public class MarginVisibilityTest extends AbstractTest {
    @Override
    protected void init(VaadinRequest request) {
        // We need to override this method to set the content to our layout instead of the default vertial layout on used on the constructor of the superclass
        super.init(request);
        Page.getCurrent().getStyles().add(".red { background-color:red;  border-style: dashed; border-width: 2px; } .blue { background-color: blue;    border-style: dashed; border-width: 2px;} .green { background-color: green;   border-style: dashed; border-width: 2px;}");

        ResponsiveLayout responsiveLayout = new ResponsiveLayout();
        responsiveLayout.addStyleName("red");
        ResponsiveRow firstRow = responsiveLayout.addRow().withMargin(ResponsiveRow.MarginSize.NORMAL).withComponents(new Button("Button"), new Button("Button"), new Button("Button"));
        firstRow.setVisibility(ResponsiveLayout.DisplaySize.XS, false);
        firstRow.setCaption("Row with normal margin & fluid Components: Hide on XS");
        firstRow.addStyleName("blue");

        ResponsiveRow secondRow = responsiveLayout.addRow().withMargin(ResponsiveRow.MarginSize.SMALL).withComponents(new Button("Button"), new Button("Button"), new Button("Button"));
        secondRow.setCaption("Row with small margin & fluid Components");
        secondRow.addStyleName("blue");

        ResponsiveRow thirdRow = responsiveLayout.addRow().withMargin(ResponsiveRow.MarginSize.NORMAL);
        thirdRow.addColumn().withDisplayRules(4, 4, 4, 4).withComponent(fullWidth(new Label("col-1"))).addStyleName("green");
        thirdRow.addColumn().withDisplayRules(4, 4, 4, 4).withComponent(fullWidth(new Label("col-2"))).addStyleName("green");
        thirdRow.addColumn().withDisplayRules(4, 4, 4, 4).withComponent(fullWidth(new Label("col-3"))).addStyleName("green");
        thirdRow.setVisibility(ResponsiveLayout.DisplaySize.SM, false);

        thirdRow.setCaption("Row with normal margin & 3 Columns: Hide on SM");
        thirdRow.addStyleName("blue");

        ResponsiveRow fourthRow = responsiveLayout.addRow().withMargin(ResponsiveRow.MarginSize.SMALL);
        fourthRow.addColumn().withDisplayRules(4, 4, 4, 4).withComponent(fullWidth(new Label("col-1"))).addStyleName("green");
        fourthRow.addColumn().withDisplayRules(4, 4, 4, 4).withComponent(fullWidth(new Label("col-2"))).addStyleName("green");
        fourthRow.addColumn().withDisplayRules(4, 4, 4, 4).withComponent(fullWidth(new Label("col-3"))).addStyleName("green");

        fourthRow.setCaption("Row with small margin & 3 Columns");
        fourthRow.addStyleName("blue");

        ResponsiveRow fifthRow = responsiveLayout.addRow().withMargin(ResponsiveRow.MarginSize.NONE);
        fifthRow.addColumn().withDisplayRules(4, 4, 4, 4).withComponent(fullWidth(new Label("col-1"))).addStyleName("green");
        fifthRow.addColumn().withDisplayRules(4, 4, 4, 4).withComponent(fullWidth(new Label("col-2"))).addStyleName("green");
        fifthRow.addColumn().withDisplayRules(4, 4, 4, 4).withComponent(fullWidth(new Label("col-3"))).addStyleName("green");

        fifthRow.setCaption("Row with no margin & 3 Columns");
        fifthRow.addStyleName("blue");

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
