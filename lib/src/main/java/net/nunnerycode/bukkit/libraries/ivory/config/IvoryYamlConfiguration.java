package net.nunnerycode.bukkit.libraries.ivory.config;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * An extension of {@link org.bukkit.configuration.file.YamlConfiguration} that can perform
 * certain operations on itself.
 */
public class IvoryYamlConfiguration extends YamlConfiguration {

  private File file;

  /**
   * Instantiates a new IvoryYamlConfiguration with a selected {@link java.io.File} to load/save from/to.
   * @param file file to load/save from/to
   */
  public IvoryYamlConfiguration(File file) {
    super();
    this.file = file;
  }

  /**
   * Loads from the file passed into the constructor.
   * </br>
   * Equivalent of using {@link #load(java.io.File)} on a {@link java.io.File}.
   */
  public void load() {
    try {
      load(this.file);
    } catch (Exception e) {
      // do nothing
    }
  }

  /**
   * Saves to the file passed into the constructor.
   * </br>
   * Equivalent of using {@link #save(java.io.File)} on a {@link java.io.File}.
   */
  public void save() {
    try {
      save(this.file);
    } catch (Exception e) {
      // do nothing
    }
  }


}
