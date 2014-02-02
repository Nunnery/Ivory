package mkremins.fanciful.v_1_4_5;

import net.minecraft.server.v1_4_5.NBTTagCompound;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_4_5.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.json.JSONException;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.List;

import mkremins.fanciful.IFancyMessage;

public final class FancyMessage implements IFancyMessage {

  private final List<MessagePart> messageParts;

  public FancyMessage(final String firstPartText) {
    messageParts = new ArrayList<MessagePart>();
    messageParts.add(new MessagePart(firstPartText));
  }

  @Override
  public IFancyMessage color(final ChatColor color) {
    if (!color.isColor()) {
      throw new IllegalArgumentException(color.name() + " is not a color");
    }
    latest().color = color;
    return this;
  }

  @Override
  public IFancyMessage style(final ChatColor... styles) {
    for (final ChatColor style : styles) {
      if (!style.isFormat()) {
        throw new IllegalArgumentException(style.name() + " is not a style");
      }
    }
    latest().styles = styles;
    return this;
  }

  @Override
  public IFancyMessage file(final String path) {
    onClick("open_file", path);
    return this;
  }

  @Override
  public IFancyMessage link(final String url) {
    onClick("open_url", url);
    return this;
  }

  @Override
  public IFancyMessage suggest(final String command) {
    onClick("suggest_command", command);
    return this;
  }

  @Override
  public IFancyMessage command(final String command) {
    onClick("run_command", command);
    return this;
  }

  @Override
  public IFancyMessage achievementTooltip(final String name) {
    onHover("show_achievement", "achievement." + name);
    return this;
  }

  @Override
  public IFancyMessage itemTooltip(final String itemJSON) {
    onHover("show_item", itemJSON);
    return this;
  }

  @Override
  public IFancyMessage itemTooltip(final ItemStack itemStack) {
    return itemTooltip(CraftItemStack.asNMSCopy(itemStack).save(new NBTTagCompound()).toString());
  }

  @Override
  public IFancyMessage tooltip(final String text) {
    onHover("show_text", text);
    return this;
  }

  @Override
  public IFancyMessage then(final Object obj) {
    messageParts.add(new MessagePart(obj.toString()));
    return this;
  }

  @Override
  public String toJSONString() {
    final JSONStringer json = new JSONStringer();
    try {
      if (messageParts.size() == 1) {
        latest().writeJson(json);
      } else {
        json.object().key("text").value("").key("extra").array();
        for (final MessagePart part : messageParts) {
          part.writeJson(json);
        }
        json.endArray().endObject();
      }
    } catch (final JSONException e) {
      throw new RuntimeException("invalid message");
    }
    return json.toString();
  }

  @Override
  public void send(Player player) {
    // do nothing
  }

  private MessagePart latest() {
    return messageParts.get(messageParts.size() - 1);
  }

  private void onClick(final String name, final String data) {
    final MessagePart latest = latest();
    latest.clickActionName = name;
    latest.clickActionData = data;
  }

  private void onHover(final String name, final String data) {
    final MessagePart latest = latest();
    latest.hoverActionName = name;
    latest.hoverActionData = data;
  }

}
