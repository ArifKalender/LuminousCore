package me.kugelblitz.luminouscore.luminousrealms.custom.custommobs.arcanehaven.active;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.luminousrealms.util.UtilizationMethods;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class Dread {

    public Dread(Location location) {
        Blaze dread = (Blaze) location.getWorld().spawnEntity(location, EntityType.BLAZE, false);
        ItemStack dreadHelmet = new ItemStack(Material.WITHER_SKELETON_SKULL, 1);
        dread.getEquipment().setHelmet(dreadHelmet);
        dread.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40000);
        dread.setHealth(40000);

        dread.setCustomName("§cDread §c[" + (int) dread.getHealth() + "§e/§c" + (int) dread.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + "§c]");
        dread.setCustomNameVisible(true);
        dread.teleport(new Location(dread.getWorld(), dread.getLocation().getX(), dread.getLocation().getY() + 2, dread.getLocation().getZ()));
        new BukkitRunnable() {
            @Override
            public void run() {
                dread.setCustomName("§cDread §c[" + (int) dread.getHealth() + "§e/§c" + (int) dread.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + "§c]");
                new UtilizationMethods().createSerenity(dread.getLocation(), 1, Particle.END_ROD);
                if (dread.isDead()) {
                    dread.remove();
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 10);
    }

}
