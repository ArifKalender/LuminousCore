package me.kugelblitz.luminouscore.custom.custommobs.overworld.boss;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.custom.custommobs.overworld.active.SentientCore;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

//WIP
public class SerenityDivider {
    int i = 0;

    //vurunca kapı kırılma sesi
//arada bi vex çağırıyo, çağırdığında firework patlama sesi çıkarıyo
    public SerenityDivider(Location location) {
        WitherSkeleton serenityDivider = (WitherSkeleton) location.getWorld().spawnEntity(location, EntityType.WITHER_SKELETON, false);

        serenityDivider.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1000000);
        serenityDivider.setHealth(1000000);
        serenityDivider.setCustomName("§4§l[BOSS] §r§4Serenity Divider §c[1000000§e/§c1000000]");
        serenityDivider.setCustomNameVisible(true);

        serenityDivider.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET, 1));
        serenityDivider.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS, 1));
        serenityDivider.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1000);


        new BukkitRunnable() {
            @Override
            public void run() {
                i++;

                serenityDivider.setCustomName("§4§l[BOSS] §r§4Serenity Divider §c " + (int) serenityDivider.getHealth() + "§e/§c" + (int) serenityDivider.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                if (i % 400 == 0) {
                    serenityDivider.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, serenityDivider.getLocation(), 20, 5, 5, 5);
                    new SentientCore(serenityDivider.getLocation());
                }
                if (i % 20 == 0) {
                    serenityDivider.getWorld().playSound(serenityDivider.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 10f, 0);
                    serenityDivider.getWorld().playSound(serenityDivider.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE_FAR, 10f, 0);
                    serenityDivider.getWorld().playSound(serenityDivider.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 10f, 0);
                }
                if (i % 80 == 0) {
                    serenityDivider.getWorld().playSound(serenityDivider.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 10f, 0);
                }
                serenityDivider.getWorld().spawnParticle(Particle.GLOW, serenityDivider.getLocation(), 20, 1, 1, 1);

            }
        }.runTaskTimer(LuminousCore.plugin, 0, 1);
    }

}
