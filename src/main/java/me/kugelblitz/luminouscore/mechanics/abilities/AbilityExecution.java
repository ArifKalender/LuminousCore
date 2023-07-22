package me.kugelblitz.luminouscore.mechanics.abilities;

import me.kugelblitz.luminouscore.mechanics.abilities.deltus.Blink;
import me.kugelblitz.luminouscore.mechanics.abilities.deltus.FieryAura;
import me.kugelblitz.luminouscore.mechanics.abilities.deltus.MysticalSeal;
import me.kugelblitz.luminouscore.mechanics.abilities.siderealist.CelestialVitality;
import me.kugelblitz.luminouscore.mechanics.abilities.siderealist.MeteorCrash;
import me.kugelblitz.luminouscore.mechanics.abilities.siderealist.SpatialSoar;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.HighLeap;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.SilentLament;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.WitheristIntoxication;
import me.kugelblitz.luminouscore.mechanics.abilities.zodiac.CelestialZap;
import me.kugelblitz.luminouscore.mechanics.abilities.zodiac.SerenityUnifier;
import me.kugelblitz.luminouscore.mechanics.abilities.zodiac.ZenWhip;
import me.kugelblitz.luminouscore.util.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AbilityExecution implements Listener {

    String religion;

    @EventHandler
    public void onLeftClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.LEFT_CLICK_AIR) {

            if (player.getInventory() != null) {
                if (player.getInventory().getItemInMainHand() != null) {
                    if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
                            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§dCrystal Lexicon")) {
                                if(!player.isSneaking()){
                                    DefaultExecution(player);
                                }else {
                                    UltiExecution(player);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void DefaultExecution(Player player) {
        religion = PlayerStats.getStats().getString(player.getUniqueId() + ".Info.Religion");
        if (religion.equals("deltus")) {
            new MysticalSeal(player);
        } else if (religion.equals("siderealist")) {
            new CelestialVitality(player);
        } else if (religion.equals("witherweaver")) {
            new WitheristIntoxication(player);
        } else if (religion.equals("zodiac")) {
            new ZenWhip(player);
        } else {
            player.sendMessage("§cYou haven't chosen a religion!");
        }

    }

    public void UltiExecution(Player player) {
        religion = PlayerStats.getStats().getString(player.getUniqueId() + ".Info.Religion");
        if (religion.equals("deltus")) {
            new FieryAura(player);
        } else if (religion.equals("siderealist")) {
            new MeteorCrash(player);
        } else if (religion.equals("witherweaver")) {
            new SilentLament(player);
        } else if (religion.equals("zodiac")) {
            new SerenityUnifier(player);
        } else {
            player.sendMessage("§cYou haven't chosen a religion!");
        }

    }


    public void UtilExecution(Player player) {
        religion = PlayerStats.getStats().getString(player.getUniqueId() + ".Info.Religion");

        if (religion.equals("deltus")) {
            new Blink(player);
        } else if (religion.equals("siderealist")) {
            new SpatialSoar(player);
        } else if (religion.equals("witherweaver")) {
            new HighLeap(player);
        } else if (religion.equals("zodiac")) {
            new CelestialZap(player);
        } else {
            player.sendMessage("§cYou haven't chosen a religion!");
        }
    }
}



