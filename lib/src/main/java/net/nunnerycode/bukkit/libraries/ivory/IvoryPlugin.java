package net.nunnerycode.bukkit.libraries.ivory;

import net.gravitydevelopment.updater.Updater;
import net.nunnerycode.bukkit.libraries.ivory.query.CurseForgeQuery;
import net.nunnerycode.java.libraries.cannonball.DebugPrinter;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;
import java.util.logging.Level;

public abstract class IvoryPlugin extends JavaPlugin {

    private boolean useMetrics;
    private boolean useUpdater;
    private Metrics metrics;
    private Updater updater;
    private DebugPrinter debugPrinter;

    public Metrics getMetrics() {
        return metrics;
    }

    public final void debug(Level level, String... messages) {
        if (debugPrinter != null) {
            debugPrinter.debug(level, messages);
        }
    }

    @Override
    public final void onEnable() {
        debugPrinter = new DebugPrinter(getDataFolder().getPath(), "debug.log");
        enable();
        if (isUseMetrics()) {
            try {
                metrics = new Metrics(this);
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
                updater =
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

    public Updater getUpdater() {
        return updater;
    }

    public DebugPrinter getDebugPrinter() {
        return debugPrinter;
    }
}
