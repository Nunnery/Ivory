package org.nunnerycode.bukkit.ivory.v_1_5_R3;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.nunnerycode.bukkit.ivory.IProjectileWrapper;

public final class ProjectileWrapper implements IProjectileWrapper {

  @Override
  public LivingEntity getShooter(Projectile projectile) {
    if (projectile == null) {
      return null;
    }
    return projectile.getShooter();
  }

}
