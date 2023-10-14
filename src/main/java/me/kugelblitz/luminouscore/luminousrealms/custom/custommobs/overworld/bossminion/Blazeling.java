package me.kugelblitz.luminouscore.luminousrealms.custom.custommobs.overworld.bossminion;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

public class Blazeling {

    public Blazeling(Location location) {
        Zombie blazeling = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE, false);
        blazeling.setInvisible(true);
        blazeling.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(10000);
        blazeling.setHealth(100);
        blazeling.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(260);
        blazeling.setFireTicks(1000000000);
        blazeling.setSilent(true);
        blazeling.setCustomName("§cVoidripper Blazeling");
        blazeling.setCustomNameVisible(true);


    }

}
