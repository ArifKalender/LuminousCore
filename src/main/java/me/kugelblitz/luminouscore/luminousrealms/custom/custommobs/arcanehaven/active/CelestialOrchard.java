package me.kugelblitz.luminouscore.luminousrealms.custom.custommobs.arcanehaven.active;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.luminousrealms.util.UtilizationMethods;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;


public class CelestialOrchard {

    Location middle;
    double i = 0;

    public CelestialOrchard(Location location) {

        Zombie celestialOrchard = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE, false);

        ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND, false);
        armorStand.setInvisible(true);
        celestialOrchard.setAI(false);
        armorStand.getEquipment().setHelmet(new ItemStack(Material.SCULK_SHRIEKER, 1));
        celestialOrchard.setCustomName("§dCelestial Orchard §c[12000§e/§c12000]");
        armorStand.setCustomName("§dCelestial Orchard §c[12000§e/§c12000]");
        celestialOrchard.setInvisible(true);
        celestialOrchard.setCustomNameVisible(true);

        celestialOrchard.addPassenger(armorStand);
        new BukkitRunnable() {
            @Override
            public void run() {
                i++;
                middle = celestialOrchard.getEyeLocation();

                armorStand.setCustomName("§dCelestial Orchard §c[" + (int) celestialOrchard.getHealth() + "§e/§c" + (int) celestialOrchard.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + "]");
                for (Entity entity : location.getWorld().getNearbyEntities(location, 25, 25, 25)) {

                    if (entity instanceof Player) {
                        if (i % 8 == 0) {
                            Player player = (Player) entity;
                            player.damage(60, celestialOrchard);
                            UtilizationMethods.createBeam(middle, player.getEyeLocation(), Particle.CRIT_MAGIC);

                        }
                    }
                    celestialOrchard.getWorld().spawnParticle(Particle.GLOW, location, 60, 0.25, 1, 0.25, 0);

                }

                if (celestialOrchard.isDead()) {
                    armorStand.remove();
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 5);
    }

}
