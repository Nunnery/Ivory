package net.nunnerycode.bukkit.libraries.ivory.utils;

import java.util.ArrayList;
import java.util.List;

public class JSONUtils {

	private JSONUtils() {
		// do nothing
	}

	public static String toJSON(int id, byte data, String name, List<String> lore) {
		return String.format("{id:%d,data:%s,tag:{display:{Name:%s,Lore:%s}}}", id, data, name,
				quoteList(lore).toString());
	}

	private static List<String> quoteList(List<String> lore) {
		List<String> strings = new ArrayList<>();
		for (String s : lore) {
			strings.add("\"" + s.replace(":", "|") + "\"");
		}
		return strings;
	}

}
