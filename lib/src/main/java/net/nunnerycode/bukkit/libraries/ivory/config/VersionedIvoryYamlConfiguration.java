package net.nunnerycode.bukkit.libraries.ivory.config;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * An extension of IvoryYamlConfiguration that can backup and update itself.
 */
public class VersionedIvoryYamlConfiguration extends IvoryYamlConfiguration {

  private YamlConfiguration checkAgainst;
  private VersionUpdateType updateType;

  /**
   * Instantiates a new VersionedIvoryYamlConfiguration with a selected {@link java.io.File} to
   * load/save from/to, a {@link java.io.File} to check against, and an {@link net.nunnerycode.bukkit.libraries.ivory.config.VersionedIvoryYamlConfiguration.VersionUpdateType}.
   *
   * @param file         file to load/save from/to
   * @param checkAgainst file to check against
   * @param updateType   type of updating
   */
  public VersionedIvoryYamlConfiguration(File file, File checkAgainst, VersionUpdateType updateType) {
    this(file, '.', checkAgainst, updateType);
  }

  /**
   * Instantiates a new VersionedIvoryYamlConfiguration with a selected {@link java.io.File} to
   * load/save from/to, a {@link java.io.InputStream} to check against, and an {@link net.nunnerycode.bukkit.libraries.ivory.config.VersionedIvoryYamlConfiguration.VersionUpdateType}.
   *
   * @param file         file to load/save from/to
   * @param checkAgainst resource to check against
   * @param updateType   type of updating
   */
  public VersionedIvoryYamlConfiguration(File file, InputStream checkAgainst,
                                         VersionUpdateType updateType) {
    this(file, '.', checkAgainst, updateType);
  }

  /**
   * Instantiates a new VersionedIvoryYamlConfiguration with a selected {@link java.io.File} to
   * load/save from/to, a {@link java.io.File} to check against, and an {@link net.nunnerycode.bukkit.libraries.ivory.config.VersionedIvoryYamlConfiguration.VersionUpdateType}.
   *
   * @param file         file to load/save from/to
   * @param checkAgainst file to check against
   * @param updateType   type of updating
   */
  public VersionedIvoryYamlConfiguration(File file, char separator, File checkAgainst,
                                         VersionUpdateType updateType) {
    super(file, separator);
    if (checkAgainst != null && checkAgainst.exists()) {
      this.checkAgainst = new IvoryYamlConfiguration(checkAgainst);
    }
    this.updateType = updateType;
  }

  /**
   * Instantiates a new VersionedIvoryYamlConfiguration with a selected {@link java.io.File} to
   * load/save from/to, a {@link java.io.InputStream} to check against, and an {@link net.nunnerycode.bukkit.libraries.ivory.config.VersionedIvoryYamlConfiguration.VersionUpdateType}.
   *
   * @param file         file to load/save from/to
   * @param checkAgainst resource to check against
   * @param updateType   type of updating
   */
  public VersionedIvoryYamlConfiguration(File file, char separator, InputStream checkAgainst,
                                         VersionUpdateType updateType) {
    super(file, separator);
    if (checkAgainst != null) {
      this.checkAgainst = YamlConfiguration.loadConfiguration(checkAgainst);
    }
    this.updateType = updateType;
  }

  /**
   * Gets and returns the version passed into the constructor.
   *
   * @return version passed into the constructor
   */
  public String getVersion() {
    return checkAgainst == null ? "" : checkAgainst.getString("version", "");
  }

  /**
   * Gets and returns the version contained in the actual YAML file.
   *
   * @return version in the YAML file
   */
  public String getLocalVersion() {
    return getString("version", "");
  }

  /**
   * Returns true if this file needs to update itself and false if not.
   *
   * @return if file needs to update
   */
  public boolean needsToUpdate() {
    return !(getVersion() == null && getLocalVersion() == null) && !getVersion()
        .equals(getLocalVersion());
  }

  /**
   * Attempts to update itself and returns if it succeeded.
   * @return if update was successful
   */
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
          set(key, checkAgainst.get(key));
        }
        save();
        return true;
      case NOTHING:
      default:
        return true;
    }
  }

  public static enum VersionUpdateType {
    BACKUP_NO_UPDATE, BACKUP_AND_UPDATE, NOTHING
  }


}
