package com.vernesoftware.ResponsiveLayout;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vernesoftware.ResponsiveLayout.StyledDocument.StyleDocument;
import com.vernesoftware.ResponsiveLayout.StyledDocument.StyleDocumentAdapter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JarekToro on 9/23/16.
 */
public class Column extends CustomComponent implements StyleDocumentAdapter {


    private Set<Rule> rules;


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
    }

    public enum DisplaySize {
        XS, SM, MD, LG
    }

    private void convenienceInIt() {
        setPrimaryStyleName("col");
        rules = new HashSet<>(4);
        this.styleDocument = new StyleDocument();
    }

    public Column() {
        convenienceInIt();
    }

    public Column(Rule rule) {
        convenienceInIt();
        addRule(rule);
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
            removeStyleName(ruleToStyleName(oldRule));
            addStyleName(ruleToStyleName(rule));
        } else {
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


    private Rule getRuleForDisplaySize(DisplaySize displaySize, boolean isOffset) {

        final Rule[] foundRule = {null};

        rules.forEach(rule -> {
            if (rule.displaySize.equals(displaySize)) {

                if (rule.isOffset = isOffset) {
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


    public void setComponent(Component component) {

        setCompositionRoot(component);

    }


}
