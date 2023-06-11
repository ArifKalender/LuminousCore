package me.kugelblitz.luminouscore.custom.custommobs.overworld.active;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

//pasif
public class GazesTheWaves {

    public GazesTheWaves(Location location) {

        Drowned gazesTheWaves = (Drowned) location.getWorld().spawnEntity(location, EntityType.DROWNED, false);
        gazesTheWaves.setCustomName("§aGazes the Waves");
        gazesTheWaves.setCustomNameVisible(true);
        gazesTheWaves.setBaby(false);
        gazesTheWaves.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(12000);
        gazesTheWaves.setHealth(12000);
        new BukkitRunnable() {
            @Override
            public void run() {
                gazesTheWaves.setCustomName("§3Gazes the Waves §c[" + (int) gazesTheWaves.getHealth() + "§e/§c" + (int) gazesTheWaves.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());

                if (gazesTheWaves.isDead()) {
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 20);
    }

}
