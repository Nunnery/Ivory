package net.nunnerycode.bukkit.libraries.ivory;

import net.gravitydevelopment.updater.Updater;
import net.nunnerycode.bukkit.libraries.ivory.query.CurseForgeQuery;

import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;

public abstract class IvoryPlugin extends JavaPlugin {

  private boolean useMetrics;
  private boolean useUpdater;

  @Override
  public final void onEnable() {
    enable();
    if (isUseMetrics()) {
      try {
        Metrics metrics = new Metrics(this);
        metrics.start();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (isUseUpdater()) {
      CurseForgeQuery.BukkitProject
          project =
          new CurseForgeQuery().query(getDescription().getName());
      if (project != null) {
        Updater updater =
            new Updater(this, (int) project.getId(), getFile(), Updater.UpdateType.DEFAULT, true);
      }
    }
  }

  @Override
  public final void onDisable() {
    disable();
  }

  public final boolean isUseMetrics() {
    return useMetrics;
  }

  public final void setUseMetrics(boolean useMetrics) {
    this.useMetrics = useMetrics;
  }

  public final boolean isUseUpdater() {
    return useUpdater;
  }

  public final void setUseUpdater(boolean useUpdater) {
    this.useUpdater = useUpdater;
  }

  public abstract void enable();

  public abstract void disable();

}
