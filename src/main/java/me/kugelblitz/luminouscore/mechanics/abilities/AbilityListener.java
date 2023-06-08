package me.kugelblitz.luminouscore.mechanics.abilities;

import me.kugelblitz.luminouscore.mechanics.abilities.siderealist.CelestialVitality;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.SilentLament;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.WitheristFaith;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.WitheristIntoxication;
import me.kugelblitz.luminouscore.util.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class AbilityListener implements Listener {


    @EventHandler
    public void onLeftClick(PlayerAnimationEvent event){
        Player player = event.getPlayer();

        if(player.getInventory().getItemInMainHand()!=null){
            if(player.getInventory().getItemInMainHand().getItemMeta()!=null) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
                    if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bLuminous Manager"))

                        if (player.isSneaking()) {
                            if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("deltus")) {

                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("zodiac")) {

                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("siderealist")) {

                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("witherweaver")) {
                                new SilentLament(player);
                            } else {
                                player.sendMessage("§cYou need to choose a religion to use its ability!");
                            }
                        } else {
                            if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("deltus")) {

                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("zodiac")) {

                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("siderealist")) {
                                new CelestialVitality(player);
                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("witherweaver")) {
                                new WitheristIntoxication(player);
                            } else {
                                player.sendMessage("§cYou need to choose a religion to use its ability!");
                            }
                        }
                }
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(PlayerStats.getStats().get(player.getUniqueId()+".Info.Religion").equals("witherweaver")){
            new WitheristFaith(player);
        }
    }
}
