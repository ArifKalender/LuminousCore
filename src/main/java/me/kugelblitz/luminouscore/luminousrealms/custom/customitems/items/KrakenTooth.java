package me.kugelblitz.luminouscore.luminousrealms.custom.customitems.items;

import me.kugelblitz.luminouscore.luminousrealms.util.Sounds;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

//krakenden düşcek
public class KrakenTooth implements Listener {

    public KrakenTooth(EntityDamageByEntityEvent event) {
        double damage = event.getDamage();
        double newdamage = damage * 1.1;
        event.setDamage(newdamage);
    }

    public static void dropTooth(Player player) {
        ItemStack tooth = new ItemStack(Material.PRISMARINE_SHARD, 1);
        ItemMeta toothmeta = tooth.getItemMeta();
        toothmeta.setDisplayName("§3Kraken Tooth");
        toothmeta.setLore(Arrays.asList("", "§3The Kraken tooth may provide", "§3the player who contains it in", "§3their inventory with a 10%", "§3damage increment.", "", "§d§LREMARKABLE"));
        tooth.setItemMeta(toothmeta);
        Location location = player.getLocation();
        Sounds.exoticDrop(player);
        location.getWorld().dropItem(location, tooth);
    }

}
