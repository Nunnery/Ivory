package net.nunnerycode.bukkit.libraries.ivory.config;

public interface VersionedIvoryConfiguration {

    String getVersion();

    String getLocalVersion();

    boolean needsToUpdate();

    boolean update();

    public static enum VersionUpdateType {
        BACKUP_NO_UPDATE, BACKUP_AND_UPDATE, BACKUP_AND_NEW, NOTHING
    }

}
