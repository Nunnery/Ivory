package net.nunnerycode.bukkit.libraries.ivory;

import com.bionicrm.litedater.LiteDater;
import net.nunnerycode.java.libraries.cannonball.DebugPrinter;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;
import java.util.logging.Level;

public abstract class IvoryPlugin extends JavaPlugin {

    private boolean useMetrics;
    private boolean useUpdater;
    private Metrics metrics;
    private DebugPrinter debugPrinter;
    private String debugFileName = "debug.log";

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
        preEnable();
        debugPrinter = new DebugPrinter(getDataFolder().getPath(), debugFileName);
        debug(Level.INFO, "Enabling " + getDescription().getName() + " v" + getDescription().getVersion());
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
            new LiteDater(this, true).performUpdateCheck();
        }
        postEnable();
    }

    @Override
    public final void onDisable() {
        preDisable();
        debug(Level.INFO, "Disabling " + getDescription().getName() + " v" + getDescription().getVersion());
        disable();
        postDisable();
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

    public abstract void preEnable();

    public abstract void enable();

    public abstract void postEnable();

    public abstract void preDisable();

    public abstract void disable();

    public abstract void postDisable();

    public DebugPrinter getDebugPrinter() {
        return debugPrinter;
    }

    public String getDebugFileName() {
        return debugFileName;
    }

    public void setDebugFileName(String debugFileName) {
        this.debugFileName = debugFileName;
    }

}
