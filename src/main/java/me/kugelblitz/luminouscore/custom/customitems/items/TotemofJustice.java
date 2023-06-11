package me.kugelblitz.luminouscore.custom.customitems.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class TotemofJustice {

    public TotemofJustice(EntityDamageByEntityEvent event) {

        if (event.getEntity() instanceof Player) {
            if (event.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
                Player player = (Player) event.getEntity();
                for (ItemStack item : player.getInventory().getContents()) {
                    if (item != null && item.getType() == Material.RAW_GOLD) {
                        if (item.getItemMeta() != null) {
                            if (item.getItemMeta().getDisplayName() != null) {
                                event.setCancelled(true);
                            }
                        }
                    }
                }
            }
        }
    }
}
