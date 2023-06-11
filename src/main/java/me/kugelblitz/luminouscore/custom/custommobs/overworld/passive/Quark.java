package me.kugelblitz.luminouscore.custom.custommobs.overworld.passive;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Quark {
    public Quark(Location location) {
        Zombie quark = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE, false);
        quark.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100);
        quark.setAI(false);
        quark.setCustomName("§eQuark");
        quark.setBaby(true);
        quark.setCustomNameVisible(true);
        ItemStack skullItem = new ItemStack(Material.MAGENTA_CONCRETE);
        quark.getEquipment().setHelmet(skullItem);
        quark.setInvisible(true);
        quark.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 999999, 255, false));
        quark.setHealth(100);

    }

}
