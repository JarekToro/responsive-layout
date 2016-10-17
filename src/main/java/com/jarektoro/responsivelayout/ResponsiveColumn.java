package com.jarektoro.responsivelayout;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JarekToro on 9/23/16.
 */
public class ResponsiveColumn extends CustomComponent {


    // Lot going on here, ill do my best to explain.


    // Rules to define how its displayed in the row example "col-xs-5" - see flexboxgrid.com
    // Visibility is a rule that say if the element is hidden or not on a given display size
    //TODO: these should be one class not two
    private Set<Rule> rules;
    private Set<Visibility> visibilityRules;

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


    private void convenienceInIt() {


        //set primary style name to 'col'
        // important in the addRule method


        setPrimaryStyleName("col");
        rules = new HashSet<>(4);
        visibilityRules = new HashSet<>(4);
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


    public void centerContent(boolean shouldCenter) {
        if (shouldCenter) {
            addStyleName("content-center");
        } else {
            removeStyleName("content-center");
        }
    }


    public void setComponent(Component component) {
        setCompositionRoot(component);
    }
    public Component getComponant() {
        return  getCompositionRoot();
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

    public ResponsiveColumn withComponent(Component component) {
        setComponent(component);
        return this;
    }

    public ResponsiveColumn withCenteredComponent(Component component) {
        centerContent(true);
        setComponent(component);
        return this;
    }
}
