package net.nunnerycode.bukkit.libraries.ivory.config;

import com.dumptruckman.bukkit.configuration.json.JsonConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class VersionedIvoryJsonConfiguration extends IvoryJsonConfiguration
    implements VersionedIvoryConfiguration {

  private JsonConfiguration checkAgainst;
  private VersionUpdateType updateType;

  /**
   * Instantiates a new VersionedIvoryYamlConfiguration with a selected {@link java.io.File} to
   * load/save from/to, a {@link java.io.File} to check against, and an {@link
   * net.nunnerycode.bukkit.libraries.ivory.config.VersionedIvoryYamlConfiguration.VersionUpdateType}.
   *
   * @param file         file to load/save from/to
   * @param checkAgainst file to check against
   * @param updateType   type of updating
   */
  public VersionedIvoryJsonConfiguration(File file, File checkAgainst,
                                         VersionUpdateType updateType)
      throws UnsupportedEncodingException {
    super(file);
    if (checkAgainst != null && checkAgainst.exists()) {
      this.checkAgainst = new IvoryJsonConfiguration(checkAgainst);
    }
    this.updateType = updateType;
  }

  /**
   * Instantiates a new VersionedIvoryYamlConfiguration with a selected {@link java.io.File} to
   * load/save from/to, a {@link java.io.InputStream} to check against, and an {@link
   * net.nunnerycode.bukkit.libraries.ivory.config.VersionedIvoryYamlConfiguration.VersionUpdateType}.
   *
   * @param file         file to load/save from/to
   * @param checkAgainst resource to check against
   * @param updateType   type of updating
   */
  public VersionedIvoryJsonConfiguration(File file, InputStream checkAgainst,
                                         VersionUpdateType updateType)
      throws UnsupportedEncodingException {
    super(file);
    if (checkAgainst != null) {
      this.checkAgainst = IvoryJsonConfiguration.loadConfiguration(checkAgainst);
    }
    this.updateType = updateType;
  }

  /**
   * Gets and returns the version passed into the constructor.
   *
   * @return version passed into the constructor
   */
  @Override
  public String getVersion() {
    return checkAgainst == null ? "" : checkAgainst.getString("version", "");
  }

  /**
   * Gets and returns the version contained in the actual YAML file.
   *
   * @return version in the YAML file
   */
  @Override
  public String getLocalVersion() {
    return getString("version", "");
  }

  /**
   * Returns true if this file needs to update itself and false if not.
   *
   * @return if file needs to update
   */
  @Override
  public boolean needsToUpdate() {
    return !(getVersion() == null && getLocalVersion() == null) && !getVersion()
        .equals(getLocalVersion());
  }

  /**
   * Attempts to update itself and returns if it succeeded.
   *
   * @return if update was successful
   */
  @Override
  public boolean update() {
    if (!needsToUpdate()) {
      return false;
    }
    File directory = getFile().getParentFile();
    File saveTo = new File(directory, getFile().getName().replace(".yml", ".yml.backup"));
    switch (updateType) {
      case BACKUP_NO_UPDATE:
        try {
          if (getFile().exists()) {
            save(saveTo);
          }
        } catch (IOException e) {
          return false;
        }
        return true;
      case BACKUP_AND_UPDATE:
        try {
          if (getFile().exists()) {
            save(saveTo);
          }
        } catch (IOException e) {
          return false;
        }
        for (String key : checkAgainst.getKeys(true)) {
          if (checkAgainst.isConfigurationSection(key)) {
            continue;
          }
          set(key, checkAgainst.get(key));
        }
        save();
        return true;
      case NOTHING:
      default:
        return true;
    }
  }

}
