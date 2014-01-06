package net.nunnerycode.bukkit.libraries.ivory.items;

import net.nunnerycode.bukkit.libraries.ivory.utils.StringListUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

/**
 * A class designed to create a book with an ItemMeta.
 */
public class MetaBook extends MetaItemStack {

	/**
	 * Instantiates a new MetaBook from a BookType, with an amount, damage, title, author, and pages.
	 * @param type type of book
	 * @param amount amount of books in ItemStack
	 * @param damage damage value of ItemStack
	 * @param title title of book
	 * @param author author of book
	 * @param pages pages of book
	 */
	public MetaBook(BookType type, int amount, short damage, String title, String author, String[] pages) {
		super(type.toMaterial(), amount, damage);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type.toMaterial());
		if (itemMeta == null || !(itemMeta instanceof BookMeta)) {
			return;
		}
		BookMeta bookMeta = (BookMeta) itemMeta;
		bookMeta.setTitle(title != null ? title.replace('&', '\u00A7').replace("\u00A7\u00A7", "&") : null);
		bookMeta.setAuthor(author != null ? author.replace('&', '\u00A7').replace("\u00A7\u00A7", "&") : null);
		bookMeta.setPages(pages != null ? StringListUtils.colorList(Arrays.asList(pages), '&') : null);
		setItemMeta(bookMeta);
	}

	/**
	 * Instantiates a new MetaBook from a BookType, with an amount, damage, title, author, and pages.
	 * @param type type of book
	 * @param amount amount of books in ItemStack
	 * @param damage damage value of ItemStack
	 * @param title title of book
	 * @param author author of book
	 * @param pages pages of book
	 */
	public MetaBook(BookType type, int amount, short damage, String title, String author, List<String> pages) {
		super(type.toMaterial(), amount, damage);
		ItemMeta itemMeta = hasItemMeta() ? getItemMeta() : Bukkit.getItemFactory().getItemMeta(type.toMaterial());
		if (itemMeta == null || !(itemMeta instanceof BookMeta)) {
			return;
		}
		BookMeta bookMeta = (BookMeta) itemMeta;
		bookMeta.setTitle(title != null ? title.replace('&', '\u00A7').replace("\u00A7\u00A7", "&") : null);
		bookMeta.setAuthor(author != null ? author.replace('&', '\u00A7').replace("\u00A7\u00A7", "&") : null);
		bookMeta.setPages(pages != null ? StringListUtils.colorList(pages, '&') : null);
		setItemMeta(bookMeta);
	}

	/**
	 * An Enum holding the different varieties of MetaBooks allowed to be created.
	 */
	public enum BookType {
		/**
		 * Represents the {@link Material#WRITTEN_BOOK}
		 */
		WRITTEN_BOOK(Material.WRITTEN_BOOK),
		/**
		 * Represents the {@link Material#BOOK_AND_QUILL}
		 */
		BOOK_AND_QUILL(Material.BOOK_AND_QUILL);
		private final Material material;

		private BookType(Material mat) {
			this.material = mat;
		}

		/**
		 * Returns a {@link Material} represented by the BookType.
		 *
		 * @return Material represented by the BookType
		 */
		public Material toMaterial() {
			return material;
		}
	}
}
