package net.nunnerycode.bukkit.libraries.ivory.utils;

import org.bukkit.enchantments.Enchantment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONUtils {

	private JSONUtils() {
		// do nothing
	}

	public static String toJSON(int id, byte data, String name, List<String> lore, Map<Enchantment,
			Integer> enchantments) {
		return String.format("{id:%d,data:%s,tag:{display:{Name:%s,Lore:%s},ench:%s}}", id, data, name,
				quoteList(lore).toString(), enchantmentMapToStringList(enchantments));
	}

	private static List<String> quoteList(List<String> lore) {
		List<String> strings = new ArrayList<>();
		for (String s : lore) {
			strings.add("\"" + s.replace(":", "|") + "\"");
		}
		return strings;
	}

	private static List<String> enchantmentMapToStringList(Map<Enchantment, Integer> enchantmentIntegerMap) {
		List<String> strings = new ArrayList<>();
		for (Map.Entry<Enchantment, Integer> entry : enchantmentIntegerMap.entrySet()) {
			strings.add("{id:" + entry.getKey().getId() + ",lvl:" + entry.getValue() + "}");
		}
		return strings;
	}

}
