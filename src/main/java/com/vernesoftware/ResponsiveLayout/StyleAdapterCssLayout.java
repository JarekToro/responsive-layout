package com.vernesoftware.ResponsiveLayout;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vernesoftware.ResponsiveLayout.cssModal.StyleDocumentAdapter;

/**
 * Created by JarekToro on 9/23/16.
 */
public class StyleAdapterCssLayout extends CssLayout {


    public StyleAdapterCssLayout() {
        super();
    }

    @Override
    public void addComponent(Component c) {

        super.addComponent(c);


    }


    public StyleDocumentAdapter getStyledDocumentAdapter(Component c) {

        if (c instanceof StyleDocumentAdapter) {

            return (StyleDocumentAdapter) c;

        }

        return null;
    }


    @Override
    protected String getCss(Component c) {


        StyleDocumentAdapter styleDocumentAdapter = getStyledDocumentAdapter(c);

        if (styleDocumentAdapter.getStyleDocument() != null) {
            StringBuilder sb = new StringBuilder();
            styleDocumentAdapter.getStyleDocument().cssProperties.forEach(cssProperty -> {
                sb.append(cssProperty.name + ":" + cssProperty.value + ";");
            });
            return sb.toString();

        }

        return "";


    }


}
