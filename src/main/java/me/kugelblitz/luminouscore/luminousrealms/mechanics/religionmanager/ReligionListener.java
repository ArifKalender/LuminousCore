package me.kugelblitz.luminouscore.luminousrealms.mechanics.religionmanager;

import me.kugelblitz.luminouscore.luminousrealms.util.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

public class ReligionListener implements Listener {

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        UUID uuid = player.getUniqueId();
        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().getItemMeta() != null) {
                if (event.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eZodiac Manuscript")) {
                        PlayerStats.getStats().set(uuid + ".Info.Religion", "zodiac");
                        player.sendMessage("§aYou just became a §eZodiac Believer!");
                        player.closeInventory();
                        PlayerStats.saveStats();
                        event.setCancelled(true);
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Deltus Manuscript")) {
                        PlayerStats.getStats().set(uuid + ".Info.Religion", "deltus");
                        player.sendMessage("§aYou just became a §3Deltus Believer!");
                        PlayerStats.saveStats();
                        player.closeInventory();
                        event.setCancelled(true);
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSiderealist Grimoire")) {
                        PlayerStats.getStats().set(uuid + ".Info.Religion", "siderealist");
                        player.sendMessage("§aYou just became a §cSiderealist!");
                        PlayerStats.saveStats();
                        player.closeInventory();
                        event.setCancelled(true);
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4WitherWeaver Grimoire")) {
                        PlayerStats.getStats().set(uuid + ".Info.Religion", "witherweaver");
                        player.sendMessage("§aYou just became a §4Witherweaver!");
                        PlayerStats.saveStats();
                        player.closeInventory();
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
