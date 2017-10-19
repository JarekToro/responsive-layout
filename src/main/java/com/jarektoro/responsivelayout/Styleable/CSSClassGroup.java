package com.jarektoro.responsivelayout.Styleable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jarektoro on 11/22/16.
 */

public class CSSClassGroup {

	public final Set<String> classes;

	public CSSClassGroup(String... classes) {
		HashSet<String> hashSet = new HashSet<>();
		for (String clazz : classes) {
			hashSet.add(clazz);
		}

		this.classes = hashSet;
	}

}