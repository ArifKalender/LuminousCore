package me.kugelblitz.luminouscore.util;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.custom.customitems.items.CorruptedHeart;
import me.kugelblitz.luminouscore.mechanics.misc.LuminousManagerSetupTask;
import me.kugelblitz.luminouscore.mechanics.religionmanager.CrystalLexicon;
import me.kugelblitz.luminouscore.statmanagement.Regeneration;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class NullFixer implements Listener {

    int i = 0;

    @EventHandler
    public void onJoin(PlayerLoginEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        if (PlayerStats.getStats().get(event.getPlayer().getUniqueId() + ".Info.hasPlayedBefore") == null) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, " §#ad07ff§lL§#9f20ff§lu§#9239fe§lm§#8451fe§li§#776afd§ln§#6983fd§la\n\n§3Your character has generated, you can rejoin!");
            Regeneration.mana.put(event.getPlayer(), 100.0);
            PlayerStats.getStats().set(uuid + ".Info.hasPlayedBefore", true);
            PlayerStats.getStats().set(uuid + ".Stats.Agility", 100);
            PlayerStats.getStats().set(uuid + ".Info.PlayerLevel", 0);
            PlayerStats.getStats().set(uuid + ".Info.FootPrint", "empty");
            PlayerStats.getStats().set(uuid + ".Stats.Intelligence", 100);
            PlayerStats.getStats().set(uuid + ".Stats.Aggression", 0);
            PlayerStats.getStats().set(uuid + ".Stats.MagicDamage", 0.25);
            PlayerStats.getStats().set(uuid + ".Stats.Penetration", 0);
            PlayerStats.getStats().set(uuid + ".Stats.PenetrationChance", 0.50);

            PlayerStats.saveStats();

        }
        LuminousManagerSetupTask setupTask = new LuminousManagerSetupTask(event.getPlayer());
        setupTask.start();
        if (PlayerStats.getStats().get(event.getPlayer().getUniqueId() + ".Info.Religion") == null) {
            new BukkitRunnable() {
                @Override
                public void run() {

                    new CrystalLexicon().openLexicon(event.getPlayer());
                    if (PlayerStats.getStats().get(event.getPlayer().getUniqueId() + ".Info.Religion") != null) {
                        event.getPlayer().closeInventory();
                        this.cancel();
                    }
                    if (event.getPlayer().isOnline()) {
                        this.cancel();
                    }
                }
            }.runTaskTimer(LuminousCore.plugin, 0, 1);
        }
        event.getPlayer().setHealth(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
        CorruptedHeart.healcd.put(event.getPlayer(), false);

        Player player = event.getPlayer();
        player.setHealthScale(40);
        new BukkitRunnable() {

            @Override
            public void run() {
                i++;

                if (i <= 4) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30, 255, false));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 255, false));
                    player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                }
                if (i >= 10) {
                    CorruptedHeart.healcd.put(player, false);
                    i = 0;
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 1, 20);

    }
}
