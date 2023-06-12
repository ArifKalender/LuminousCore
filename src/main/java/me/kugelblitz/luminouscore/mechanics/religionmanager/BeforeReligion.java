package me.kugelblitz.luminouscore.mechanics.religionmanager;

import me.kugelblitz.luminouscore.util.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class BeforeReligion implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory() != null) {
                if (player.getInventory().getItemInMainHand() != null) {
                    if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
                            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dCrystal Lexicon")) {
                                if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion") == null) {
                                    openLexicon(player);
                                } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("deltus")) {
                                } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("zodiac")) {
                                } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("siderealist")) {
                                } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("witherweaver")) {
                                }

                            }
                        }
                    }
                }
            }
        }
    }

    public void openLexicon(Player player) {
        Inventory gui = Bukkit.createInventory(player, 9, "§5Crystal Lexicon");
        ItemStack fill = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta fillMeta = fill.getItemMeta();
        fillMeta.setDisplayName("§e");
        fill.setItemMeta(fillMeta);
        ItemStack zodiacManuscript = new ItemStack(Material.BOOK);
        ItemStack deltusManuscript = new ItemStack(Material.WRITABLE_BOOK);
        ItemStack sideRealistManuscript = new ItemStack(Material.ENCHANTED_BOOK);
        ItemStack witherWeaverManuscript = new ItemStack(Material.KNOWLEDGE_BOOK);
        ItemMeta zodiacMeta = zodiacManuscript.getItemMeta();
        ItemMeta deltusMeta = deltusManuscript.getItemMeta();
        ItemMeta sideRealistMeta = sideRealistManuscript.getItemMeta();
        ItemMeta witherWeaverMeta = witherWeaverManuscript.getItemMeta();
        zodiacMeta.setDisplayName("§eZodiac Manuscript");
        deltusMeta.setDisplayName("§3Deltus Manuscript");
        sideRealistMeta.setDisplayName("§cSiderealist Grimoire");
        witherWeaverMeta.setDisplayName("§4WitherWeaver Grimoire");

        zodiacMeta.setLore(Arrays.asList("", "Zodiac believers obtain their power through", "the energies of stars and cosmic entities.", "They're the brethren of Side Realists.", "", "§3Agility: §a∎∎§8∎∎∎", "§3Regeneration: §a∎∎∎∎∎", "§3Offence: §a∎§8∎∎∎∎"));
        deltusMeta.setLore(Arrays.asList("", "Deltus believers believed the roots of all", "magic, the Deltus clan. They get their energy", "from the gods of Delta.", "", "§3Agility: §a∎§8∎∎∎∎", "§3Regeneration: §a∎§8∎∎∎∎", "§3Offence: §a∎∎∎∎∎"));
        witherWeaverMeta.setLore(Arrays.asList("", "Supporters of the WitherWeavers. The rival of", "Deltus clan. They wield the dark magic and", "use it to create summonings. The WitherWeaver", "believers are strong yet slow.", "", "§3Agility: §a∎§8∎∎∎∎", "§3Regeneration: §a∎∎§8∎∎∎", "§3Offence: §a∎∎∎∎§8∎"));
        sideRealistMeta.setLore(Arrays.asList("", "Brethren and rival of Zodiacs, similiar abilities", "but using dark magic. This religion's believers", "are much stronger but much defenseless.", "", "§3Agility: §a∎∎§8∎∎∎", "§3Regeneration: §a∎∎∎∎§8∎", "§3Offence: §a∎∎§8∎∎∎"));


        zodiacManuscript.setItemMeta(zodiacMeta);
        deltusManuscript.setItemMeta(deltusMeta);
        witherWeaverManuscript.setItemMeta(witherWeaverMeta);
        sideRealistManuscript.setItemMeta(sideRealistMeta);

        gui.setItem(0, fill);
        gui.setItem(1, fill);
        gui.setItem(2, zodiacManuscript);
        gui.setItem(3, deltusManuscript);
        gui.setItem(4, fill);
        gui.setItem(5, sideRealistManuscript);
        gui.setItem(6, witherWeaverManuscript);
        gui.setItem(7, fill);
        gui.setItem(8, fill);
        player.openInventory(gui);
    }
}
