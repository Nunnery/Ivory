package net.nunnerycode.bukkit.libraries.ivory.factories;

import mkremins.fanciful.IFancyMessage;
import org.bukkit.Bukkit;

/**
 * A class that allows users to use IFancyMessage without worrying about packages and versions.
 */
public final class FancyMessageFactory {

    private static FancyMessageFactory INSTANCE;

    private FancyMessageFactory() {
        // do nothing;
    }

    public static FancyMessageFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FancyMessageFactory();
        }
        return INSTANCE;
    }

    /**
     * Creates a new {@link mkremins.fanciful.IFancyMessage} for use.
     *
     * Returns null if using a package that's not recognized.
     *
     * @return new IFancyMessage
     */
    public IFancyMessage getNewFancyMessage() {
        return new IFancyMessage();
    }

}
