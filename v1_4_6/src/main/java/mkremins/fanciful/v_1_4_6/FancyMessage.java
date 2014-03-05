package mkremins.fanciful.v_1_4_6;

import org.bukkit.Achievement;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mkremins.fanciful.IFancyMessage;

public final class FancyMessage implements IFancyMessage {

  private final StringBuilder stringBuilder;

  public FancyMessage(final String firstPartText) {
    stringBuilder = new StringBuilder(firstPartText);
  }

  @Override
  public IFancyMessage achievementTooltip(Achievement which) {
    return this;
  }

  @Override
  public IFancyMessage statisticTooltip(Statistic which) {
    return this;
  }

  @Override
  public IFancyMessage statisticTooltip(Statistic which, Material item) {
    return this;
  }

  @Override
  public IFancyMessage statisticTooltip(Statistic which, EntityType entity) {
    return this;
  }

  @Override
  public IFancyMessage color(final ChatColor color) {
    stringBuilder.append(color);
    return this;
  }

  @Override
  public IFancyMessage style(final ChatColor... styles) {
    for (final ChatColor style : styles) {
      if (!style.isFormat()) {
        throw new IllegalArgumentException(style.name() + " is not a style");
      }
      stringBuilder.append(style);
    }
    return this;
  }

  @Override
  public IFancyMessage file(final String path) {
    return this;
  }

  @Override
  public IFancyMessage link(final String url) {
    return this;
  }

  @Override
  public IFancyMessage suggest(final String command) {
    return this;
  }

  @Override
  public IFancyMessage command(final String command) {
    return this;
  }

  @Override
  public IFancyMessage achievementTooltip(final String name) {
    return this;
  }

  @Override
  public IFancyMessage itemTooltip(final String itemJSON) {
    return this;
  }

  @Override
  public IFancyMessage itemTooltip(final ItemStack itemStack) {
    return this;
  }

  @Override
  public IFancyMessage tooltip(final String text) {
    return this;
  }

  @Override
  public IFancyMessage then(final Object obj) {
    stringBuilder.append(String.valueOf(obj));
    return this;
  }

  @Override
  public String toJSONString() {
    return stringBuilder.toString();
  }

  @Override
  public void send(Player player) {
    player.sendMessage(toJSONString());
  }

}