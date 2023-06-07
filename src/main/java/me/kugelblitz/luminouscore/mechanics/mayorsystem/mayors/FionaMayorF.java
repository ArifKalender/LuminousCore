package me.kugelblitz.luminouscore.mechanics.mayorsystem.mayors;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.mechanics.mayorsystem.MayorHandler;
import me.kugelblitz.luminouscore.util.Sounds;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.Random;

//FINNEGAN BENZERI, FARMING VE HAYVANCILIK ODAKLI
//RANDOMTICKSPEED 6
public class FionaMayorF implements Listener {

    private final Material[] cropMaterials = {
            Material.WHEAT,
            Material.CARROTS,
            Material.POTATOES,
            Material.BEETROOTS,
            // Add more crop materials if needed
    };

    public static void fionaSpeed() {
        new BukkitRunnable() {
            public void run() {
                if (MayorHandler.mayor.equals("fiona")) {
                    for (World world : Bukkit.getWorlds()) {
                        world.setGameRule(GameRule.RANDOM_TICK_SPEED, 9);
                    }
                } else {
                    // Handle the case when the mayor is not "fiona"
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 60 * 60 * 20);
    }

    public static void dropGorbet(Player player) {
        ItemStack item = new ItemStack(Material.POISONOUS_POTATO, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList("§7", "§e§3Gorbet§e, an ancient crop,", "§eis used for trades nowadays.", "", "§e§lRARE"));
        meta.setDisplayName("§3Gorbet");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        item.setItemMeta(meta);
        player.getInventory().addItem(item);
        player.updateInventory();
        Sounds.rareDrop(player);
    }

    public boolean isCrop(Block block) {
        Material blockType = block.getType();
        for (Material cropMaterial : cropMaterials) {
            if (blockType == cropMaterial) {
                return true; // Block is a crop
            }
        }
        return false; // Block is not a crop
    }

    public boolean isFullyAgedCrop(Block block) {
        Material blockType = block.getType();

        if (blockType == Material.WHEAT) {
            byte data = block.getData();
            return data == 7; // Fully aged wheat has a data value of 7
        } else if (blockType == Material.CARROTS || blockType == Material.POTATOES || blockType == Material.BEETROOTS) {
            return block.getBlockData().getAsString().contains("age=7"); // Fully aged carrots, potatoes, and beetroot have age=7
        }

        return false; // Not a crop or not fully aged
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBreak(BlockBreakEvent event) {

        if (MayorHandler.mayor.equals("fiona")) {
            if (isCrop(event.getBlock())) {
                Random random = new Random();
                Double number = random.nextDouble();
                event.getPlayer().sendMessage(number.toString());
                if (!event.isCancelled()) {
                    if (number <= 0.4) {
                        if (event.getBlock().getType() == Material.WHEAT) {
                            if (isFullyAgedCrop(event.getBlock())) {
                                event.getBlock().getWorld().spawnParticle(Particle.TOTEM, event.getBlock().getLocation(), 10, 0.2, 0.2, 0.2, 0.2);
                                ItemStack item = new ItemStack(Material.WHEAT, 1);
                                event.getPlayer().getInventory().addItem(item);
                            }
                        } else if (event.getBlock().getType() == Material.BEETROOTS) {
                            if (isFullyAgedCrop(event.getBlock())) {
                                event.getBlock().getWorld().spawnParticle(Particle.TOTEM, event.getBlock().getLocation(), 10, 0.2, 0.2, 0.2, 0.2);
                                ItemStack item = new ItemStack(Material.BEETROOT, 1);
                                event.getPlayer().getInventory().addItem(item);
                            }
                        } else if (event.getBlock().getType() == Material.POTATOES) {
                            if (isFullyAgedCrop(event.getBlock())) {
                                event.getBlock().getWorld().spawnParticle(Particle.TOTEM, event.getBlock().getLocation(), 10, 0.2, 0.2, 0.2, 0.2);
                                ItemStack item = new ItemStack(Material.POTATO, 1);
                                event.getPlayer().getInventory().addItem(item);
                            }
                        } else if (event.getBlock().getType() == Material.CARROTS) {
                            if (isFullyAgedCrop(event.getBlock())) {
                                event.getBlock().getWorld().spawnParticle(Particle.TOTEM, event.getBlock().getLocation(), 10, 0.2, 0.2, 0.2, 0.2);
                                ItemStack item = new ItemStack(Material.CARROT, 1);
                                event.getPlayer().getInventory().addItem(item);
                            }
                        }
                    }
                    if (isFullyAgedCrop(event.getBlock())) {
                        if (number < 0.01) {
                            dropGorbet(event.getPlayer());
                        }

                    }
                }
            }
        }
    }
}
