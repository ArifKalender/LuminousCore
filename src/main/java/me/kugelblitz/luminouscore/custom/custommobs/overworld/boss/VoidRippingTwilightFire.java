package me.kugelblitz.luminouscore.custom.custommobs.overworld.boss;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.custom.custommobs.overworld.bossminion.Blazeling;
import me.kugelblitz.luminouscore.mechanics.events.TwilightResonance;
import me.kugelblitz.luminouscore.util.UtilizationMethods;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

public class VoidRippingTwilightFire {
    Location random;

    int i = 0;

    public VoidRippingTwilightFire(Location location) {
        Blaze voidRippingTwilightFire = (Blaze) location.getWorld().spawnEntity(location, EntityType.BLAZE, false);

        voidRippingTwilightFire.setCustomName("§4Voidripping Twilight Fire §c[500000§e/§c500000]");
        voidRippingTwilightFire.setCustomNameVisible(true);
        voidRippingTwilightFire.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(500000);
        voidRippingTwilightFire.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(120);
        voidRippingTwilightFire.setHealth(500000);

        voidRippingTwilightFire.setFireTicks(100000000);
        new BukkitRunnable() {
            @Override
            public void run() {
                i++;
                voidRippingTwilightFire.setCustomName("§4Voidripping Twilight Fire §c" + (int) voidRippingTwilightFire.getHealth() + "§e/§c" + voidRippingTwilightFire.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                voidRippingTwilightFire.getWorld().playSound(voidRippingTwilightFire.getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1, 2);
                voidRippingTwilightFire.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, voidRippingTwilightFire.getEyeLocation(), 20, 1, 1, 1, 0.05);
                if (i % 20 == 0) {
                    voidRippingTwilightFire.getWorld().playSound(voidRippingTwilightFire.getLocation(), Sound.ENTITY_WITHER_SPAWN, 10, 2);
                    random = UtilizationMethods.getRandomLocation(voidRippingTwilightFire.getLocation(), 3);
                    new Blazeling(random);
                }

                if (i >= 2 * 60 * 10) {
                    i = 0;


                    voidRippingTwilightFire.remove();
                    Bukkit.broadcastMessage("§4Voidripping Twilight Fire§c has despawned.");
                    this.cancel();
                }
                if (voidRippingTwilightFire.isDead()) {
                    i = 0;
                    TwilightResonance.isTwilightResonance = false;
                    this.cancel();

                }

            }
        }.runTaskTimer(LuminousCore.plugin, 0, 10);
    }

}
