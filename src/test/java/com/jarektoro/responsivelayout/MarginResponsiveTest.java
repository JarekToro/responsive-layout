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
public class MarginResponsiveTest extends AbstractTest {
    @Override
    protected void init(VaadinRequest request) {
        // We need to override this method to set the content to our layout instead of the default vertial layout on used on the constructor of the superclass
        super.init(request);
        Page.getCurrent().getStyles().add(".red { background-color:red;  border-style: dashed; border-width: 2px; } .blue { background-color: blue;    border-style: dashed; border-width: 2px;} .green { background-color: green;   border-style: dashed; border-width: 2px;}");

        ResponsiveLayout responsiveLayout = new ResponsiveLayout();
        responsiveLayout.addStyleName("red");


                ResponsiveRow firstRow = responsiveLayout.addRow()
                .withMargin(ResponsiveRow.MarginSize.NORMAL, ResponsiveColumn.DisplaySize.XS)
                .withMargin(ResponsiveRow.MarginSize.NONE, ResponsiveColumn.DisplaySize.SM)
                .withMargin(ResponsiveRow.MarginSize.NORMAL, ResponsiveColumn.DisplaySize.MD)
                .withMargin(ResponsiveRow.MarginSize.SMALL, ResponsiveColumn.DisplaySize.LG)

                .withComponents(new Button("Button"), new Button("Button"), new Button("Button"));

        firstRow.setCaption("Normal Margin For XS, none for SM, Normal for MD, Small for Large");
        firstRow.addStyleName("blue");

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

