package org.nunnerycode.bukkit.ivory.v_1_7_R3;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.ProjectileSource;
import org.nunnerycode.bukkit.ivory.IProjectileWrapper;

public final class ProjectileWrapper implements IProjectileWrapper {

    @Override
    public LivingEntity getShooter(Projectile projectile) {
        if (projectile == null) {
            return null;
        }
        ProjectileSource projectileSource = projectile.getShooter();
        if (!(projectileSource instanceof LivingEntity)) {
            return null;
        }
        return (LivingEntity) projectileSource;
    }

}
