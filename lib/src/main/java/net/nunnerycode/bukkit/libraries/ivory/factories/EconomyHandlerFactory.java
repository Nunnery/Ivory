package net.nunnerycode.bukkit.libraries.ivory.factories;

import net.nunnerycode.bukkit.libraries.ivory.economy.AllPayEconomyHandler;
import net.nunnerycode.bukkit.libraries.ivory.economy.EconomyHandler;
import net.nunnerycode.bukkit.libraries.ivory.economy.VaultEconomyHandler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public final class EconomyHandlerFactory {

  private EconomyHandlerFactory() {
    // do nothing
  }

  public static EconomyHandler getNewEconomyHandler(Plugin plugin) {
    EconomyHandler economyHandler = null;
    if (Bukkit.getServer().getPluginManager().getPlugin("Vault") != null) {
      economyHandler = new VaultEconomyHandler(plugin);
    }
    if (economyHandler == null || !economyHandler.isEnabled()) {
      economyHandler = new AllPayEconomyHandler(plugin);
    }
    if (!economyHandler.isEnabled()) {
      plugin.getLogger().warning("Unable to hook into an Economy");
      return null;
    }
    return economyHandler;
  }

}
