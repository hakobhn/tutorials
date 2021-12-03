package com.core.example.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

public class ImmutableListEample {

	public static void main(String[] args) {
		

	}

	@Test(expected = UnsupportedOperationException.class)
	public void givenUsingCommonsCollections_whenUnmodifiableListIsCreated_thenNotModifiable() {
		List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
		List<String> unmodifiableList = ListUtils.unmodifiableList(list);
		unmodifiableList.add("four");
	}

}
