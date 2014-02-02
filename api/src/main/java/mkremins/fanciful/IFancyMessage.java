package mkremins.fanciful;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface IFancyMessage {

  IFancyMessage color(ChatColor color);

  IFancyMessage style(ChatColor... styles);

  IFancyMessage file(String path);

  IFancyMessage link(String url);

  IFancyMessage suggest(String command);

  IFancyMessage command(String command);

  IFancyMessage achievementTooltip(String name);

  IFancyMessage itemTooltip(String itemJSON);

  IFancyMessage itemTooltip(ItemStack itemStack);

  IFancyMessage tooltip(String text);

  IFancyMessage then(Object obj);

  String toJSONString();

  void send(Player player);

}