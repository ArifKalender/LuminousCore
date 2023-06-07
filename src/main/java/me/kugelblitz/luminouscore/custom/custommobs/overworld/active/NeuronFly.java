package me.kugelblitz.luminouscore.custom.custommobs.overworld.active;

//Will attack the player as groups. Baby zombie with a fly head maybe?

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class NeuronFly {
    //maybe particle dedicated to each fly?
    ItemStack helmet;

    public NeuronFly(Location location) {

        Zombie fly = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE, false);

        fly.setCustomName("§eNeuron Fly");
        fly.setCustomNameVisible(true);
        fly.setBaby(true);
        fly.setHealth(1);
        fly.setSilent(true);
        Random random = new Random();
        double randomNumber = random.nextDouble();
        if (randomNumber < 0.125) {
            helmet = new ItemStack(Material.STONE_BUTTON, 1);
        } else if (randomNumber < 0.250) {
            helmet = new ItemStack(Material.POLISHED_BLACKSTONE_BUTTON, 1);
        } else if (randomNumber < 0.375) {
            helmet = new ItemStack(Material.BIRCH_BUTTON, 1);
        } else if (randomNumber < 0.500) {
            helmet = new ItemStack(Material.ACACIA_BUTTON, 1);
        } else if (randomNumber < 0.650) {
            helmet = new ItemStack(Material.MANGROVE_BUTTON, 1);
        } else if (randomNumber < 0.800) {
            helmet = new ItemStack(Material.CRIMSON_BUTTON, 1);
        } else if (randomNumber < 1) {
            helmet = new ItemStack(Material.WARPED_BUTTON, 1);
        }

        fly.setInvisible(true);
        fly.getEquipment().setHelmet(helmet);


        new BukkitRunnable() {
            @Override
            public void run() {
                fly.getLocation().getWorld().playSound(fly.getLocation(), Sound.ENTITY_BEE_LOOP_AGGRESSIVE, 0.1f, 0);
                if (fly.isDead()) {
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 20);
    }
}