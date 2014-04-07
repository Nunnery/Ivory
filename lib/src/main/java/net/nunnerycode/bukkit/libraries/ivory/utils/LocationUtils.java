package net.nunnerycode.bukkit.libraries.ivory.utils;

import org.bukkit.Location;

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

}
