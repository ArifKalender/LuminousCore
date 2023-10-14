package me.kugelblitz.luminouscore.luminousrealms.ui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class FootprintMenu implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("lumina.footprint")) {
                Inventory gui = Bukkit.createInventory(player, 9, "§3Choose Footprint!");

                ItemStack heart = new ItemStack(Material.RED_GLAZED_TERRACOTTA, 1);
                ItemMeta heartmeta = heart.getItemMeta();
                heartmeta.setDisplayName("§dHearts");
                heartmeta.setLore(Arrays.asList("§aClick here to set your", "§afootprint to §cHEARTS§a!"));
                heart.setItemMeta(heartmeta);
                ItemStack voidb = new ItemStack(Material.LODESTONE, 1);
                ItemMeta voidbmeta = voidb.getItemMeta();
                voidbmeta.setDisplayName("§7Void");
                voidbmeta.setLore(Arrays.asList("§aClick here to set your", "§afootprint to §7VOID§a!"));
                voidb.setItemMeta(voidbmeta);
                ItemStack witch = new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA, 1);
                ItemMeta witchmeta = witch.getItemMeta();
                witchmeta.setDisplayName("§5Witch");
                witchmeta.setLore(Arrays.asList("§aClick here to set your", "§afootprint to §5WITCH§a!"));
                witch.setItemMeta(witchmeta);
                ItemStack electric = new ItemStack(Material.LIGHT_BLUE_GLAZED_TERRACOTTA, 1);
                ItemMeta electricmeta = electric.getItemMeta();
                electricmeta.setDisplayName("§9Electric");
                electricmeta.setLore(Arrays.asList("§aClick here to set your", "§afootprint to §9ELECTRIC§a!"));
                electric.setItemMeta(electricmeta);
                ItemStack glowsquid = new ItemStack(Material.CYAN_CONCRETE_POWDER, 1);
                ItemMeta glowsquidmeta = glowsquid.getItemMeta();
                glowsquidmeta.setDisplayName("§3Glow Squid");
                glowsquidmeta.setLore(Arrays.asList("§aClick here to set your", "§afootprint to §3GLOW SQUID§a!"));
                glowsquid.setItemMeta(glowsquidmeta);
                ItemStack soul = new ItemStack(Material.SOUL_SOIL, 1);
                ItemMeta soulmeta = soul.getItemMeta();
                soul.setItemMeta(soulmeta);
                soulmeta.setDisplayName("§8Soul");
                soulmeta.setLore(Arrays.asList("§aClick here to set your", "§afootprint to §8SOUL§a!"));
                soul.setItemMeta(soulmeta);
                ItemStack disable = new ItemStack(Material.BARRIER, 1);
                ItemMeta disablemeta = disable.getItemMeta();
                disablemeta.setDisplayName("§CDISABLE");
                disablemeta.setLore(Arrays.asList("§aClick here to disable your", "§afootprint!"));
                disable.setItemMeta(disablemeta);

                gui.setItem(1, heart);
                gui.setItem(2, voidb);
                gui.setItem(3, witch);
                gui.setItem(4, disable);
                gui.setItem(5, electric);
                gui.setItem(6, glowsquid);
                gui.setItem(7, soul);
                player.openInventory(gui);
            }
        } else {
            sender.sendMessage("§cYou need to be a player to execute this command!");
        }

        return false;
    }
}
