package me.kugelblitz.luminouscore.luminousrealms.mechanics.mayorsystem.mayors;

import me.kugelblitz.luminouscore.luminousrealms.util.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

//MARINA BENZERI, BALIKÇILIK ODAKLI
public class MuirgenMayorF implements Listener {


    public static void dropAncientRod(Player player) {
        ItemStack rod = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta rodmeta = rod.getItemMeta();
        rodmeta.setUnbreakable(true);
        rodmeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
        rodmeta.setLore(Arrays.asList("", "This is a rod that can only", "be held by the worthiest of", "players. Increases experience when", "fish is caught.", "", "§d§lREMARKABLE"));
        rodmeta.setDisplayName("§2Rod of The Ancient");
        rod.setItemMeta(rodmeta);
        player.getWorld().dropItem(player.getLocation(), rod);
        Sounds.remarkableDrop(player);
    }

    public static void spawnKraken(Player player) {
        Drowned kraken = (Drowned) player.getWorld().spawnEntity(player.getLocation(), EntityType.DROWNED);
        kraken.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(2000);
        kraken.setHealth(kraken.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
        kraken.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.4);
        kraken.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20 * 30000, 1));
        kraken.setCustomName("§4§l[BOSS] §cKraken");
        kraken.setTarget(player);
        kraken.setBaby(false);
        player.getWorld().playSound(player.getLocation(), Sound.BLOCK_END_PORTAL_SPAWN, 10, 2);
        player.sendMessage("§C§LBEWARE§r §cA kraken has emerged!");
        Sounds.bossSpawn(player);
    }

    public static void dropLuckShard(Player player) {
        ItemStack luckshard = new ItemStack(Material.AMETHYST_SHARD, 1);
        ItemMeta luckmeta = luckshard.getItemMeta();
        luckmeta.setDisplayName("§3Shard of Luck");
        luckmeta.setLore(Arrays.asList("", "§7Used for crafting the renowned", "§dCharm of Luck§7 which increases", "§7the §2❀ Luck§7 stat of player.", "", "§d§lREMARKABLE"));
        luckshard.setItemMeta(luckmeta);
        player.getWorld().dropItem(player.getLocation(), luckshard);
        Sounds.remarkableDrop(player);
    }

    @EventHandler
    public void onCatch(PlayerFishEvent event) {
        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            Player player = event.getPlayer();
            Random random = new Random();
            double money = random.nextDouble();
            double item = random.nextDouble();
            DecimalFormat df = new DecimalFormat("#.00");
            double format = Double.parseDouble(df.format(money * 10000));
            if (money < 0.25) {
                giveMoney(player, format);
            }
            if (item < 0.1) {
                if (item < 0.01) {
                    spawnKraken(player);
                } else if (item < 0.03) {
                    dropAncientRod(player);
                } else if (item < 0.06) {
                    dropLuckShard(player);
                } else if (item < 0.1) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 10 * 20 * 60, 1));
                    player.sendMessage("§3Muirgen: §eYou were blessed by the gods of water!");
                }
            }

        }
    }


    public void giveMoney(Player player, double amount) {
        if (Bukkit.getPluginManager().isPluginEnabled("Essentials")) {
            // Give money using Essentials economy
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + amount);
            player.sendMessage("You have received $" + amount);
        } else {
            player.sendMessage("Essentials plugin is not enabled.");
        }
    }
}