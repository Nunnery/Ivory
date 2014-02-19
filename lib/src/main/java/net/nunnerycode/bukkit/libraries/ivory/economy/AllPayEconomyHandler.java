package net.nunnerycode.bukkit.libraries.ivory.economy;

import com.fernferret.allpay.AllPay;
import com.fernferret.allpay.commons.GenericBank;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public final class AllPayEconomyHandler implements EconomyHandler {

  private Plugin plugin;
  private GenericBank genericBank;

  public AllPayEconomyHandler(Plugin plugin) {
    this.plugin = plugin;
    genericBank = new AllPay(this.plugin, this.plugin.getName()).loadEconPlugin();
    genericBank.toggleReceipts(false);
  }

  public Plugin getPlugin() {
    return plugin;
  }

  @Override
  public boolean hasEnough(Player player, double amount) {
    return genericBank.hasEnough(player, amount, -1);
  }

  @Override
  public String format(double amount) {
    return genericBank.getFormattedAmount(null, amount, -1);
  }

  @Override
  public boolean pay(Player player, double amount) {
    genericBank.give(player, amount, -1);
    return true;
  }

  @Override
  public boolean fine(Player player, double amount) {
    genericBank.take(player, amount, -1);
    return true;
  }

  @Override
  public boolean setBalance(Player player, double amount) {
    return genericBank.setBalance(player, -1, amount);
  }

  @Override
  public double getBalance(Player player) {
    return genericBank.getBalance(player, -1);
  }

  @Override
  public boolean isEnabled() {
    return genericBank != null;
  }

}
