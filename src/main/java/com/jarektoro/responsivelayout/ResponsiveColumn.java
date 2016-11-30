package com.jarektoro.responsivelayout;

import com.jarektoro.responsivelayout.Styleable.StyleableComponent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JarekToro on 9/23/16.
 */
public class ResponsiveColumn extends StyleableComponent {


    private static final String CSS_COL = "rl-col";
    private static final String CSS_COL_CONTENT_CONTAINER = "col-container";
    private static final String CSS_COL_XS_OFFSET = "xs-offset-";
    private static final String CSS_COL_SM_OFFSET = "sm-offset-";
    private static final String CSS_COL_MD_OFFSET = "md-offset-";
    private static final String CSS_COL_LG_OFFSET = "lg-offset-";

    private static final String CSS_COL_XS = "xs-";
    private static final String CSS_COL_SM = "sm-";
    private static final String CSS_COL_MD = "md-";
    private static final String CSS_COL_LG = "lg-";


    private static final String CSS_COL_CONTENT_ALGINMENT_RIGHT = "content-right";
    private static final String CSS_COL_CONTENT_ALGINMENT_CENTER = "content-center";


    //TODO: these should be one class not two
    private Set<Rule> rules;
    private CssLayout root;

    public class Rule {
        public ResponsiveLayout.DisplaySize displaySize;
        public int width;
        public boolean isOffset = false;
    }


    public enum ColumnComponentAlignment {
        LEFT, CENTER, RIGHT
    }


    private void convenienceInIt() {

        //set primary style name to 'col'
        // important in the addRule method


        setPrimaryStyleName(CSS_COL);
        setSizeUndefined();
        rules = new HashSet<>(4);
        root = new CssLayout();
        root.setStyleName(CSS_COL_CONTENT_CONTAINER);
        setCompositionRoot(root);
    }


    // bunch of convenience constructors


    public ResponsiveColumn() {
        super();
        convenienceInIt();
    }

    public ResponsiveColumn(Rule rule) {
        convenienceInIt();
        addRule(rule);
    }


    public ResponsiveColumn(ResponsiveLayout.DisplaySize displaySize, int width) {
        convenienceInIt();
        addRule(displaySize, width);
    }

    public ResponsiveColumn(int xs) {
        convenienceInIt();
        setAllSizes(xs, xs, xs, xs);
    }


    public ResponsiveColumn(int xs, int sm) {
        convenienceInIt();
        setAllSizes(xs, sm, sm, sm);

    }

    public ResponsiveColumn(int xs, int sm, int md) {
        convenienceInIt();
        setAllSizes(xs, sm, md, md);

    }

    public ResponsiveColumn(int xs, int sm, int md, int lg) {
        convenienceInIt();
        setAllSizes(xs, sm, md, lg);
    }


    private void setAllSizes(int xs, int sm, int md, int lg) {
        addRule(ResponsiveLayout.DisplaySize.XS, xs);
        addRule(ResponsiveLayout.DisplaySize.SM, sm);
        addRule(ResponsiveLayout.DisplaySize.MD, md);
        addRule(ResponsiveLayout.DisplaySize.LG, lg);
    }


    public void addRule(Rule rule) {


        //removes a rule is you are adding a rule that would override it.
        //then saves the new rule
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

    public void addRule(ResponsiveLayout.DisplaySize displaySize, int width) {

        Rule rule = new Rule();
        rule.displaySize = displaySize;
        rule.width = width;

        addRule(rule);

    }


    // converts the rule object to a string for css
    private String ruleToStyleName(Rule rule) {


        if (rule.isOffset) {
            switch (rule.displaySize) {
                case XS:
                    return CSS_COL_XS_OFFSET + rule.width;
                case SM:
                    return CSS_COL_SM_OFFSET + rule.width;
                case MD:
                    return CSS_COL_MD_OFFSET + rule.width;
                case LG:
                    return CSS_COL_LG_OFFSET + rule.width;
                default:
                    return null;
            }
        } else {
            switch (rule.displaySize) {
                case XS:
                    return CSS_COL_XS + rule.width;
                case SM:
                    return CSS_COL_SM + rule.width;
                case MD:
                    return CSS_COL_MD + rule.width;
                case LG:
                    return CSS_COL_LG + rule.width;
                default:
                    return null;
            }
        }

    }


    public void setVisibilityRules(boolean xs, boolean sm, boolean md, boolean lg) {
        setVisibility(ResponsiveLayout.DisplaySize.XS, xs);
        setVisibility(ResponsiveLayout.DisplaySize.SM, sm);
        setVisibility(ResponsiveLayout.DisplaySize.MD, md);
        setVisibility(ResponsiveLayout.DisplaySize.LG, lg);

        return;
    }


    private Rule getRuleForDisplaySize(ResponsiveLayout.DisplaySize displaySize, boolean isOffset) {

        final Rule[] foundRule = {null};

        for (Rule rule : rules) {
            if (rule.displaySize.equals(displaySize)) {

                if (rule.isOffset == isOffset) {

                    foundRule[0] = rule;

                }

            }
        }


        return foundRule[0];

    }


    public void setOffset(ResponsiveLayout.DisplaySize displaySize, int width) {
        Rule rule = new Rule();
        rule.isOffset = true;
        rule.displaySize = displaySize;
        rule.width = width;

        addRule(rule);
    }


    public void setAlignment(ColumnComponentAlignment componentAlignment) {
        removeStyleName(CSS_COL_CONTENT_ALGINMENT_RIGHT);
        removeStyleName(CSS_COL_CONTENT_ALGINMENT_CENTER);


        switch (componentAlignment) {


            case CENTER:
                addStyleName(CSS_COL_CONTENT_ALGINMENT_CENTER);
                break;
            case LEFT:
                //The default it left automatically
                break;
            case RIGHT:
                addStyleName(CSS_COL_CONTENT_ALGINMENT_RIGHT);
                break;
            default:
                break;
        }
    }


    public void setComponent(Component component) {
        root.removeAllComponents();
        root.addComponent(component);

    }


    public Component getComponent() {
        return root.getComponent(0);
    }


    // Convenience API


    public ResponsiveColumn withDisplayRules(int xs, int sm, int md, int lg) {
        setAllSizes(xs, sm, md, lg);
        return this;
    }

    public ResponsiveColumn withVisibilityRules(boolean xs, boolean sm, boolean md, boolean lg) {
        setVisibility(ResponsiveLayout.DisplaySize.XS, xs);
        setVisibility(ResponsiveLayout.DisplaySize.SM, sm);
        setVisibility(ResponsiveLayout.DisplaySize.MD, md);
        setVisibility(ResponsiveLayout.DisplaySize.LG, lg);

        return this;
    }

    public ResponsiveColumn withOffset(ResponsiveLayout.DisplaySize displaySize, int width) {
        setOffset(displaySize, width);
        return this;
    }

    public ResponsiveColumn withComponent(Component component) {
        setComponent(component);
        return this;
    }

    @Deprecated
    public ResponsiveColumn withCenteredComponent(Component component) {
        setAlignment(ColumnComponentAlignment.CENTER);
        setComponent(component);
        return this;
    }

    public ResponsiveColumn withComponent(Component component, ColumnComponentAlignment alignment) {
        setAlignment(alignment);
        setComponent(component);
        return this;
    }

    @Deprecated
    public ResponsiveColumn withRightAlignedComponent(Component component) {
        setAlignment(ColumnComponentAlignment.RIGHT);
        setComponent(component);
        return this;
    }


}
