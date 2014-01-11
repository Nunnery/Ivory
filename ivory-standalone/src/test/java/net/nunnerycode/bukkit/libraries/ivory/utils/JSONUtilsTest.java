package net.nunnerycode.bukkit.libraries.ivory.utils;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class JSONUtilsTest {
	@Test
	public void testToJSON() throws Exception {
		int id = 257;
		byte data = 0;
		String name = "TEST NAME PLEASE IGNORE";
		List<String> list = Arrays.asList("Test Lore", "Please Ignore");

		String expected = "{id:257,data:0,tag:{display:{Name:TEST NAME PLEASE IGNORE,Lore:[\"Test Lore\", " +
				"\"Please Ignore\"]}}}";
		String actual = JSONUtils.toJSON(id, data, name, list);

		Assert.assertEquals(expected, actual);
	}
}
