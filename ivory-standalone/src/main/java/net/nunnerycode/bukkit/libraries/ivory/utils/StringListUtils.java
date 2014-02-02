package net.nunnerycode.bukkit.libraries.ivory.utils;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class designed to handle manipulation of {@link java.util.List}s of {@link java.lang.String}s.
 */
public final class StringListUtils {

  private static final String EMPTY_STRING = "";

  private StringListUtils() {
    // do nothing
  }

  /**
   * Adds a {@link String} to a {@link List} at a specified index.
   *
   * @param strings     List of Strings
   * @param index       index to add
   * @param string      String to add to List
   * @param startAtZero if index is a zero-count number
   * @return List with the added String
   */
  public static List<String> addString(List<String> strings, int index, String string,
                                       boolean startAtZero) {
    Validate.notNull(strings, "List<String> cannot be null");
    Validate.notNull(string, "String cannot be null");

    List<String> list = new ArrayList<>(strings);

    int actualIndex = index;
    if (!startAtZero) {
      actualIndex--;
    }

    if (list.size() < actualIndex) {
      int sizeDifference = actualIndex - list.size();
      for (; sizeDifference > 0; sizeDifference--) {
        list.add(EMPTY_STRING);
      }
    }

    list.add(actualIndex, string);
    return list;
  }

  /**
   * Removes all occurences of a {@link String} from a {@link List}.
   *
   * @param strings List of Strings
   * @param string  String to remove
   * @return List without String
   */
  public static List<String> removeAll(List<String> strings, String string) {
    Validate.notNull(strings);
    Validate.notNull(string);

    List<String> list = new ArrayList<>(strings);

    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().equals(string)) {
        iterator.remove();
      }
    }

    return list;
  }

  /**
   * Removes a {@link java.util.List} of {@link java.lang.String}s from a {@link java.util.List} of
   * {@link java .lang.String}s, but only if it matches exactly.
   *
   * @param strings      List from which to remove
   * @param otherStrings Strings to match in order to remove
   * @return List without matched Strings
   */
  public static List<String> removeIfMatches(List<String> strings, List<String> otherStrings) {
    Validate.notNull(strings);
    Validate.notNull(otherStrings);

    List<String> list = new ArrayList<>(strings);

    int size = otherStrings.size();

    if (list.size() < size) {
      return list;
    }

    for (int i = 0; i < list.size(); i++) {
      if (i + size > list.size()) {
        break;
      }
      List<String> subList = list.subList(i, i + size);
      if (!subList.equals(otherStrings)) {
        continue;
      }
      for (int j = size; j > 0; j--) {
        list.remove(i + j - 1);
      }
      i -= i;
    }

    return list;
  }

  /**
   * Goes through a List and replaces the & symbol with the {@link org.bukkit.ChatColor} symbol
   * while replacing two ChatColor symbols with an &.
   *
   * @param strings List of Strings
   * @return colored List
   */
  public static List<String> colorList(List<String> strings, char symbol) {
    Validate.notNull(strings);

    List<String> list = new ArrayList<>();
    for (String s : strings) {
      list.add(s.replace(symbol, '\u00A7').replace("\u00A7\u00A7", String.valueOf(symbol)));
    }

    return list;
  }

}
