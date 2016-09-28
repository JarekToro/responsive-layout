package com.vernesoftware.StyledDocument;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JarekToro on 9/23/16.
 */
public class StyleDocument {


    public class CssProperty {


        // hold the Css property name and the value in strings

        public String name;
        public String value;

        public CssProperty(String name, String value) {
            this.name = name;
            this.value = value;
        }

    }

    public List<CssProperty> cssProperties;

    public StyleDocument() {

        // Holds the Css that the StyleAdapterCssLayout adapts to its children - see StyleAdapterCssLayout

        cssProperties = new ArrayList<>();
    }

    public void removeCssProperty(String name) {

        //removes css property from propertoes

        cssProperties.forEach(cssProperty -> {

            if (cssProperty.name.equals(name)) {
                cssProperties.remove(cssProperty);

            }

        });

    }

    public void addCssProperty(String name, String value) {


        //removes css property if its being overwritten
        //then adds the new property


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
