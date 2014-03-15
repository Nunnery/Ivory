package net.nunnerycode.bukkit.libraries.ivory.config;

import java.io.File;

public interface IvoryConfiguration {

  void load();

  void save();

  File getFile();

  String getFileName();

}
