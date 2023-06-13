package me.kugelblitz.luminouscore.mechanics.abilities.zodiac;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ZenWhip {
    Location location;
    Vector direction;

    public ZenWhip(Player player) {
        location = player.getEyeLocation();
        direction = location.getDirection();
        for (int i = 0; i <= 30; i++) {
            location.add(direction.multiply(1));
            location.getWorld().spawnParticle(Particle.END_ROD, location, 3, 0, 0, 0, 0.05);
            for (Entity entity : location.getWorld().getNearbyEntities(location, 1, 1, 1)) {
                    if (entity instanceof LivingEntity) {
                    if (!(entity instanceof Player)) {
                        ((LivingEntity) entity).damage(((LivingEntity) entity).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() * 0.01);
                    }
                }
            }
        }

    }
}
