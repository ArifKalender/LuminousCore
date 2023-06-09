package me.kugelblitz.luminouscore.mechanics.abilities.witherweaver;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.util.UtilizationMethods;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

//ulti shift sol tık
//moblar çıkarcak playera saldırmayan
//cd 120sn

public class SilentLament {
    public static HashMap<Player, Boolean> silentLamentCooldown = new HashMap<Player, Boolean>();
    public int j = 0;
    public int cd = 0;
    Location randomLocation;

    public SilentLament(Player player) {
        if (silentLamentCooldown.get(player) == null) {
            silentLamentCooldown.put(player, true);
            new BukkitRunnable() {
                @Override
                public void run() {
                    cd++;
                    if (cd >= 120) {
                        silentLamentCooldown.put(player, null);
                        this.cancel();
                        player.sendMessage("§aSilentShaman is available.");
                    }
                }
            }.runTaskTimer(LuminousCore.plugin, 0, 20);
            for (int i = 0; i <= 16; i++) {
                randomLocation = UtilizationMethods.getRandomLocation(player.getLocation(), 7);
                WitherSkeleton witherSkeleton = (WitherSkeleton) player.getWorld().spawnEntity(randomLocation, EntityType.WITHER_SKELETON, false);
                witherSkeleton.setInvulnerable(true);
                witherSkeleton.setCustomName("§c" + player.getName() + "'s Lament");
                witherSkeleton.setAI(false);

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        j++;
                        if (j >= 10) {
                            witherSkeleton.remove();
                            j = 0;
                            this.cancel();
                        }
                    }
                }.runTaskTimer(LuminousCore.plugin, 0, 10);


                new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (Entity entity : witherSkeleton.getNearbyEntities(5, 5, 5)) {
                            if (entity instanceof LivingEntity) {
                                if (entity != player) {
                                    ((LivingEntity) entity).damage(1000);
                                    entity.getLocation().getWorld().spawnParticle(Particle.SPELL_WITCH, entity.getLocation(), 15, 0.3F, 0.3F, 0.3F, 0F);
                                }
                            }
                        }
                        if (witherSkeleton.isDead()) {
                            this.cancel();
                        }
                    }
                }.runTaskTimer(LuminousCore.plugin, 0, 20);
            }
        } else {
            player.sendMessage("§cThis ability is on cooldown!");
        }
    }

}
