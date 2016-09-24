package com.vernesoftware.ResponsiveLayout;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vernesoftware.ResponsiveLayout.cssModal.CssModal;

import java.util.*;

/**
 * Created by JarekToro on 9/23/16.
 */
public class RLCssLayout extends CssLayout {

    private int componantSpacing = 0;


    public HashMap<Integer, CssModal> cssModalHashMap;


    public RLCssLayout() {
        super();
        cssModalHashMap = new HashMap<>();
    }


    public void setCssModalForComponant(CssModal cssModal, int index) {
        if (cssModalHashMap.containsKey(index)) {
            cssModalHashMap.remove(index);
        }

        cssModalHashMap.put(index, cssModal);
    }

    @Override
    protected String getCss(Component c) {

        CssModal cssModal = cssModalHashMap.get(getComponentIndex(c));

        if (cssModal != null) {
            StringBuilder sb = new StringBuilder();
            cssModal.cssProperties.forEach(cssProperty -> {
                sb.append(cssProperty.name + ":" + cssProperty.value + ";");
            });
            return sb.toString();

        }

        return "";


    }


}
