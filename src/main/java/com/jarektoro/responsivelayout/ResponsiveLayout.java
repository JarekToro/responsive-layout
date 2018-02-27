package com.jarektoro.responsivelayout;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.CssLayout;

/**
 * Created by JarekToro on 9/23/16.
 */

@StyleSheet("styles.css")
public class ResponsiveLayout extends CssLayout {

	private static final String CSS_CONTAINER = "rl-container";
	private static final String CSS_CONTAINER_FLUID = "fluid";
	private static final String CSS_CONTAINER_FLEXIBLE = "flexible";
	private static final String CSS_CONTAINER_SPACING = "spacing";
	private static final String CSS_CONTAINER_FIXED = "fixed";
	private static final String CSS_CONTAINER_SCROLLABLE = "scrollable";

	private Integer xs = null;
	private Integer sm = null;
	private Integer md = null;
	private Integer lg = null;

	public enum DisplaySize {
		XS, SM, MD, LG
	}

	public enum ContainerType {
		FIXED, FLUID
	}

	public ResponsiveLayout(ContainerType containerType) {
		super();
		setHeightUndefined();
		setPrimaryStyleName(CSS_CONTAINER);
		setContainerType(containerType);
	}

	public ResponsiveLayout() {
		super();
		setHeightUndefined();
		setPrimaryStyleName(CSS_CONTAINER);
		setContainerType(ContainerType.FLUID);
	}

	public void setContainerType(ContainerType containerType) {
		removeStyleName(CSS_CONTAINER_FIXED);
		removeStyleName(CSS_CONTAINER_FLUID);

		if (containerType == ContainerType.FLUID) {
			addStyleName(CSS_CONTAINER_FLUID);
		} else if (containerType == ContainerType.FIXED) {
			addStyleName(CSS_CONTAINER_FIXED);
		}
	}

	public void setFlexible() {
		addStyleName(CSS_CONTAINER_FLEXIBLE);
	}

	public ResponsiveLayout withFlexible() {
		setFlexible();
		return this;
	}

	public void setSpacing() {
		addStyleName(CSS_CONTAINER_SPACING);
	}

	public ResponsiveLayout withSpacing() {
		addStyleName(CSS_CONTAINER_SPACING);
		return this;
	}

	public void setScrollable(boolean scrollable) {
		if (scrollable) {
			addStyleName(CSS_CONTAINER_SCROLLABLE);
		} else {
			removeStyleName(CSS_CONTAINER_SCROLLABLE);
		}
	}

	public ResponsiveLayout withScrollable(boolean scrollable) {
		if (scrollable) {
			addStyleName(CSS_CONTAINER_SCROLLABLE);
		} else {
			removeStyleName(CSS_CONTAINER_SCROLLABLE);
		}
		return this;
	}

	public ResponsiveLayout withStyleName(String styleName) {
		addStyleName(styleName);
		return this;
	}

	public ResponsiveLayout withStyleNames(String... styleNames) {
		addStyleNames(styleNames);
		return this;
	}

	/**
	 * fluent api for setStyleName
	 * 
	 * @param styleName
	 * @param replaceAndSet
	 * @return
	 */
	public ResponsiveLayout withStyleName(String styleName, boolean replaceAndSet) {
		if (replaceAndSet)
			setStyleName(styleName);
		else
			withStyleName(styleName);
		return this;
	}

	/**
	 * Adds the {@code ResponsiveRow} provided as a component.
	 *
	 * @param responsiveRow
	 *            A {@code ResponsiveRow}
	 */
	public ResponsiveRow addRow(ResponsiveRow responsiveRow) {
		if (hasDefaultRules() && !responsiveRow.hasDefaultRules())
			responsiveRow.withDefaultRules(xs, sm, md, lg);

		addComponent(responsiveRow);
		return responsiveRow;

	}

	public ResponsiveRow addRow() {
		return addRow(new ResponsiveRow());
	}

	public boolean hasDefaultRules() {
		return xs != null ? true : false;
	}

	public void setDefaultRules(int xs, int sm, int md, int lg) {
		this.xs = xs;
		this.sm = sm;
		this.md = md;
		this.lg = lg;
	}

	public ResponsiveLayout withDefaultRules(int xs, int sm, int md, int lg) {
		this.xs = xs;
		this.sm = sm;
		this.md = md;
		this.lg = lg;
		return this;
	}

	public ResponsiveLayout withCaption(String caption) {
		setCaption(caption);
		return this;
	}

	public ResponsiveLayout withCaption(String caption, boolean captionAsHtml) {
		setCaption(caption);
		setCaptionAsHtml(captionAsHtml);
		return this;
	}

	public ResponsiveLayout withFullSize() {
		setSizeFull();
		return this;
	}

}
