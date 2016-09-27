package com.vernesoftware;

import com.vaadin.server.Page;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vernesoftware.StyledDocument.StyleAdapterCssLayout;
import com.vernesoftware.StyledDocument.StyleDocument;
import com.vernesoftware.StyledDocument.StyleDocumentAdapter;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JarekToro on 9/23/16.
 */
public class Column extends CustomComponent implements StyleDocumentAdapter {


    private Set<Rule> rules;
    private Set<Visibility> visibilityRules;


    public StyleDocument styleDocument;

    public StyleDocument getStyleDocument() {
        return styleDocument;
    }

    public void setStyleDocument(StyleDocument styleDocument) {
        this.styleDocument = styleDocument;
    }


    public class Rule {
        public DisplaySize displaySize;
        public int width;
        public boolean isOffset = false;
        public boolean isVisibleRule = false;
        public boolean isVisible = false;

    }

    public class Visibility {
        public DisplaySize displaySize;
        public boolean isVisible = false;

    }


    public enum DisplaySize {
        XS, SM, MD, LG
    }

    private void convenienceInIt() {
        setPrimaryStyleName("col");
        rules = new HashSet<>(4);
        visibilityRules = new HashSet<>(4);

        this.styleDocument = new StyleDocument();
    }

    public Column() {
        convenienceInIt();
    }

    public Column(Rule rule) {
        convenienceInIt();
        addRule(rule);
    }

    public boolean isVisibleForDisplaySize(DisplaySize displaySize) {
        Visibility oldRule = getVisibilityRuleForDisplaySize(displaySize);

        if (oldRule != null) {
            return oldRule.isVisible;
        } else {
            return true;
        }
    }

    public void setVisibility(DisplaySize displaySize, boolean isVisible) {

        Visibility rule = new Visibility();
        rule.isVisible = isVisible;
        rule.displaySize = displaySize;


        Visibility oldRule = getVisibilityRuleForDisplaySize(rule.displaySize);

        if (oldRule != null) {
            visibilityRules.remove(oldRule);
            visibilityRules.add(rule);
            removeStyleName(visibilityStyleNameForVsibilityRule(oldRule));
            addStyleName(visibilityStyleNameForVsibilityRule(rule));
        } else {
            addStyleName(visibilityStyleNameForVsibilityRule(rule));
            visibilityRules.add(rule);

        }

    }


    private String visibilityStyleNameForVsibilityRule(Visibility visibility) {
        if (visibility.isVisible) {
            switch (visibility.displaySize) {
                case XS:
                    return "visible-xs";
                case SM:
                    return "visible-sm";
                case MD:
                    return "visible-md";
                case LG:
                    return "visible-lg";
                default:
                    return null;
            }
        } else {
            switch (visibility.displaySize) {
                case XS:
                    return "hidden-xs";
                case SM:
                    return "hidden-sm";
                case MD:
                    return "hidden-md";
                case LG:
                    return "hidden-lg";
                default:
                    return null;
            }
        }
    }

    public Column(DisplaySize displaySize, int width) {
        convenienceInIt();
        addRule(displaySize, width);
    }

    public Column(int xs) {
        convenienceInIt();
        setAllSizes(xs, xs, xs, xs);
    }


    public Column(int xs, int sm) {
        convenienceInIt();
        setAllSizes(xs, sm, sm, sm);

    }

    public Column(int xs, int sm, int md) {
        convenienceInIt();
        setAllSizes(xs, sm, md, md);

    }

    public Column(int xs, int sm, int md, int lg) {
        convenienceInIt();
        setAllSizes(xs, sm, md, lg);
    }


    private void setAllSizes(int xs, int sm, int md, int lg) {
        addRule(DisplaySize.XS, xs);
        addRule(DisplaySize.SM, sm);
        addRule(DisplaySize.MD, md);
        addRule(DisplaySize.LG, lg);
    }


    public void addRule(Rule rule) {

        Rule oldRule = getRuleForDisplaySize(rule.displaySize, rule.isOffset);
        if (oldRule != null) {
            rules.remove(oldRule);

            removeStyleName(ruleToStyleName(oldRule));
            addStyleName(ruleToStyleName(rule));
            rules.add(rule);

        } else {
            rules.add(rule);
            addStyleName(ruleToStyleName(rule));
        }

    }

    public void addRule(DisplaySize displaySize, int width) {

        Rule rule = new Rule();
        rule.displaySize = displaySize;
        rule.width = width;

        addRule(rule);

    }


    private String ruleToStyleName(Rule rule) {


        if (rule.isOffset) {
            switch (rule.displaySize) {
                case XS:
                    return "xs-offset-" + rule.width;
                case SM:
                    return "sm-offset-" + rule.width;
                case MD:
                    return "md-offset-" + rule.width;
                case LG:
                    return "lg-offset-" + rule.width;
                default:
                    return null;
            }
        } else {
            switch (rule.displaySize) {
                case XS:
                    return "xs-" + rule.width;
                case SM:
                    return "sm-" + rule.width;
                case MD:
                    return "md-" + rule.width;
                case LG:
                    return "lg-" + rule.width;
                default:
                    return null;
            }
        }

    }

    private Visibility getVisibilityRuleForDisplaySize(DisplaySize displaySize) {

        final Visibility[] foundRule = {null};

        visibilityRules.forEach(rule -> {
            if (rule.displaySize.equals(displaySize)) {

                foundRule[0] = rule;


            }
        });


        return foundRule[0];

    }

    private Rule getRuleForDisplaySize(DisplaySize displaySize, boolean isOffset) {

        final Rule[] foundRule = {null};

        rules.forEach(rule -> {
            if (rule.displaySize.equals(displaySize)) {

                if (rule.isOffset == isOffset) {

                    foundRule[0] = rule;

                }

            }
        });


        return foundRule[0];

    }

    public void setOffset(DisplaySize displaySize, int width) {
        Rule rule = new Rule();
        rule.isOffset = true;
        rule.displaySize = displaySize;
        rule.width = width;

        addRule(rule);
    }

    public StyleDocumentAdapter getStyledDocumentAdapter(Component c) {

        if (c instanceof StyleDocumentAdapter) {

            return (StyleDocumentAdapter) c;

        }

        return null;
    }


    public void setComponent(Component component) {


        StyleDocumentAdapter styleDocumentAdapter = getStyledDocumentAdapter(component);

        if (styleDocumentAdapter != null) {
            StringBuilder sb = new StringBuilder();
            styleDocumentAdapter.getStyleDocument().cssProperties.forEach(cssProperty -> {
                sb.append(cssProperty.name + ":" + cssProperty.value + ";");
            });
            sb.toString();

            String styleName = randomString(10);


            component.setStyleName(styleName);
            Page.Styles styles = Page.getCurrent().getStyles();


            // styles.add(".v-app ."+styleName+" { "+sb.toString()+" }");

        }

        // inject the new font size as a style. We need .v-app to override Vaadin's default styles here


        setCompositionRoot(component);


    }

    static final String AB = "abcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

}
