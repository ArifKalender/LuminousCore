package me.kugelblitz.luminouscore.luminousrealms.mechanics.mayorsystem.mayors;

import me.kugelblitz.luminouscore.luminousrealms.mechanics.mayorsystem.MayorHandler;
import me.kugelblitz.luminouscore.luminousrealms.util.Sounds;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.Random;

//COLE BENZERI, MADENCILIK ODAKLI
public class SeanMayorM implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if (MayorHandler.mayor == "sean") {
            if (block.getType() == Material.STONE || block.getType() == Material.DEEPSLATE) {

                Random random = new Random();
                double randomNumber = random.nextDouble();

                if (randomNumber < 0.005) {

                    ItemStack karma = new ItemStack(Material.GRAY_DYE, 1);
                    ItemMeta karmaMeta = karma.getItemMeta();
                    karmaMeta.setDisplayName("§dKarma");
                    karmaMeta.setLore(Arrays.asList("", "§3Ancient material used by miners", "§3to trade rare items.", "", "§e§lRARE"));
                    karma.setItemMeta(karmaMeta);
                    event.getBlock().getDrops().add(karma);
                    Sounds.rareDrop(player);
                }

            } else if (block.getType() == Material.DIAMOND_ORE) {
                Random random = new Random();
                double randomNumber = random.nextDouble();

                if (randomNumber < 0.5) {
                    event.getBlock().getDrops().add(new ItemStack(Material.DIAMOND, 1));
                }
            } else if (block.getType() == Material.IRON_ORE) {
                Random random = new Random();
                double randomNumber = random.nextDouble();

                if (randomNumber < 0.5) {
                    event.getBlock().getDrops().add(new ItemStack(Material.RAW_IRON, 1));
                }
            } else if (block.getType() == Material.GOLD_ORE) {
                Random random = new Random();
                double randomNumber = random.nextDouble();

                if (randomNumber < 0.5) {
                    event.getBlock().getDrops().add(new ItemStack(Material.RAW_GOLD, 1));
                }
            }
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * 20, 0, true));
        }
    }

}
