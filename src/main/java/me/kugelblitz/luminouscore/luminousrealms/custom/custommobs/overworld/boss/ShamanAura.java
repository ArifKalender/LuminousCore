package me.kugelblitz.luminouscore.luminousrealms.custom.custommobs.overworld.boss;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.luminousrealms.mechanics.events.SilentShaman;
import me.kugelblitz.luminouscore.luminousrealms.util.UtilizationMethods;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.scheduler.BukkitRunnable;

public class ShamanAura {

    public ShamanAura(Location location) {

        IronGolem shaman = (IronGolem) location.getWorld().spawnEntity(location, EntityType.IRON_GOLEM, false);
        shaman.setInvulnerable(true);
        shaman.setAI(false);
        shaman.setCustomName("§aShaman Aura");
        shaman.setCustomNameVisible(true);

        Location middleEye = shaman.getEyeLocation().add(shaman.getEyeLocation().getDirection());
        Location left = UtilizationMethods.getLeftSide(middleEye, 0.2);
        Location right = UtilizationMethods.getRightSide(middleEye, 0.2);

        new BukkitRunnable() {
            @Override
            public void run() {

                long time = shaman.getWorld().getTime();

                // Check if it's not night (between 13000 and 23000 ticks)
                if (time < 13000 || time > 23000) {
                    // Cancel the task if it's not night
                    this.cancel();
                    return;
                }

                left.getWorld().spawnParticle(Particle.TOTEM, left, 3, 0, 0, 0, 0);
                right.getWorld().spawnParticle(Particle.TOTEM, right, 3, 0, 0, 0, 0);
                SilentShaman.isSilentShamanActive = false;
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 10);
    }

}
