package net.nunnerycode.bukkit.libraries.ivory.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringListUtilsTest {

  @Test
  public void doesReplaceWithListReplaceWithOneKey() {
    String key = "%one%";
    List<String> containingList = Arrays.asList(key);
    List<String> replacementList = Arrays.asList("One", "Two", "Three", "Four");

    List<String> expected = Arrays.asList("One", "Two", "Three", "Four");
    List<String> actual = StringListUtils.replaceWithList(containingList, key, replacementList);

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void doesReplaceWithListReplaceWithTwoKeys() {
    String key = "%one%";
    List<String> containingList = Arrays.asList(key, "Test", key);
    List<String> replacementList = Arrays.asList("One", "Two", "Three", "Four");

    List<String> expected = Arrays.asList("One", "Two", "Three", "Four", "Test", "One", "Two", "Three", "Four");
    List<String> actual = StringListUtils.replaceWithList(containingList, key, replacementList);

    Assert.assertEquals(expected, actual);
  }

}
