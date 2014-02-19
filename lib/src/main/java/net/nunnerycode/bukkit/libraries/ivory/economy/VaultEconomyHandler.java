package net.nunnerycode.bukkit.libraries.ivory.economy;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

public final class VaultEconomyHandler implements EconomyHandler {

  private Plugin plugin;
  private Economy economy;

  public VaultEconomyHandler(Plugin plugin) {
    this.plugin = plugin;
    if (!setupEconomy()) {
      this.plugin.getLogger().info("Could not connect to Economy");
    } else {
      this.plugin.getLogger().info("Hooked " + economy.getName());
    }
  }

  public Plugin getPlugin() {
    return plugin;
  }

  private boolean setupEconomy() {
    RegisteredServiceProvider<Economy> economyProvider =
        Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy
                                                                    .class);
    if (economyProvider != null) {
      economy = economyProvider.getProvider();
    }

    return (economy != null);
  }

  @Override
  public boolean hasEnough(Player player, double amount) {
    return economy.hasAccount(player.getName()) && economy.has(player.getName(), amount);
  }

  @Override
  public String format(double amount) {
    return economy.format(amount);
  }

  @Override
  public boolean pay(Player player, double amount) {
    return economy.hasAccount(player.getName()) && economy.depositPlayer(player.getName(),
                                                                         Math.abs(amount))
        .transactionSuccess();
  }

  @Override
  public boolean fine(Player player, double amount) {
    return economy.hasAccount(player.getName()) && economy.withdrawPlayer(player.getName(),
                                                                          Math.abs(
                                                                              amount))
        .transactionSuccess();
  }

  @Override
  public boolean setBalance(Player player, double amount) {
    double d = getBalance(player);
    if (d > 0) {
      fine(player, d);
    } else if (d < 0) {
      pay(player, d);
    }

    if (amount > 0) {
      pay(player, amount);
    } else if (amount < 0) {
      fine(player, amount);
    }

    return getBalance(player) == amount;
  }

  @Override
  public double getBalance(Player player) {
    return economy.hasAccount(player.getName()) ? economy.getBalance(player.getName()) : 0D;
  }

  @Override
  public boolean isEnabled() {
    return economy != null;
  }

}
