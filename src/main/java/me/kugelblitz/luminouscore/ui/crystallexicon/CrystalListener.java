package me.kugelblitz.luminouscore.ui.crystallexicon;

import me.kugelblitz.luminouscore.util.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CrystalListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (player.getInventory() != null) {
                if (player.getInventory().getItemInMainHand() != null) {
                    if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
                            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dCrystal Lexicon")) {
                                if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion") == null) {
                                    new CrystalLexicon(player);
                                } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("deltus")) {
                                    new CrystalLexicon(player);
                                } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("zodiac")) {
                                    new CrystalLexicon(player);
                                } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("siderealist")) {
                                    new CrystalLexicon(player);
                                } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("witherweaver")) {
                                    new CrystalLexicon(player);
                                } else {
                                    new RCrystalLexicon(player);
                                }

                            }
                        }
                    }
                }
            }
        }
    }

}
