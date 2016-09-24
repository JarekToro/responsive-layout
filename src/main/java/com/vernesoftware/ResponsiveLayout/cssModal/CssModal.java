package com.vernesoftware.ResponsiveLayout.cssModal;

import com.vaadin.ui.CssLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JarekToro on 9/23/16.
 */
public class CssModal {


    public class CssProperty {


        public String name;
        public String value;

        public CssProperty(String name, String value) {
            this.name = name;
            this.value = value;
        }

    }

    public List<CssProperty> cssProperties;

    public CssModal() {
        cssProperties = new ArrayList<>();
    }

    public void removeCssProperty(String name) {

        cssProperties.forEach(cssProperty -> {

            if (cssProperty.name.equals(name)) {
                cssProperties.remove(cssProperty);

            }

        });

    }

    public void addCssProperty(String name, String value) {

        List<CssProperty> toDeleteList = new ArrayList<>();


        cssProperties.forEach(cssProperty -> {

            if (cssProperty.name.equals(name)) {
                toDeleteList.add(cssProperty);

            }

        });


        toDeleteList.forEach(cssProperty -> {
            cssProperties.remove(cssProperty);
        });


        CssProperty newCssProperty = new CssProperty(name, value);

        cssProperties.add(newCssProperty);
    }
}
