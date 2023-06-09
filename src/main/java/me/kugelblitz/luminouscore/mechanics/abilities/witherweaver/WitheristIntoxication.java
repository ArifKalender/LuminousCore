package me.kugelblitz.luminouscore.mechanics.abilities.witherweaver;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class WitheristIntoxication {
    Location location;
    Location origin;
    Vector direction;

    public WitheristIntoxication(Player player) {
        location = player.getEyeLocation();
        origin = location.clone();
        direction = location.getDirection();
        new BukkitRunnable() {
            @Override
            public void run() {
                location.add(direction.multiply(1));
                location.getWorld().spawnParticle(Particle.SOUL, location, 8, 0.3F, 0.3F, 0.3F, 0.05F);
                for (Entity entity : location.getWorld().getNearbyEntities(location, 1, 1, 1)) {
                    if (entity instanceof LivingEntity) {
                        if (entity != player) {
                            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 5, 1, false));
                            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 5, 15, false));
                            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 5, 15, false));
                            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20 * 5, 15, false));
                            if (entity instanceof Player) {
                                entity.sendMessage("§cYou were cursed by " + player.getName() + '!');
                            }
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
