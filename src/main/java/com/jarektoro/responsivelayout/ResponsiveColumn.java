package com.jarektoro.responsivelayout;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JarekToro on 9/23/16.
 */
public class ResponsiveColumn extends CustomComponent {


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

    private static final String CSS_VISIBLE_XS = "rl-visible-xs";
    private static final String CSS_VISIBLE_SM = "rl-visible-sm";
    private static final String CSS_VISIBLE_MD = "rl-visible-md";
    private static final String CSS_VISIBLE_LG = "rl-visible-lg";

    private static final String CSS_HIDDEN_XS = "rl-hidden-xs";
    private static final String CSS_HIDDEN_SM = "rl-hidden-sm";
    private static final String CSS_HIDDEN_MD = "rl-hidden-md";
    private static final String CSS_HIDDEN_LG = "rl-hidden-lg";


    private static final String CSS_COL_CONTENT_ALGINMENT_RIGHT = "content-right";
    private static final String CSS_COL_CONTENT_ALGINMENT_CENTER = "content-center";


    //TODO: these should be one class not two
    private Set<Rule> rules;
    private Set<Visibility> visibilityRules;
    private CssLayout root;

    public class Rule {
        public DisplaySize displaySize;
        public int width;
        public boolean isOffset = false;
    }


    public class Visibility {
        public DisplaySize displaySize;
        public boolean isVisible = false;

    }

    public enum DisplaySize {
        XS, SM, MD, LG
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
        visibilityRules = new HashSet<>(4);
        root = new CssLayout();
        root.setStyleName(CSS_COL_CONTENT_CONTAINER);
        setCompositionRoot(root);
    }


    // bunch of convenience constructors


    public ResponsiveColumn() {
        convenienceInIt();
    }

    public ResponsiveColumn(Rule rule) {
        convenienceInIt();
        addRule(rule);
    }


    public ResponsiveColumn(DisplaySize displaySize, int width) {
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
        addRule(DisplaySize.XS, xs);
        addRule(DisplaySize.SM, sm);
        addRule(DisplaySize.MD, md);
        addRule(DisplaySize.LG, lg);
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

    public void addRule(DisplaySize displaySize, int width) {

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


    // returns if element will be visible on a given display size;

    public boolean isVisibleForDisplaySize(DisplaySize displaySize) {
        Visibility oldRule = getVisibilityRuleForDisplaySize(displaySize);

        if (oldRule != null) {
            return oldRule.isVisible;
        } else {
            return true;
        }
    }

    public void setVisibilityRules(boolean xs, boolean sm, boolean md, boolean lg) {
        setVisibility(DisplaySize.XS, xs);
        setVisibility(DisplaySize.SM, sm);
        setVisibility(DisplaySize.MD, md);
        setVisibility(DisplaySize.LG, lg);

        return;
    }

    // sets visibility for a given display size
    public void setVisibility(DisplaySize displaySize, boolean isVisible) {

        Visibility rule = new Visibility();
        rule.isVisible = isVisible;
        rule.displaySize = displaySize;


        // removes old rule if the new rule would be overwriting it
        // then adds new rule

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


    // same as rule turns the object into a string
    private String visibilityStyleNameForVsibilityRule(Visibility visibility) {
        if (visibility.isVisible) {
            switch (visibility.displaySize) {
                case XS:
                    return CSS_VISIBLE_XS;
                case SM:
                    return CSS_VISIBLE_SM;
                case MD:
                    return CSS_VISIBLE_MD;
                case LG:
                    return CSS_VISIBLE_LG;
                default:
                    return null;
            }
        } else {
            switch (visibility.displaySize) {
                case XS:
                    return CSS_HIDDEN_XS;
                case SM:
                    return CSS_HIDDEN_SM;
                case MD:
                    return CSS_HIDDEN_MD;
                case LG:
                    return CSS_HIDDEN_LG;
                default:
                    return null;
            }
        }
    }


    private Visibility getVisibilityRuleForDisplaySize(DisplaySize displaySize) {

        final Visibility[] foundRule = {null};

        for (Visibility rule : visibilityRules) {
            if (rule.displaySize.equals(displaySize)) {

                foundRule[0] = rule;


            }
        }


        return foundRule[0];

    }

    private Rule getRuleForDisplaySize(DisplaySize displaySize, boolean isOffset) {

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


    public void setOffset(DisplaySize displaySize, int width) {
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
        setVisibility(DisplaySize.XS, xs);
        setVisibility(DisplaySize.SM, sm);
        setVisibility(DisplaySize.MD, md);
        setVisibility(DisplaySize.LG, lg);

        return this;
    }

    public ResponsiveColumn withOffset(DisplaySize displaySize, int width) {
        setOffset(displaySize, width);
        return this;
    }

    public ResponsiveColumn withComponent(Component component) {
        setComponent(component);
        return this;
    }

    public ResponsiveColumn withCenteredComponent(Component component) {
        setAlignment(ColumnComponentAlignment.CENTER);
        setComponent(component);
        return this;
    }

    public ResponsiveColumn withRightAlignedComponent(Component component) {
        setAlignment(ColumnComponentAlignment.RIGHT);
        setComponent(component);
        return this;
    }


}
