package net.nunnerycode.bukkit.libraries.ivory.settings;

import net.nunnerycode.bukkit.libraries.ivory.config.IvoryYamlConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class IvorySettings {

  private Map<String, Object> settingMap;

  public IvorySettings() {
    settingMap = new ConcurrentHashMap<>();
  }

  public Map<String, Object> getSettingMap() {
    return new HashMap<>(settingMap);
  }

  public Object get(String key, Object fallback) {
    return settingMap == null || !settingMap.containsKey(key) ? fallback : settingMap.get(key);
  }

  public void set(String key, Object object) {
    if (settingMap == null) {
      return;
    }
    settingMap.put(key, object);
  }

  public String getString(String key, String fallback) {
    if (settingMap == null || !settingMap.containsKey(key)) {
      return fallback;
    }
    Object val = settingMap.get(key);
    return !(val instanceof String) ? fallback : (String) val;
  }

  public List<String> getStringList(String key, List<String> fallback) {
    if (settingMap == null || !settingMap.containsKey(key)) {
      return fallback;
    }
    Object val = settingMap.get(key);
    if (!(val instanceof List)) {
      return fallback;
    }
    List<?> valList = (List) val;
    List<String> ret = new ArrayList<>();
    for (Object o : valList) {
      ret.add(String.valueOf(o));
    }
    return ret;
  }

  public boolean getBoolean(String key, boolean fallback) {
    if (settingMap == null || !settingMap.containsKey(key)) {
      return fallback;
    }
    Object val = settingMap.get(key);
    return !(val instanceof Boolean) ? fallback : (Boolean) val;
  }

  public int getInt(String key, int fallback) {
    if (settingMap == null || !settingMap.containsKey(key)) {
      return fallback;
    }
    Object val = settingMap.get(key);
    return !(val instanceof Integer) ? fallback : (Integer) val;
  }

  public long getLong(String key, long fallback) {
    if (settingMap == null || !settingMap.containsKey(key)) {
      return fallback;
    }
    Object val = settingMap.get(key);
    return !(val instanceof Long) ? fallback : (Long) val;
  }

  public double getDouble(String key, double fallback) {
    if (settingMap == null || !settingMap.containsKey(key)) {
      return fallback;
    }
    Object val = settingMap.get(key);
    return !(val instanceof Double) ? fallback : (Double) val;
  }

  public void load(IvoryYamlConfiguration... yamlConfigurations) {
    if (yamlConfigurations == null) {
      return;
    }
    for (IvoryYamlConfiguration yc : yamlConfigurations) {
      String name = yc.getFileName().replace(".yml", "");
      for (String key : yc.getKeys(true)) {
        if (yc.isConfigurationSection(key)) {
          continue;
        }
        set(name + "." + key, yc.get(key));
      }
    }
  }

  public static IvorySettings loadFromFiles(IvoryYamlConfiguration... yamlConfigurations) {
    IvorySettings ivorySettings = new IvorySettings();
    ivorySettings.load(yamlConfigurations);
    return ivorySettings;
  }
  
}
