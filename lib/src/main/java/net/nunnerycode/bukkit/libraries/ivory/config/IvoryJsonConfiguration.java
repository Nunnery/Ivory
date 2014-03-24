package net.nunnerycode.bukkit.libraries.ivory.config;

import com.dumptruckman.bukkit.configuration.json.JsonConfiguration;

import org.bukkit.configuration.InvalidConfigurationException;

import java.io.File;
import java.io.IOException;

public class IvoryJsonConfiguration extends JsonConfiguration implements IvoryConfiguration {

  private File file;

  public IvoryJsonConfiguration(File file) {
    this.file = file;
  }

  @Override
  public void load() {
    try {
      load(file);
    } catch (InvalidConfigurationException | IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void save() {
    save(file);
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
