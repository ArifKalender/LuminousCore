package me.kugelblitz.luminouscore.util;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UtilizationMethods {

    public static Location getRandomLocation(Location location, double radius) {
        Random random = new Random();
        double angle = random.nextDouble() * 2 * Math.PI; // Random angle in radians
        double x = location.getX() + radius * Math.cos(angle);
        double z = location.getZ() + radius * Math.sin(angle);
        double y = location.getY(); // Start checking from the entity's Y-coordinate

        for (int i = 0; i < 10; i++) { // Attempt up to 10 times
            y--;
            Location floorLocation = new Location(location.getWorld(), x, y, z);
            Block floorBlock = floorLocation.getBlock();

            if (floorBlock.getType().isSolid()) {
                y++;
                Location randomLocation = new Location(location.getWorld(), x, y, z);
                return randomLocation;
            }
        }

        // If no suitable floor is found, return the original entity's location
        return location;
    }


    public static void createBeam(Location location1, Location location2, Particle particle) {
        double distance = location1.distance(location2);
        int particles = (int) Math.ceil(distance / 0.25); // Number of particles to spawn

        double dx = (location2.getX() - location1.getX()) / particles;
        double dy = (location2.getY() - location1.getY()) / particles;
        double dz = (location2.getZ() - location1.getZ()) / particles;

        for (int i = 0; i < particles; i++) {
            double x = location1.getX() + dx * i;
            double y = location1.getY() + dy * i;
            double z = location1.getZ() + dz * i;

            Location particleLocation = new Location(location1.getWorld(), x, y, z);
            if (particle != null) {
                location1.getWorld().spawnParticle(particle, particleLocation, 1, 0, 0, 0, 0.05);
            }
            // Additional logic for handling the beam visualization
            // ...
        }
    }

    public static Location getLeftSide(Location location, double distance) {
        Vector direction = location.getDirection().normalize().multiply(-1); // Get the opposite direction
        Vector leftSide = new Vector(direction.getZ(), 0, -direction.getX()).normalize().multiply(distance);
        return location.clone().add(leftSide);
    }

    public static Location getRightSide(Location location, double distance) {
        Vector direction = location.getDirection().normalize();
        Vector rightSide = new Vector(direction.getZ(), 0, -direction.getX()).normalize().multiply(distance);
        return location.clone().add(rightSide);
    }

    public static void generateCircle(Location centre, Particle particle, float radius) {
        double x = centre.getX();
        double y = centre.getY();
        double z = centre.getZ();
        double increment = 2 * Math.PI / 100; // Increase the denominator for more particles

        for (double theta = 0; theta <= 2 * Math.PI; theta += increment) {
            double offsetX = radius * Math.cos(theta);
            double offsetZ = radius * Math.sin(theta);

            Location particleLocation = new Location(centre.getWorld(), x + offsetX, y, z + offsetZ);
            centre.getWorld().spawnParticle(particle, particleLocation, 1, 0, 0, 0, 0);
        }
    }

    public static List<Player> getNearbyPlayers(Location centre, double radius) {
        List<Player> nearbyPlayers = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            Location playerLocation = player.getLocation();
            if (playerLocation.getWorld() != centre.getWorld()) {
                continue; // Skip players in different worlds
            }
            if (playerLocation.distance(centre) <= radius) {
                nearbyPlayers.add(player);
            }
        }
        return nearbyPlayers;
    }


    public static ItemStack getPlayerHead(OfflinePlayer player) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwningPlayer(player);
        return head;
    }

    public static void createSemiCircle(Location location, Double size, Particle particle, Vector direction) {
        Vector ortho = new Vector(-direction.getZ(), 0, direction.getX()).normalize();
        for (double i = 0; i <= Math.PI; i += Math.PI / 50) {
            double x = size * Math.cos(i);
            double z = size * Math.sin(i);
            location.add(direction.clone().multiply(x)).add(ortho.clone().multiply(z));
            location.getWorld().spawnParticle(particle, location, 0);
            location.subtract(direction.clone().multiply(x)).subtract(ortho.clone().multiply(z));
        }
    }

    public void createSerenity(Location origin, double radius, Particle particle) {
        new BukkitRunnable() {
            private double currentRadius = 0.0;
            private final double radiusIncrement = 0.1; // Adjust the increment value as desired

            @Override
            public void run() {
                if (currentRadius <= radius) {
                    // Generate circle particles
                    for (double theta = 0; theta < 2 * Math.PI; theta += Math.PI / 30) {
                        double x = origin.getX() + currentRadius * Math.cos(theta);
                        double y = origin.getY();
                        double z = origin.getZ() + currentRadius * Math.sin(theta);
                        origin.getWorld().spawnParticle(particle, x, y, z, 0, 0, 0, 0, 0.05);
                    }

                    currentRadius += radiusIncrement;
                } else {
                    // Circle reached desired radius, cancel the task
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0L, 1L); // Adjust the task timing as desired


    }
}
