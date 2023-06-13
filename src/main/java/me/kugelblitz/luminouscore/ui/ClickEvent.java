package me.kugelblitz.luminouscore.ui;

import me.kugelblitz.luminouscore.ui.crystallexicon.CrystalLexicon;
import me.kugelblitz.luminouscore.util.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class ClickEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        UUID uuid = event.getWhoClicked().getUniqueId();
        if (event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null || event.getCurrentItem().getItemMeta().getDisplayName() == null) {
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§dHearts")) {
            setFootPrint("hearts", uuid);
            event.getWhoClicked().sendMessage("§aSet your footprint to §dHEARTS§a!");
            PlayerStats.saveStats();
            event.setCancelled(true);
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§7Void")) {
            setFootPrint("void", uuid);
            PlayerStats.saveStats();
            event.getWhoClicked().sendMessage("§aSet your footprint to §7VOID§a!");
            event.setCancelled(true);
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5Witch")) {
            setFootPrint("witch", uuid);
            PlayerStats.saveStats();
            event.getWhoClicked().sendMessage("§aSet your footprint to §5WITCH§a!");
            event.setCancelled(true);
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§cDISABLE")) {
            setFootPrint("empty", uuid);
            event.getWhoClicked().sendMessage("§aDisabled footprints!");
            PlayerStats.saveStats();
            event.setCancelled(true);
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§3Glow Squid")) {
            setFootPrint("glowsquid", uuid);
            PlayerStats.saveStats();
            event.getWhoClicked().sendMessage("§aSet your footprint to §3GLOW SQUID§a!");
            event.setCancelled(true);
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8Soul")) {
            setFootPrint("soul", uuid);
            PlayerStats.saveStats();
            event.getWhoClicked().sendMessage("§aSet your footprint to §8SOUL§a!");
            event.setCancelled(true);
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§9Electric")) {
            setFootPrint("electric", uuid);
            event.getWhoClicked().sendMessage("§aSet your footprint to §9ELECTRIC§a!");
            PlayerStats.saveStats();
            event.setCancelled(true);
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Your Skills")) {
            event.setCancelled(true);
            Bukkit.getServer().dispatchCommand(event.getWhoClicked(), "skills");
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dEnder Chest")) {
            event.setCancelled(true);
            event.getWhoClicked().openInventory(event.getWhoClicked().getEnderChest());
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a" + event.getWhoClicked().getName())) {
            event.setCancelled(true);
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3" + event.getWhoClicked().getName() + "'s Valor")) {
            event.setCancelled(true);
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lLumina")) {
            event.setCancelled(true);
        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dCrystal Lexicon")) {
            event.setCancelled(true);
            new CrystalLexicon((Player) event.getWhoClicked());
        }
    }


    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItemDrop().getItemStack();

        if (itemStack != null) {
            if (itemStack.getItemMeta() != null) {
                if (itemStack.getItemMeta().getDisplayName() != null) {
                    if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§dCrystal Lexicon")) {
                        new CrystalLexicon(player);
                        event.setCancelled(true);
                    }
                }
            }
        }
    }


    public void setFootPrint(String fp, UUID uuid) {
        PlayerStats.getStats().set(uuid + ".Info.FootPrint", fp);
    }

}
