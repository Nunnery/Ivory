package net.nunnerycode.bukkit.ivory;

import com.google.common.base.Joiner;
import mkremins.fanciful.FancyMessage;
import org.apache.commons.lang3.text.WordUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import se.ranzdo.bukkit.methodcommand.Command;
import se.ranzdo.bukkit.methodcommand.CommandHandler;

public class IvoryPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		CommandHandler commandHandler = new CommandHandler(this);
		commandHandler.registerCommands(new IvoryCommands(this));
	}

	@Override
	public void onDisable() {

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
			String displayName = WordUtils.capitalizeFully(Joiner.on(" ").join(itemStack.getType().name().split("_")));
			if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
				displayName = itemStack.getItemMeta().getDisplayName();
			}
			new FancyMessage(player.getName()).then(" has a ").then(displayName).send(player);
		}

	}

}
