package net.nunnerycode.bukkit.libraries.ivory.factories;

import org.bukkit.Bukkit;

import mkremins.fanciful.IFancyMessage;

/**
 * A class that allows users to use IFancyMessage without worrying about packages and versions.
 */
public final class FancyMessageFactory {

  private static FancyMessageFactory INSTANCE;

  private FancyMessageFactory() {
    // do nothing;
  }

  public static FancyMessageFactory getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new FancyMessageFactory();
    }
    return INSTANCE;
  }

  /**
   * Creates a new {@link mkremins.fanciful.IFancyMessage} for use. </br> Returns null if using a
   * package that's not recognized.
   *
   * @return new IFancyMessage
   */
  public IFancyMessage getNewFancyMessage() {
    String pkg = Bukkit.getServer().getClass().getPackage().getName();
    if (pkg.equals("org.bukkit.craftbukkit.v1_7_R2")) {
      return new mkremins.fanciful.v_1_7_R2.FancyMessage("");
    }
    if (pkg.equals("org.bukkit.craftbukkit.v1_7_R1")) {
      return new mkremins.fanciful.v_1_7_R1.FancyMessage("");
    }
    if (pkg.equals("org.bukkit.craftbukkit.v1_6_R3")) {
      return new mkremins.fanciful.v_1_6_R3.FancyMessage("");
    }
    if (pkg.equals("org.bukkit.craftbukkit.v1_6_R2")) {
      return new mkremins.fanciful.v_1_6_R2.FancyMessage("");
    }
    if (pkg.equals("org.bukkit.craftbukkit.v1_6_R1")) {
      return new mkremins.fanciful.v_1_6_R1.FancyMessage("");
    }
    if (pkg.equals("org.bukkit.craftbukkit.v1_5_R3")) {
      return new mkremins.fanciful.v_1_5_R3.FancyMessage("");
    }
    if (pkg.equals("org.bukkit.craftbukkit.v1_5_R2")) {
      return new mkremins.fanciful.v_1_5_R2.FancyMessage("");
    }
    if (pkg.equals("org.bukkit.craftbukkit.v1_5_R1")) {
      return new mkremins.fanciful.v_1_5_R1.FancyMessage("");
    }
    if (pkg.equals("org.bukkit.craftbukkit.v1_4_R1")) {
      return new mkremins.fanciful.v_1_4_R1.FancyMessage("");
    }
    if (pkg.equals("org.bukkit.craftbukkit.v1_4_6")) {
      return new mkremins.fanciful.v_1_4_6.FancyMessage("");
    }
    if (pkg.equals("org.bukkit.craftbukkit.v1_4_5")) {
      return new mkremins.fanciful.v_1_4_5.FancyMessage("");
    }
    throw new RuntimeException("Not running a supported version of Bukkit");
  }

}
