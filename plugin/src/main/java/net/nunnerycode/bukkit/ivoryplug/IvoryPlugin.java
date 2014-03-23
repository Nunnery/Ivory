package net.nunnerycode.bukkit.ivoryplug;

import net.nunnerycode.java.libraries.cannonball.DebugPrinter;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class IvoryPlugin extends JavaPlugin {

  private DebugPrinter debugPrinter;

  @Override
  public void onEnable() {
    debugPrinter = new DebugPrinter(getDataFolder().getPath(), "debug.log");

    debug(Level.INFO, "Running with server package: " + Bukkit.getServer().getClass().getPackage().getName());
    debug(Level.INFO, "v" + getDescription().getVersion() + " enabled");
  }

  public void debug(Level level, String... messages) {
    if (debugPrinter != null) {
      debugPrinter.debug(level, messages);
    }
  }

}
