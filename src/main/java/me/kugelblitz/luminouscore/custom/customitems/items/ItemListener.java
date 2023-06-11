package me.kugelblitz.luminouscore.custom.customitems.items;

import me.kugelblitz.luminouscore.statmanagement.Regeneration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (player.getInventory() != null) {
                if (player.getInventory().getItemInMainHand() != null) {
                    if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
                            String itemName = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
                            if (itemName.equals("§8Witherweaver Manuscript")) {
                                if (Regeneration.mana.get(player) < 200) {
                                    player.sendMessage("§cInsufficient mana.");
                                } else {
                                    Regeneration.mana.put(player, Regeneration.mana.get(player) - 200);
                                }
                                event.setCancelled(true);
                            } else if (itemName.equals("§c§lCorrupted Heart")) {
                                new CorruptedHeart(player);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.getName().contains("§4§l[BOSS] §cKraken")) {
            if (event.getEntity().getKiller() instanceof Player) {
                Player player = event.getEntity().getKiller();
                KrakenTooth.dropTooth(player);
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {

        if (event.getDamager() instanceof Player) {//attacker oyuncuysa
            Player player = (Player) event.getDamager();
            for (ItemStack item : player.getInventory().getContents()) {
                if (item != null) {
                    if (item.getItemMeta() != null) {
                        if (item.getItemMeta().getDisplayName() != null) {
                            if (item.getItemMeta().getDisplayName().equals("§3Kraken Tooth")) {
                                event.setDamage(event.getDamage() * 1.1);
                            }
                        }
                    }
                }
            }
        }

        if (event.getEntity() instanceof Player) {//victim oyuncuysa
            Player player = (Player) event.getEntity();
            for (ItemStack item : player.getInventory().getContents()) {
                if (item != null) {
                    if (item.getItemMeta() != null) {
                        if (item.getItemMeta().getDisplayName() != null) {
                            if (item.getItemMeta().getDisplayName().equals("§6§lTotem of Justice")) {
                                event.setCancelled(true);
                            }
                        }
                    }
                }
            }
        }
    }
}
