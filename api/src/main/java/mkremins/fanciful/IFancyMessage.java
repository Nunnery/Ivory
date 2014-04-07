package mkremins.fanciful;

import org.bukkit.Achievement;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface IFancyMessage {

    IFancyMessage color(ChatColor color);

    IFancyMessage style(ChatColor... styles);

    IFancyMessage file(String path);

    IFancyMessage link(String url);

    IFancyMessage suggest(String command);

    IFancyMessage command(String command);

    IFancyMessage achievementTooltip(String name);

    IFancyMessage achievementTooltip(Achievement which);

    IFancyMessage statisticTooltip(Statistic which);

    IFancyMessage statisticTooltip(Statistic which, Material item);

    IFancyMessage statisticTooltip(Statistic which, EntityType entity);

    IFancyMessage itemTooltip(String itemJSON);

    IFancyMessage itemTooltip(ItemStack itemStack);

    IFancyMessage tooltip(String text);

    IFancyMessage tooltip(String... lines);

    IFancyMessage tooltip(List<String> lines);

    IFancyMessage then(Object obj);

    String toJSONString();

    void send(Player player);

    void send(Iterable<Player> players);

}
