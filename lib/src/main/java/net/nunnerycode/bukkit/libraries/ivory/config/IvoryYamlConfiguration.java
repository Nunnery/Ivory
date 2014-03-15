package net.nunnerycode.bukkit.libraries.ivory.config;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * An extension of {@link org.bukkit.configuration.file.YamlConfiguration} that can load and save
 * itself.
 */
public class IvoryYamlConfiguration extends YamlConfiguration implements IvoryConfiguration {

  private File file;

  /**
   * Instantiates a new IvoryYamlConfiguration with a selected {@link java.io.File} to load/save
   * from/to and automatically loads the file.
   *
   * @param file file to load/save from/to
   */
  public IvoryYamlConfiguration(File file) {
    this(file, '.');
  }


  /**
   * Instantiates a new IvoryYamlConfiguration with a selected {@link java.io.File} to load/save
   * from/to and automatically loads the file.
   *
   * @param file      file to load/save from/to
   * @param separator separator char
   */
  public IvoryYamlConfiguration(File file, char separator) {
    super();
    this.file = file;
    options().pathSeparator(separator);
    load();
  }

  /**
   * Loads from the file passed into the constructor. </br> Equivalent of using {@link
   * #load(java.io.File)} on a {@link java.io.File}.
   */
  @Override
  public void load() {
    try {
      load(this.file);
    } catch (Exception e) {
      // do nothing
    }
  }

  /**
   * Saves to the file passed into the constructor. </br> Equivalent of using {@link
   * #save(java.io.File)} on a {@link java.io.File}.
   */
  @Override
  public void save() {
    try {
      save(this.file);
    } catch (Exception e) {
      // do nothing
    }
  }

  @Override
  public File getFile() {
    return file;
  }

  @Override
  public String getFileName() {
    return file != null ? file.getName() : "";
  }


}
