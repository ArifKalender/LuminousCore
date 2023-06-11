package me.kugelblitz.luminouscore.util;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.custom.customitems.items.CorruptedHeart;
import me.kugelblitz.luminouscore.statmanagement.Regeneration;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.UUID;

import static me.kugelblitz.luminouscore.LuminousCore.plugin;

public class NullFixer implements Listener {

    int i = 0;

    @EventHandler
    public void onJoin(PlayerLoginEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();

        if (PlayerStats.getStats().get(event.getPlayer().getUniqueId() + ".Info.hasPlayedBefore") == null) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, " §#ad07ff§lL§#9f20ff§lu§#9239fe§lm§#8451fe§li§#776afd§ln§#6983fd§la\n\n§3Your character has generated, you can rejoin!");
            Regeneration.mana.put(event.getPlayer(), 100.0);
            PlayerStats.getStats().set(uuid + ".Info.hasPlayedBefore", true);
            PlayerStats.getStats().set(uuid + ".Stats.Agility", 100);
            PlayerStats.getStats().set(uuid + ".Info.PlayerLevel", 0);
            PlayerStats.getStats().set(uuid + ".Info.FootPrint", "empty");
            PlayerStats.getStats().set(uuid + ".Stats.Intelligence", 100);
            PlayerStats.getStats().set(uuid + ".Stats.Aggression", 0);
            PlayerStats.getStats().set(uuid + ".Stats.MagicDamage", 0.25);
            PlayerStats.getStats().set(uuid + ".Stats.Penetration", 0);
            PlayerStats.getStats().set(uuid + ".Stats.PenetrationChance", 0.50);

            PlayerStats.saveStats();

        }
        event.getPlayer().setHealthScale(40);
        event.getPlayer().setHealthScaled(true);
        PlayerStats.getStats().set(uuid + ".Info.IpAddress", UtilizationMethods.getPlayerIPAddress(event.getPlayer()));
        event.getPlayer().setHealth(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
        CorruptedHeart.healcd.put(event.getPlayer(), false);

        Player player = event.getPlayer();
        player.setHealthScale(40);
        new BukkitRunnable() {
            @Override
            public void run() {
                ItemStack[] inventoryContents = player.getInventory().getContents();

                for (int slot = 0; slot < inventoryContents.length; slot++) {
                    if (slot == 8) {
                        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
                        ItemMeta itemMeta = item.getItemMeta();
                        itemMeta.setDisplayName("§dCrystal Lexicon");
                        itemMeta.setLore(Arrays.asList("","The guide that will help you","through your journey!"));
                        item.setItemMeta(itemMeta);
                        player.getInventory().setItem(8,item);
                    } else {

                        ItemStack item = inventoryContents[slot];

                        if (item != null && item.getType() != Material.AIR) {
                            ItemMeta meta = item.getItemMeta();
                            if (meta != null && meta.hasDisplayName() && meta.getDisplayName().equals("§dCrystal Lexicon")) {
                                player.getInventory().setItem(slot, null); // Remove the item
                            }
                        }
                    }
                }

            }
        }.runTaskTimer(plugin, 0, 20); // Replace 'plugin' with your reference to the plugin instance

    }
}
