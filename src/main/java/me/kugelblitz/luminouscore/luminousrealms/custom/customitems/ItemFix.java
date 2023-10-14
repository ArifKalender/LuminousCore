package me.kugelblitz.luminouscore.luminousrealms.custom.customitems;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

//eşyaların yere fırına falan koyulmasının fixlenmesi sınıfı bu
public class ItemFix implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        String name = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
        if (player.getInventory().getItemInMainHand() != null) {
            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
                    if (name.equals("§c§lCorrupted Heart")) {
                        event.setCancelled(true);
                        player.sendMessage("§cThis item can not be placed.");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock().getType() == Material.FURNACE) {
                event.setCancelled(true);
                player.sendMessage("§cThis container can not be opened.");
            }
        } else if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            Location location = event.getPlayer().getEyeLocation();

            for (int i = 0; i <= 4; i++) {
                location.add(player.getEyeLocation().getDirection().multiply(1));
                if (location.getWorld().getNearbyEntities(location, 1, 1, 1) != null) {
                    if (location.getWorld().getNearbyEntities(location, 1, 1, 1).contains(EntityType.MINECART_FURNACE)) {
                        event.setCancelled(true);
                        player.sendMessage("§cThis container can not be opened.");
                    }
                }
            }
        }
    }
}