package net.nunnerycode.bukkit.libraries.ivory.utils;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public final class LocationUtils {

    private LocationUtils() {
        // do nothing
    }

    public static boolean isLocationBetween(Location loc1, Location loc2, Location locToTest) {
        if (loc1 == null || loc2 == null || locToTest == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }

        int minX = Math.min(loc1.getBlockX(), loc2.getBlockX());
        int maxX = Math.min(loc1.getBlockX(), loc2.getBlockX());
        int minY = Math.min(loc1.getBlockY(), loc2.getBlockY());
        int maxY = Math.min(loc1.getBlockY(), loc2.getBlockY());
        int minZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
        int maxZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());

        int x = locToTest.getBlockX();
        int y = locToTest.getBlockY();
        int z = locToTest.getBlockZ();

        return minX <= x && x <= maxX && minY <= y && y <= maxY && minZ <= z && z <= maxZ;
    }

    public static boolean isLocationDistanceFromLocation(Location loc1, Location loc2, double dist) {
        if (loc1 == null || loc2 == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }
        double distance = loc1.distanceSquared(loc2);
        return distance >= (dist * dist);
    }

    public static Location parseLocation(String string) {
        if (string == null) {
            return null;
        }
        String[] split = string.split(",");
        if (split.length < 4) {
            return null;
        }
        String worldName = split[0];
        String xString = split[1];
        String yString = split[2];
        String zString = split[3];
        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            return null;
        }
        return new Location(world, NumberUtils.toInt(xString), NumberUtils.toInt(yString), NumberUtils.toInt(zString));
    }

}
