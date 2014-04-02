package net.nunnerycode.bukkit.libraries.ivory.config;

import com.dumptruckman.bukkit.configuration.json.JsonConfiguration;

import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public class IvoryJsonConfiguration extends JsonConfiguration implements IvoryConfiguration {

  private File file;

  public IvoryJsonConfiguration(File file) {
    super();
    this.file = file;
    load();
  }

  public static JsonConfiguration loadConfiguration(InputStream stream) {
    Validate.notNull(stream, "Stream cannot be null");

    JsonConfiguration config = new JsonConfiguration();

    try {
      config.load(stream);
    } catch (IOException | InvalidConfigurationException ex) {
      Bukkit.getLogger().log(Level.SEVERE, "Cannot load configuration from stream", ex);
    }

    return config;
  }

  @Override
  public void load() {
    try {
      load(file);
    } catch (InvalidConfigurationException | IOException e) {
      // do nothing
    }
  }

  @Override
  public void save() {
    try {
      save(file);
    } catch (IOException e) {
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
