package net.nunnerycode.bukkit.libraries.ivory.economy;

import org.bukkit.entity.Player;

public interface EconomyHandler {

  boolean hasEnough(Player player, double amount);

  String format(double amount);

  boolean pay(Player player, double amount);

  boolean fine(Player player, double amount);

  boolean setBalance(Player player, double amount);

  double getBalance(Player player);

}