package me.kugelblitz.luminouscore.mechanics.abilities.siderealist;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;


public class CelestialVitality {
    Location location;
    Location origin;
    Vector direction;

    public CelestialVitality(Player player) {
        location = player.getEyeLocation();
        origin = location.clone();
        direction = location.getDirection();
        new BukkitRunnable() {
            @Override
            public void run() {
                location.add(direction.multiply(1));
                location.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, location, 8, 0.3F, 0.3F, 0.3F, 0.05F);
                for (Entity entity : location.getWorld().getNearbyEntities(location, 1, 1, 1)) {
                    if (entity instanceof LivingEntity) {
                        if (entity != player) {
                            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 20 * 5, 1, false));
                            if (entity instanceof Player) {
                                Player forEntity = (Player) entity;
                                forEntity.setAbsorptionAmount(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() / 10);
                                entity.sendMessage("§aYou were healed by " + player.getName() + '!');
                            }
                        } else {
                            player.setAbsorptionAmount(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() / 10);
                        }
                    }
                }

                if (origin.distance(location) >= 20) {
                    location = null;
                    direction = null;
                    origin = null;
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 1);
    }
}
