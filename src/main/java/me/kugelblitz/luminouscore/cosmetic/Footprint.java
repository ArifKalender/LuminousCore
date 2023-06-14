package me.kugelblitz.luminouscore.cosmetic;

import me.kugelblitz.luminouscore.util.PlayerStats;
import me.kugelblitz.luminouscore.util.UtilizationMethods;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class Footprint implements Listener {

    @EventHandler
    public void onWalk(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        String particle = (PlayerStats.getStats().getString(uuid + ".Info.FootPrint"));
        if (player.isSprinting()) {
            if (!(particle.equals("empty"))) {
                if (particle.equals("hearts")) {
                    playParticle(player, Particle.HEART);
                } else if (particle.equals("void")) {
                    playParticle(player, Particle.WARPED_SPORE);
                } else if (particle.equals("witch")) {
                    playParticle(player, Particle.SPELL_WITCH);
                } else if (particle.equals("electric")) {
                    playParticle(player, Particle.ELECTRIC_SPARK);
                } else if (particle.equals("glowsquid")) {
                    playParticle(player, Particle.GLOW);
                } else if (particle.equals("soul")) {
                    playParticle(player, Particle.SOUL);
                } else if (particle.equalsIgnoreCase("totem")) {
                    new UtilizationMethods().createSerenity(player.getLocation(),2,Particle.TOTEM);
                }
            }
        }
    }

    public void playParticle(Player player, Particle particle) {
        player.getWorld().spawnParticle(particle, player.getLocation(), 5, 0.3, 0.3, 0.3, 0.05);
    }
}
