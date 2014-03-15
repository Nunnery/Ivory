package net.nunnerycode.bukkit.libraries.ivory.config;

import com.dumptruckman.bukkit.configuration.json.EncodedJsonConfiguration;
import com.dumptruckman.bukkit.configuration.json.JsonConfiguration;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

public class IvoryJsonConfiguration extends EncodedJsonConfiguration implements IvoryConfiguration {

  private File file;

  public IvoryJsonConfiguration(File file) throws UnsupportedEncodingException {
    super(StandardCharsets.UTF_8);
    this.file = file;
  }

  @Override
  public void load() {
    try {
      load(file);
    } catch (Exception e) {
      // do nothing
    }
  }

  @Override
  public void save() {
    try {
      save(file);
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

  public static JsonConfiguration loadConfiguration(InputStream inputStream) {
    JsonConfiguration jsonConfiguration = new JsonConfiguration();
    try {
      jsonConfiguration.load(inputStream);
    } catch (IOException | InvalidConfigurationException ex) {
      Bukkit.getLogger().log(Level.SEVERE, "Cannot load configuration from stream", ex);
    }

    return jsonConfiguration;
  }

}
