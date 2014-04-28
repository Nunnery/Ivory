package net.nunnerycode.bukkit.libraries.ivory.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IvoryStringListTest {

    @Test
    public void doesReplaceWithListReplaceWithOneKey() {
        String key = "%one%";
        IvoryStringList containingList = new IvoryStringList(Arrays.asList(key));
        List<String> replacementList = Arrays.asList("One", "Two", "Three", "Four");

        List<String> expected = Arrays.asList("One", "Two", "Three", "Four");
        List<String> actual = containingList.replaceWithList(key, replacementList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doesReplaceWithListReplaceWithTwoKeys() {
        String key = "%one%";
        IvoryStringList containingList = new IvoryStringList(Arrays.asList(key, "Test", key));
        List<String> replacementList = Arrays.asList("One", "Two", "Three", "Four");

        List<String> expected =
                Arrays.asList("One", "Two", "Three", "Four", "Test", "One", "Two", "Three", "Four");
        List<String> actual = containingList.replaceWithList(key, replacementList);

        Assert.assertEquals(expected, actual);
    }

}