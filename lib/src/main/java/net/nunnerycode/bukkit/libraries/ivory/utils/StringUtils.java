package net.nunnerycode.bukkit.libraries.ivory.utils;

import java.nio.charset.StandardCharsets;

public final class StringUtils {

  private StringUtils() {
    // do nothing
  }

  public static byte[] convertStringToUTF8(String string) {
    return string.getBytes(StandardCharsets.UTF_8);
  }

  public static String replaceArgs(String string, String[][] args) {
    String s = string;
    for (String[] arg : args) {
      s = s.replace(arg[0], arg[1]);
    }
    return s;
  }

}
