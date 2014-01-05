package net.nunnerycode.bukkit.libraries.ivory;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringListUtilsTest {

	@Test
	public void testAddStringOne() throws Exception {
		List<String> list = Arrays.asList("one", "two", "three", "four", "five");
		String toAdd = "six";
		int index = 5;
		boolean startAtZero = true;

		Assert.assertNotNull(list);
		Assert.assertNotNull(toAdd);

		List<String> actual = StringListUtils.addString(list, index, toAdd, startAtZero);
		List<String> expected = Arrays.asList("one", "two", "three", "four", "five", "six");

		Assert.assertNotNull(actual);
		Assert.assertNotNull(expected);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testAddStringTwo() throws Exception {
		List<String> list = Arrays.asList("one", "two", "three", "four", "five");
		String toAdd = "six";
		int index = 6;
		boolean startAtZero = false;

		Assert.assertNotNull(list);
		Assert.assertNotNull(toAdd);

		List<String> actual = StringListUtils.addString(list, index, toAdd, startAtZero);
		List<String> expected = Arrays.asList("one", "two", "three", "four", "five", "six");

		Assert.assertNotNull(actual);
		Assert.assertNotNull(expected);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testAddStringThree() throws Exception {
		List<String> list = Arrays.asList("one", "two", "three", "four", "five");
		String toAdd = "six";
		int index = 4;
		boolean startAtZero = true;

		Assert.assertNotNull(list);
		Assert.assertNotNull(toAdd);

		List<String> actual = StringListUtils.addString(list, index, toAdd, startAtZero);
		List<String> expected = Arrays.asList("one", "two", "three", "four", "six", "five");

		Assert.assertNotNull(actual);
		Assert.assertNotNull(expected);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testAddStringFour() throws Exception {
		List<String> list = Arrays.asList("one", "two", "three", "four", "five");
		String toAdd = "six";
		int index = 5;
		boolean startAtZero = false;

		Assert.assertNotNull(list);
		Assert.assertNotNull(toAdd);

		List<String> actual = StringListUtils.addString(list, index, toAdd, startAtZero);
		List<String> expected = Arrays.asList("one", "two", "three", "four", "six", "five");

		Assert.assertNotNull(actual);
		Assert.assertNotNull(expected);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testAddStringFive() throws Exception {
		List<String> list = Arrays.asList("one", "two", "three", "four", "five");
		String toAdd = "six";
		int index = 8;
		boolean startAtZero = true;

		Assert.assertNotNull(list);
		Assert.assertNotNull(toAdd);

		List<String> actual = StringListUtils.addString(list, index, toAdd, startAtZero);
		List<String> expected = Arrays.asList("one", "two", "three", "four", "five", "", "", "", "six");

		Assert.assertNotNull(actual);
		Assert.assertNotNull(expected);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testAddStringSix() throws Exception {
		List<String> list = Arrays.asList("one", "two", "three", "four", "five");
		String toAdd = "six";
		int index = 9;
		boolean startAtZero = false;

		Assert.assertNotNull(list);
		Assert.assertNotNull(toAdd);

		List<String> actual = StringListUtils.addString(list, index, toAdd, startAtZero);
		List<String> expected = Arrays.asList("one", "two", "three", "four", "five", "", "", "", "six");

		Assert.assertNotNull(actual);
		Assert.assertNotNull(expected);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testRemoveAllOne() throws Exception {
		List<String> list = Arrays.asList("one", "two", "three", "four", "five");
		String toRemove = "two";

		Assert.assertNotNull(list);
		Assert.assertNotNull(toRemove);

		List<String> actual = StringListUtils.removeAll(list, toRemove);
		List<String> expected = Arrays.asList("one", "three", "four", "five");

		Assert.assertNotNull(actual);
		Assert.assertNotNull(expected);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testRemoveAllTwo() throws Exception {
		List<String> list = Arrays.asList("one", "two", "two", "three", "four", "five");
		String toRemove = "two";

		Assert.assertNotNull(list);
		Assert.assertNotNull(toRemove);

		List<String> actual = StringListUtils.removeAll(list, toRemove);
		List<String> expected = Arrays.asList("one", "three", "four", "five");

		Assert.assertNotNull(actual);
		Assert.assertNotNull(expected);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testRemoveAllThree() throws Exception {
		List<String> list = Arrays.asList("one", "two", "three", "two", "four", "two", "five", "two");
		String toRemove = "two";

		Assert.assertNotNull(list);
		Assert.assertNotNull(toRemove);

		List<String> actual = StringListUtils.removeAll(list, toRemove);
		List<String> expected = Arrays.asList("one", "three", "four", "five");

		Assert.assertNotNull(actual);
		Assert.assertNotNull(expected);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testRemoveIfMatchesOne() throws Exception {
		List<String> list = Arrays.asList("Polly wants a", "cracker because Polly", "is a Parrot");
		List<String> toRemove = Arrays.asList("and Parrots like", "crackers another word");

		Assert.assertNotNull(list);
		Assert.assertNotNull(toRemove);

		List<String> actual = StringListUtils.removeIfMatches(list, toRemove);
		List<String> expected = Arrays.asList("Polly wants a", "cracker because Polly", "is a Parrot");

		Assert.assertNotNull(actual);
		Assert.assertNotNull(expected);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testRemoveIfMatchesTwo() throws Exception {
		List<String> list = Arrays.asList("Polly wants a", "cracker because Polly", "is a Parrot",
				"and Parrots like", "crackers another word");
		List<String> toRemove = Arrays.asList("and Parrots like", "crackers another word");

		Assert.assertNotNull(list);
		Assert.assertNotNull(toRemove);

		List<String> actual = StringListUtils.removeIfMatches(list, toRemove);
		List<String> expected = Arrays.asList("Polly wants a", "cracker because Polly", "is a Parrot");

		Assert.assertNotNull(actual);
		Assert.assertNotNull(expected);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testRemoveIfMatchesThree() throws Exception {
		List<String> list = Arrays.asList("Polly wants a", "cracker because Polly", "is a Parrot",
				"and Parrots like", "crackers another word");
		List<String> toRemove = Arrays.asList("is a Parrot", "and Parrots like");

		Assert.assertNotNull(list);
		Assert.assertNotNull(toRemove);

		List<String> actual = StringListUtils.removeIfMatches(list, toRemove);
		List<String> expected = Arrays.asList("Polly wants a", "cracker because Polly", "crackers another word");

		Assert.assertNotNull(actual);
		Assert.assertNotNull(expected);

		Assert.assertEquals(actual, expected);
	}

}
