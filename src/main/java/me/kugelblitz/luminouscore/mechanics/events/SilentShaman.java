package me.kugelblitz.luminouscore.mechanics.events;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.custom.custommobs.overworld.boss.ShamanAura;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class SilentShaman {

    public static boolean isSilentShamanActive;

    public SilentShaman(Location location) {
        isSilentShamanActive = true;

        new ShamanAura(location);
        new BukkitRunnable() {
            @Override
            public void run() {

                long time = location.getWorld().getTime();

                if (time < 13000 || time > 23000) {
                    isSilentShamanActive=true;
                    this.cancel();
                    return;
                }

                for (Entity entity : location.getWorld().getNearbyEntities(location, 30, 6, 30)) {
                    if (entity instanceof Player) {

                        Player player=(Player) entity;
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,60,3));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,60,3));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,60,1));

                    }
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 10);
    }

}
