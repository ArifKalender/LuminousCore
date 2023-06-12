package me.kugelblitz.luminouscore.mechanics.abilities;

import me.kugelblitz.luminouscore.mechanics.abilities.deltus.DeltusBeliever;
import me.kugelblitz.luminouscore.mechanics.abilities.deltus.FieryAura;
import me.kugelblitz.luminouscore.mechanics.abilities.deltus.MysticalSeal;
import me.kugelblitz.luminouscore.mechanics.abilities.siderealist.CelestialVitality;
import me.kugelblitz.luminouscore.mechanics.abilities.siderealist.MeteorCrash;
import me.kugelblitz.luminouscore.mechanics.abilities.siderealist.SideRealistFaith;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.SilentLament;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.WitheristFaith;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.WitheristIntoxication;
import me.kugelblitz.luminouscore.mechanics.abilities.zodiac.SerenityUnifier;
import me.kugelblitz.luminouscore.mechanics.abilities.zodiac.ZenWhip;
import me.kugelblitz.luminouscore.util.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class AbilityListener implements Listener {


    @EventHandler
    public void onLeftClick(PlayerAnimationEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand() != null) {
            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
                    if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dCrystal Lexicon"))

                        if (player.isSneaking()) {
                            if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion") == null) {
                                player.sendMessage("§cYou need to choose a religion to use its ability!");

                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("deltus")) {
                                new FieryAura(player);

                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("zodiac")) {
                                new SerenityUnifier(player);

                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("siderealist")) {
                                new MeteorCrash(player);
                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("witherweaver")) {
                                new SilentLament(player);
                            }
                        } else {
                            if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion") == null) {
                                player.sendMessage("§cYou need to choose a religion to use its ability!");
                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("deltus")) {
                                new MysticalSeal(player);
                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("zodiac")) {
                                new ZenWhip(player);
                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("siderealist")) {
                                new CelestialVitality(player);
                            } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("witherweaver")) {
                                new WitheristIntoxication(player);
                            }

                        }
                }
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("witherweaver")) {
            new WitheristFaith(player);
        } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("siderealist")) {
            new SideRealistFaith(player);
        } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("zodiac")) {

        } else if (PlayerStats.getStats().get(player.getUniqueId() + ".Info.Religion").equals("deltus")) {
            new DeltusBeliever(player);
        } else {

        }
    }
}
