package me.kugelblitz.luminouscore.ui.LuminousManager;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class LuminousManagerSetupTask {

    private final Player player;

    public LuminousManagerSetupTask(Player player) {
        this.player = player;
    }

    public void start() {
        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                Inventory inventory = player.getInventory();
                if (!player.isOnline()) {
                    this.cancel();
                }
                // Set the 9th hotbar slot to a nether star with the name "§bLuminous Manager"
                ItemStack netherStar = new ItemStack(Material.NETHER_STAR);
                ItemMeta meta = netherStar.getItemMeta();
                meta.setDisplayName("§bLuminous Manager");
                netherStar.setItemMeta(meta);
                inventory.setItem(8, netherStar);

                // Remove other luminous managers from the inventory if not in the hotbar slot 9
                for (int slot = 0; slot < inventory.getSize(); slot++) {
                    if (slot != 8) { // Skip the 9th hotbar slot
                        ItemStack item = inventory.getItem(slot);
                        if (item != null && item.getType() == Material.NETHER_STAR &&
                                item.hasItemMeta() && item.getItemMeta().hasDisplayName() &&
                                item.getItemMeta().getDisplayName().equals("§bLuminous Manager")) {
                            inventory.setItem(slot, null);
                        }
                    }
                }
            }
        };

        runnable.runTaskTimer(LuminousCore.plugin, 0L, 20L); // Run every second (20 ticks)
    }
}

