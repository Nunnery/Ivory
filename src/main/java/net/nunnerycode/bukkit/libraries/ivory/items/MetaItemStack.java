package net.nunnerycode.bukkit.libraries.ivory.items;

import net.nunnerycode.bukkit.libraries.ivory.utils.StringListUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

/**
 * A class designed to create an ItemStack with an ItemMeta.
 */
public class MetaItemStack extends ItemStack {

	/**
	 * Instantiates a MetaItemStack with a specified {@link org.bukkit.Material}.
	 *
	 * @param type Material of item
	 */
	public MetaItemStack(Material type) {
		super(type);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type);
		if (itemMeta == null) {
			return;
		}
		setItemMeta(itemMeta);
	}

	/**
	 * Instantiates a MetaItemStack with a specified {@link org.bukkit.Material} and amount.
	 *
	 * @param type   Material of item
	 * @param amount amount of items in ItemStack
	 */
	public MetaItemStack(Material type, int amount) {
		super(type, amount);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type);
		if (itemMeta == null) {
			return;
		}
		setItemMeta(itemMeta);
	}

	/**
	 * Instantiates a MetaItemStack with a specified {@link org.bukkit.Material}, amount, and damage value.
	 *
	 * @param type   Material of item
	 * @param amount amount of items in ItemStack
	 * @param damage damage value for ItemStack
	 */
	public MetaItemStack(Material type, int amount, short damage) {
		super(type, amount, damage);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type);
		if (itemMeta == null) {
			return;
		}
		setItemMeta(itemMeta);
	}

	/**
	 * Instantiates a MetaItemStack with a specified {@link org.bukkit.Material}, amount, damage, and name.
	 *
	 * @param type   Material of item
	 * @param amount amount of items in ItemStack
	 * @param damage damage value for ItemStack
	 * @param name   name for ItemStack
	 */
	public MetaItemStack(Material type, int amount, short damage, String name) {
		super(type, amount, damage);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type);
		if (itemMeta == null) {
			return;
		}
		itemMeta.setDisplayName(name != null ? name.replace('&', '\u00A7').replace("\u00A7\u00A7", "&") : null);
		setItemMeta(itemMeta);
	}

	/**
	 * Instantiates a MetaItemStack with a specified {@link org.bukkit.Material}, amount, damage, and lore.
	 *
	 * @param type   Material of item
	 * @param amount amount of items in ItemStack
	 * @param damage damage value for ItemStack
	 * @param lore   lore for ItemStack
	 */
	public MetaItemStack(Material type, int amount, short damage, List<String> lore) {
		super(type, amount, damage);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type);
		if (itemMeta == null) {
			return;
		}
		itemMeta.setLore(lore != null ? StringListUtils.colorList(lore, '&') : null);
		setItemMeta(itemMeta);
	}

	/**
	 * Instantiates a MetaItemStack with a specified {@link org.bukkit.Material}, amount, damage,
	 * and {@link org.bukkit.enchantments.Enchantment}s.
	 *
	 * @param type         Material of item
	 * @param amount       amount of items in ItemStack
	 * @param damage       damage value for ItemStack
	 * @param enchantments enchantments for ItemStack
	 */
	public MetaItemStack(Material type, int amount, short damage, Map<Enchantment, Integer> enchantments) {
		super(type, amount, damage);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type);
		if (itemMeta == null) {
			return;
		}
		for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
			itemMeta.addEnchant(entry.getKey(), entry.getValue(), true);
		}
		setItemMeta(itemMeta);
	}

	/**
	 * Instantiates a MetaItemStack with a specified {@link org.bukkit.Material}, amount, damage, name, and lore.
	 *
	 * @param type   Material of item
	 * @param amount amount of items in ItemStack
	 * @param damage damage value for ItemStack
	 * @param name   name for ItemStack
	 * @param lore   lore for ItemStack
	 */
	public MetaItemStack(Material type, int amount, short damage, String name, List<String> lore) {
		super(type, amount, damage);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type);
		if (itemMeta == null) {
			return;
		}
		itemMeta.setDisplayName(name != null ? name.replace('&', '\u00A7').replace("\u00A7\u00A7", "&") : null);
		itemMeta.setLore(lore != null ? StringListUtils.colorList(lore, '&') : null);
		setItemMeta(itemMeta);
	}

	/**
	 * Instantiates a MetaItemStack with a specified {@link org.bukkit.Material}, amount, damage, name,
	 * and {@link org.bukkit.enchantments.Enchantment}s.
	 *
	 * @param type         Material of item
	 * @param amount       amount of items in ItemStack
	 * @param damage       damage value for ItemStack
	 * @param name         name for ItemStack
	 * @param enchantments Enchantments for ItemStack
	 */
	public MetaItemStack(Material type, int amount, short damage, String name, Map<Enchantment, Integer> enchantments) {
		super(type, amount, damage);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type);
		if (itemMeta == null) {
			return;
		}
		itemMeta.setDisplayName(name != null ? name.replace('&', '\u00A7').replace("\u00A7\u00A7", "&") : null);
		for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
			itemMeta.addEnchant(entry.getKey(), entry.getValue(), true);
		}
		setItemMeta(itemMeta);
	}

	/**
	 * Instantiates a MetaItemStack with a specified {@link org.bukkit.Material}, amount, damage, lore,
	 * and {@link org.bukkit.enchantments.Enchantment}s.
	 *
	 * @param type         Material of item
	 * @param amount       amount of items in ItemStack
	 * @param damage       damage value for ItemStack
	 * @param lore         lore for ItemStack
	 * @param enchantments Enchantments for ItemStack
	 */
	public MetaItemStack(Material type, int amount, short damage, List<String> lore, Map<Enchantment,
			Integer> enchantments) {
		super(type, amount, damage);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type);
		if (itemMeta == null) {
			return;
		}
		itemMeta.setLore(lore != null ? StringListUtils.colorList(lore, '&') : null);
		for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
			itemMeta.addEnchant(entry.getKey(), entry.getValue(), true);
		}
		setItemMeta(itemMeta);
	}

	/**
	 * Instantiates a MetaItemStack with a specified {@link org.bukkit.Material}, amount, damage, name, lore,
	 * and {@link org.bukkit.enchantments.Enchantment}s.
	 *
	 * @param type         Material of item
	 * @param amount       amount of items in ItemStack
	 * @param damage       damage value for ItemStack
	 * @param name         name for ItemStack
	 * @param lore         lore for ItemStack
	 * @param enchantments Enchantments for ItemStack
	 */
	public MetaItemStack(Material type, int amount, short damage, String name, List<String> lore,
						 Map<Enchantment, Integer> enchantments) {
		super(type, amount, damage);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type);
		if (itemMeta == null) {
			return;
		}
		itemMeta.setDisplayName(name != null ? name.replace('&', '\u00A7').replace("\u00A7\u00A7", "&") : null);
		itemMeta.setLore(lore != null ? StringListUtils.colorList(lore, '&') : null);
		for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
			itemMeta.addEnchant(entry.getKey(), entry.getValue(), true);
		}
		setItemMeta(itemMeta);
	}

}
