package net.nunnerycode.bukkit.libraries.ivory.config;

import com.google.common.io.Files;

import org.apache.commons.lang.Validate;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

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
  public void save(File file) throws IOException {
    Files.createParentDirs(file);

    final String data = saveToString();

    BufferedWriter writer = null;
    try {
      writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),
                                                         StandardCharsets.UTF_8));
      writer.write(data);
    } finally {
      if (writer != null) {
        writer.close();
      }
    }
  }

  public void load(InputStream stream) throws IOException, InvalidConfigurationException {
    Validate.notNull(stream, "Stream cannot be null");

    InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
    StringBuilder builder = new StringBuilder();

    try (BufferedReader input = new BufferedReader(reader)) {
      String line;

      while ((line = input.readLine()) != null) {
        builder.append(line);
        builder.append('\n');
      }
    }

    loadFromString(builder.toString());
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
