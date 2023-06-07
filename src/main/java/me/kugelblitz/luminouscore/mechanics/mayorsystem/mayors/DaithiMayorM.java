package me.kugelblitz.luminouscore.mechanics.mayorsystem.mayors;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.mechanics.mayorsystem.MayorHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

//FOXY BENZERI, EVENT DOLU EĞLENCELI
public class DaithiMayorM implements Listener {
    public static void daithiEvent() {


        new BukkitRunnable() {
            public void run() {
                if (MayorHandler.mayor.equals("daithi")) {
                    Player[] players = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);
                    int playerCount = players.length;

                    if (playerCount > 0) {
                        int randomIndex = (int) (Math.random() * playerCount);
                        Player randomPlayer = players[randomIndex];
                        if (!randomPlayer.getWorld().getName().equals("void")) {
                            ItemStack diamond = new ItemStack(Material.DIAMOND, 12);
                            randomPlayer.getInventory().addItem(diamond);
                            Bukkit.getServer().broadcastMessage("§eDaithi: §3" + randomPlayer.getName() + "§b won the raffle!");
                        }
                    }
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 60 * 60 * 20);
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        if (MayorHandler.mayor.equals("daithi")) {
            if (event.getEntity().getKiller() instanceof Player) {
                Random random = new Random();
                double randomNumber = random.nextDouble();
                if (randomNumber <= 0.40) {
                    for (ItemStack drop : event.getDrops()) {
                        if (drop != null) {
                            drop.setAmount(drop.getAmount() * 2);
                            event.getEntity().getWorld().spawnParticle(Particle.END_ROD, event.getEntity().getLocation(), 10, 0.2, 0.2, 0.2, 0.2);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (MayorHandler.mayor.equals("daithi")) {

            Player player = event.getPlayer();
            new BukkitRunnable() {

                @Override
                public void run() {
                    if (!(player.isOnline())) {
                        this.cancel();
                    }
                    Random random = new Random();
                    double randomNumber = random.nextDouble();
                    if (randomNumber <= 0.2) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60 * 20, 0));
                        player.sendTitle("§a", "§aA gentle breeze is splashing your face!", 15, 60, 15);
                    }
                }
            }.runTaskTimer(LuminousCore.plugin, 0, 60 * 20);
        }
    }
}

