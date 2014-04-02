package org.nunnerycode.bukkit.ivory;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;

public interface IProjectileWrapper {

  LivingEntity getShooter(Projectile projectile);

}
