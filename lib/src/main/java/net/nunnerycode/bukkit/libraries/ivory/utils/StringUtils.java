package net.nunnerycode.bukkit.libraries.ivory.utils;

import java.nio.charset.Charset;

public final class StringUtils {

  private StringUtils() {
    // do nothing
  }

  public static byte[] convertStringToCharset(String string, Charset charset) {
    return string.getBytes(charset);
  }

  public static String replaceArgs(String string, String[][] args) {
    String s = string;
    for (String[] arg : args) {
      s = s.replace(arg[0], arg[1]);
    }
    return s;
  }

}
