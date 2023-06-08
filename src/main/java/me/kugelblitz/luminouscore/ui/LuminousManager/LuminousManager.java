package me.kugelblitz.luminouscore.ui.LuminousManager;

import me.kugelblitz.luminouscore.util.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class LuminousManager implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory() != null) {
            if (player.getInventory().getItemInMainHand() != null) {
                if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                    if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
                        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bLuminous Manager")) {
                            openGui(player);
                        }
                    }
                }
            }
        }
    }


    public void openGui(Player player) {
        Inventory gui = Bukkit.createInventory(player, 9 * 3, "§3Luminous Manager");

        ItemStack fill = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta fillMeta = fill.getItemMeta();
        fillMeta.setDisplayName("§7§lLumina");
        fill.setItemMeta(fillMeta);

        ItemStack enderChest = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta enderChestMeta = enderChest.getItemMeta();
        enderChestMeta.setDisplayName("§dEnder Chest");
        enderChestMeta.setLore(Arrays.asList("", "Click here to open your enderchest."));
        enderChest.setItemMeta(enderChestMeta);

        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta playerHeadMeta = (SkullMeta) playerHead.getItemMeta();
        playerHeadMeta.setOwnerProfile(player.getPlayerProfile());
        playerHeadMeta.setDisplayName("§a" + player.getName());
        String religion = "§6❁ Religion: §e" + PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").toString().toUpperCase();
        String footprint = "§6➪ Footprint: §e" + PlayerStats.getStats().get(player.getUniqueId() + ".Info.FootPrint").toString().toUpperCase();
        String agility = "§6➤ Agility: §e" + PlayerStats.getStats().get(player.getUniqueId() + ".Stats.Agility").toString().toUpperCase();
        String intelligence = "§6♦ Intelligence: §e" + (int) PlayerStats.getStats().get(player.getUniqueId() + ".Stats.Intelligence");
        String maxHealth = "§6♥ Health: §e" + (int) player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        String damage = "§6⋇ Damage: §e" + (int) player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue();
        playerHeadMeta.setLore(Arrays.asList("", religion, footprint, intelligence, damage, maxHealth, agility));
        playerHead.setItemMeta(playerHeadMeta);

        ItemStack leveling = new ItemStack(Material.EMERALD,1);
        ItemMeta levelingMeta = leveling.getItemMeta();
        levelingMeta.setDisplayName("§3"+player.getName()+"'s Valor");
        levelingMeta.setLore(Arrays.asList("","§8Your Valor: [§7"+player.getLevel()+"§8]","Leveling up your valor will increase","your health, which indirectly increases","your attack damage. To level up","your valor, simply progress through","the gameplay.","","§3Your health boost: "+(player.getLevel()*7),"§3Your damage boost: "+(int)(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()*0.87)));
        leveling.setItemMeta(levelingMeta);
        for (int i = 0; i < 9 * 3; i++) {
            gui.setItem(i, fill);
        }
        gui.setItem(4, playerHead);
        gui.setItem(14, enderChest);
        gui.setItem(13, leveling);
        player.openInventory(gui);
    }
}
