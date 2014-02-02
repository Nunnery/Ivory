package net.nunnerycode.bukkit.libraries.ivory.utils;

import org.bukkit.enchantments.Enchantment;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JSONUtilsTest {

  @Test
  public void testToJSON() throws Exception {
    int id = 257;
    byte data = 0;
    String name = "TEST NAME PLEASE IGNORE";
    List<String> list = Arrays.asList("Test Lore", "Please Ignore");
    Map<Enchantment, Integer> enchantments = new LinkedHashMap<>();
    enchantments.put(Enchantment.DAMAGE_ALL, 2);
    enchantments.put(Enchantment.LOOT_BONUS_MOBS, 1);
    enchantments.put(Enchantment.DAMAGE_UNDEAD, 4);

    String
        expected =
        "{id:257,data:0,tag:{display:{Name:TEST NAME PLEASE IGNORE,Lore:[\"Test Lore\", " +
        "\"Please Ignore\"]},ench:[{id:16,lvl:2}, {id:21,lvl:1}, {id:17,lvl:4}]}}";
    String actual = JSONUtils.toJSON(id, data, name, list, enchantments);

    Assert.assertEquals(expected, actual);
  }
}
