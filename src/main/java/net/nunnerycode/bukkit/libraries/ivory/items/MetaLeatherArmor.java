package net.nunnerycode.bukkit.libraries.ivory.items;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

/**
 * A class designed to create Leather Armor with an ItemMeta.
 */
public class MetaLeatherArmor extends MetaItemStack {

	/**
	 * Instantiates a MetaLeatherArmor from a LeatherArmorType, with an amount, damage, and {@link org.bukkit.Color}.
	 *
	 * @param type   type of leather armor
	 * @param amount amount of ItemStack
	 * @param damage damage of ItemStack
	 * @param color  Color of ItemStack
	 */
	public MetaLeatherArmor(LeatherArmorType type, int amount, short damage, Color color) {
		super(type.toMaterial(), amount, damage);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type.toMaterial());
		if (itemMeta == null || !(itemMeta instanceof LeatherArmorMeta)) {
			return;
		}
		LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
		leatherArmorMeta.setColor(color);
		setItemMeta(leatherArmorMeta);
	}

	/**
	 * Instantiates a MetaLeatherArmor from a LeatherArmorType, with an amount, damage,
	 * and a {@link org.bukkit.Color} from RGB numbers.
	 *
	 * @param type   type of leather armor
	 * @param amount amount of ItemStack
	 * @param damage damage of ItemStack
	 * @param red    red of Color of ItemStack
	 * @param green  green of Color of ItemStack
	 * @param blue   blue of Color of ItemStack
	 */
	public MetaLeatherArmor(LeatherArmorType type, int amount, short damage, int red, int green, int blue) {
		super(type.toMaterial(), amount, damage);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type.toMaterial());
		if (itemMeta == null || !(itemMeta instanceof LeatherArmorMeta)) {
			return;
		}
		LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
		leatherArmorMeta.setColor(Color.fromRGB(red, green, blue));
		setItemMeta(leatherArmorMeta);
	}

	/**
	 * An Enum holding the different varieties of MetaLeatherArmors allowed to be created.
	 */
	public enum LeatherArmorType {
		LEATHER_HELMET(Material.LEATHER_HELMET),
		LEATHER_CHESTPLATE(Material.LEATHER_CHESTPLATE),
		LEATHER_LEGGINGS(Material.LEATHER_LEGGINGS),
		LEATHER_BOOTS(Material.LEATHER_BOOTS);

		private final Material material;

		private LeatherArmorType(Material material) {
			this.material = material;
		}

		public Material toMaterial() {
			return material;
		}
	}

}
