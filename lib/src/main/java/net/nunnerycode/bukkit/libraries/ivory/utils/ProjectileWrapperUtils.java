package net.nunnerycode.bukkit.libraries.ivory.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.nunnerycode.bukkit.ivory.IProjectileWrapper;

import java.util.HashMap;
import java.util.Map;

public final class ProjectileWrapperUtils {

    private static final Map<String, IProjectileWrapper> projectileWrapperMap;

    static {
        projectileWrapperMap = new HashMap<>();
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_7_R4",
                new org.nunnerycode.bukkit.ivory.v_1_7_R4.ProjectileWrapper());
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_7_R3",
                new org.nunnerycode.bukkit.ivory.v_1_7_R3.ProjectileWrapper());
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_7_R2",
                new org.nunnerycode.bukkit.ivory.v_1_7_R2.ProjectileWrapper());
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_7_R1",
                new org.nunnerycode.bukkit.ivory.v_1_7_R1.ProjectileWrapper());
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_6_R3",
                new org.nunnerycode.bukkit.ivory.v_1_6_R3.ProjectileWrapper());
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_6_R2",
                new org.nunnerycode.bukkit.ivory.v_1_6_R2.ProjectileWrapper());
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_6_R1",
                new org.nunnerycode.bukkit.ivory.v_1_6_R1.ProjectileWrapper());
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_5_R3",
                new org.nunnerycode.bukkit.ivory.v_1_5_R3.ProjectileWrapper());
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_5_R2",
                new org.nunnerycode.bukkit.ivory.v_1_5_R2.ProjectileWrapper());
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_5_R1",
                new org.nunnerycode.bukkit.ivory.v_1_5_R1.ProjectileWrapper());
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_4_R1",
                new org.nunnerycode.bukkit.ivory.v_1_4_R1.ProjectileWrapper());
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_4_6",
                new org.nunnerycode.bukkit.ivory.v_1_4_6.ProjectileWrapper());
        projectileWrapperMap.put("org.bukkit.craftbukkit.v1_4_5",
                new org.nunnerycode.bukkit.ivory.v_1_4_5.ProjectileWrapper());
    }

    private ProjectileWrapperUtils() {
        // do nothing
    }

    public static LivingEntity getShooter(Projectile projectile) {
        if (projectile == null) {
            throw new IllegalArgumentException("Projectile cannot be null");
        }
        String pkg = Bukkit.getServer().getClass().getPackage().getName();
        IProjectileWrapper wrapper = projectileWrapperMap.get(pkg);
        if (wrapper == null) {
            wrapper = projectileWrapperMap.get("org.bukkit.craftbukkit.v1_7_R4");
        }
        return wrapper.getShooter(projectile);
    }

}
