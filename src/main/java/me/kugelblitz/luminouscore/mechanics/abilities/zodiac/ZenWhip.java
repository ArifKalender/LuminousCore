package me.kugelblitz.luminouscore.mechanics.abilities.zodiac;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.util.UtilizationMethods;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class ZenWhip {

    public static HashMap<Player, Boolean> zenCreeper = new HashMap<Player, Boolean>();
    Location location;
    Location origin;
    Vector direction;
    public ZenWhip(Player player) {
        if (zenCreeper.get(player) == null) {
            zenCreeper.put(player, true);
            location = player.getEyeLocation();
            origin = location.clone();
            direction = location.getDirection();
            Creeper creeper = (Creeper) location.getWorld().spawnEntity(location, EntityType.CREEPER, false);
            Creeper creeper2 = (Creeper) location.getWorld().spawnEntity(location, EntityType.CREEPER, false);
            Creeper creeper3 = (Creeper) location.getWorld().spawnEntity(location, EntityType.CREEPER, false);
            creeper.setInvulnerable(true);
            creeper.setPowered(true);
            creeper.setInvisible(true);
            creeper2.setInvulnerable(true);
            creeper2.setPowered(true);
            creeper2.setInvisible(true);
            creeper3.setInvulnerable(true);
            creeper3.setPowered(true);
            creeper3.setInvisible(true);
            creeper2.setAI(false);
            creeper.setAI(false);
            creeper3.setAI(false);
            new BukkitRunnable() {
                @Override
                public void run() {
                    direction = player.getLocation().getDirection();
                    location = location.add(direction.multiply(1));
                    creeper.teleport(location);
                    creeper2.teleport(UtilizationMethods.getLeftSide(location,2));
                    creeper3.teleport(UtilizationMethods.getRightSide(location,2));
                    for (Entity entity : creeper.getWorld().getNearbyEntities(location, 2, 2, 2)) {
                        if (entity instanceof LivingEntity) {
                            if (!(entity instanceof Player)) {
                                ((LivingEntity) entity).damage(player.getLevel() * 10);
                            }
                        }
                    }
                    if (location.distance(origin) > 25) {
                        creeper.remove();
                        creeper2.remove();
                        creeper3.remove();
                        zenCreeper.put(player,null);
                        this.cancel();
                    }
                }
            }.runTaskTimer(LuminousCore.plugin, 0, 1);
        }
    }
}
