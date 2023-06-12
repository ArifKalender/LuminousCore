package me.kugelblitz.luminouscore.ui.crystallexicon;

import me.kugelblitz.luminouscore.util.PlayerStats;
import me.kugelblitz.luminouscore.util.UtilizationMethods;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class CrystalLexicon {

    public CrystalLexicon(Player player){

        Inventory gui = Bukkit.createInventory(player, 9 * 3, "§dCrystal Lexicon");

        ItemStack fill = new ItemStack(Material.GRAY_STAINED_GLASS_PANE,1);
        ItemMeta fillMeta = fill.getItemMeta();
        fillMeta.setDisplayName("§7§lLumina");
        fill.setItemMeta(fillMeta);
        for(int i=0;i<27;i++){
            gui.setItem(i,fill);
        }

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
        gui.setItem(4,playerHead);

        ItemStack leveling = new ItemStack(Material.EMERALD, 1);
        ItemMeta levelingMeta = leveling.getItemMeta();
        levelingMeta.setDisplayName("§3" + player.getName() + "'s Valor");
        levelingMeta.setLore(Arrays.asList("", "§8Your Valor: [§7" + player.getLevel() + "§8]", "Leveling up your valor will increase", "your health, which indirectly increases", "your attack damage. To level up", "your valor, simply progress through", "the gameplay.", "", "§3Your health boost: " + (player.getLevel() * 7), "§3Your damage boost: " + (int) ((player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()-100) * 0.57)));
        leveling.setItemMeta(levelingMeta);
        gui.setItem(13,leveling);

        ItemStack enderChest = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta enderChestMeta = enderChest.getItemMeta();
        enderChestMeta.setDisplayName("§dEnder Chest");
        enderChestMeta.setLore(Arrays.asList("", "Click here to open your enderchest."));
        enderChest.setItemMeta(enderChestMeta);
        gui.setItem(14,enderChest);

        ItemStack skills = new ItemStack(Material.TOTEM_OF_UNDYING,1);
        ItemMeta skillsMeta = skills.getItemMeta();
        skillsMeta.setDisplayName("§9Your Skills");
        skillsMeta.setLore(Arrays.asList("","Click here to open your","skills menu!"));
        skills.setItemMeta(skillsMeta);
        gui.setItem(12,skills);

        player.openInventory(gui);
    }

}
