package net.nunnerycode.bukkit.libraries.ivory.config;

import com.dumptruckman.bukkit.configuration.json.EncodedJsonConfiguration;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

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

}
