package me.kugelblitz.luminouscore.luminousrealms.custom.custommobs.overworld.active;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;

//wither king gibi olabilir, ya da gaia construct gibi olabilir
public class AliveStructure {

    public AliveStructure(Location location) {
        IronGolem aliveStructure = (IronGolem) location.getWorld().spawnEntity(location, EntityType.IRON_GOLEM, false);
        aliveStructure.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Entity entity : location.getWorld().getNearbyEntities(location, 25, 25, 25)) {

                    if (entity instanceof Player) {
                        aliveStructure.setTarget((LivingEntity) entity);
                    }

                }
                aliveStructure.setCustomName("§cAlive Structure " + (int) aliveStructure.getHealth() + "§e/§c" + aliveStructure.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                aliveStructure.setCustomNameVisible(true);
                location.getWorld().spawnParticle(Particle.END_ROD, aliveStructure.getEyeLocation(), 15, 0.2, 0.2, 0.2, 0.1);
                if (aliveStructure.isDead()) {
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 5);
    }

}
