package me.kugelblitz.luminouscore.PowerSurge;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.util.Vector;

public class ArenaKill implements Listener {

    @EventHandler
    public void onDamage(PlayerDeathEvent event) {

        Player player = event.getEntity();
        Entity killer = event.getEntity().getKiller();
        if (player.getWorld().getName().equalsIgnoreCase("powersurge")) {
            player.setBedSpawnLocation(player.getLocation());
            if (killer instanceof Player) {
                killer.getWorld().playSound(killer.getLocation(), Sound.ITEM_GOAT_HORN_SOUND_1, 1, 1);
                ((Player) killer).sendTitle("§6Congratulations!", "§7You killed §b" + player.getName(), 10, 40, 10);
                player.sendTitle("§cYikes! You died!", "§7You were killed by §b" + killer.getName());
            } else {
                player.sendTitle("§cYikes! You died!", "§7And you did it on your own! §c§oDisgrace...", 10, 40, 10);
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        // You can set the respawn location here based on your requirements
        if (player.getWorld().getName().equalsIgnoreCase("powersurge")) {
            player.setAllowFlight(true);
            player.setFlying(true);

            player.setGameMode(GameMode.ADVENTURE);
            player.setVelocity(new Vector(0, 1, 0));
            player.setGameMode(GameMode.SPECTATOR);

            Location respawnLocation = player.getLocation();
            event.setRespawnLocation(respawnLocation);
        }
    }
}


