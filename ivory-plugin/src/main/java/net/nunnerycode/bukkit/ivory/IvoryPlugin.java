package net.nunnerycode.bukkit.ivory;

import com.google.common.base.Joiner;

import net.nunnerycode.bukkit.libraries.ivory.utils.JSONUtils;

import org.apache.commons.lang3.text.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import se.ranzdo.bukkit.methodcommand.Command;
import se.ranzdo.bukkit.methodcommand.CommandHandler;

import java.util.ArrayList;
import java.util.List;

import mkremins.fanciful.FancyMessage;

public class IvoryPlugin extends JavaPlugin {

  @Override
  public void onEnable() {
    CommandHandler commandHandler = new CommandHandler(this);
    commandHandler.registerCommands(new IvoryCommands(this));

    Bukkit.getPluginManager().registerEvents(new IvoryListener(this), this);
  }

  @Override
  public void onDisable() {

  }

  public class IvoryListener implements Listener {

    private IvoryPlugin plugin;

    private IvoryListener(IvoryPlugin plugin) {
      this.plugin = plugin;
    }

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
      String inHandReplace = "[hand]";

      String message = event.getMessage();
      ItemStack itemStack = event.getPlayer().getItemInHand();
      String
          displayName =
          WordUtils.capitalizeFully(Joiner.on(" ").join(itemStack.getType().name().split("_")));
      if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
        displayName = itemStack.getItemMeta().getDisplayName();
      }
      List<String> lore = new ArrayList<>();
      if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasLore()) {
        lore = itemStack.getItemMeta().getLore();
      }
      String
          tooltip =
          JSONUtils.toJSON(itemStack.getData().getItemTypeId(), itemStack.getData().getData(),
                           displayName, lore, itemStack.getEnchantments());

      message = message.replace(inHandReplace, tooltip);
      event.setMessage(message);
    }

  }

  public class IvoryCommands {

    private IvoryPlugin plugin;

    private IvoryCommands(IvoryPlugin plugin) {
      this.plugin = plugin;
    }

    public IvoryPlugin getPlugin() {
      return plugin;
    }

    @Command(identifier = "displayitem", description = "Displays item in player's hand",
             permissions = "ivory.displayitem")
    public void displayItemInHand(CommandSender commandSender) {
      if (!(commandSender instanceof Player)) {
        commandSender.sendMessage("This can only be used by players.");
        return;
      }
      Player player = (Player) commandSender;
      ItemStack itemStack = player.getItemInHand();
      String
          displayName =
          WordUtils.capitalizeFully(Joiner.on(" ").join(itemStack.getType().name().split("_")));
      if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
        displayName = itemStack.getItemMeta().getDisplayName();
      }
      List<String> lore = new ArrayList<>();
      if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasLore()) {
        lore = itemStack.getItemMeta().getLore();
      }
      String
          tooltip =
          JSONUtils.toJSON(itemStack.getData().getItemTypeId(), itemStack.getData().getData(),
                           displayName, lore, itemStack.getEnchantments());
      Bukkit.getLogger().info(tooltip);
      new FancyMessage(player.getName()).color(ChatColor.GREEN).then(" has a ")
          .color(ChatColor.BLUE).then
          (displayName).itemTooltip(tooltip).send(player);
    }

  }

}
