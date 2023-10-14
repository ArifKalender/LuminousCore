package me.kugelblitz.luminouscore.luminousrealms.custom.custommobs.arcanehaven.passive;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.luminousrealms.util.Sounds;
import me.kugelblitz.luminouscore.luminousrealms.util.UtilizationMethods;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.Random;

//küçük dünyacıklar, görünmez pasif vurunca kaçan moblardan olcak | tavuğun falan üzerine armorstand bindirip kafasına dünyacık geçirebilirim
//bi kullanımı olan essence düşürebilir.
public class AncientEarthling {


    public AncientEarthling(Location location) {
        Villager earthling = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER, false);
        ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND, false);
        armorStand.setCustomName("§2Ancient Earthling");
        earthling.setCustomName("§2Ancient Earthling");
        armorStand.setCustomNameVisible(true);
        earthling.setSilent(true);
        earthling.setAdult();
        earthling.setInvisible(true);
        armorStand.setInvisible(true);
        armorStand.getEquipment().setItem(EquipmentSlot.HEAD, new ItemStack(Material.GREEN_TERRACOTTA, 1));
        earthling.addPassenger(armorStand);


        new BukkitRunnable() {
            @Override
            public void run() {
                if (earthling.isDead()) {
                    armorStand.remove();
                    Random random = new Random();
                    double i = random.nextDouble();
                    if (i < 0.1) {
                        dropEarthEssence(location);
                    }


                    this.cancel();

                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 10);
    }

    public static void dropEarthEssence(Location location) {
        ItemStack earthEssence = new ItemStack(Material.GREEN_TERRACOTTA, 1);
        ItemMeta essenceMeta = earthEssence.getItemMeta();
        essenceMeta.setDisplayName("§2Earth Essence");
        essenceMeta.setLore(Arrays.asList("", "Ancient Earthlings can sometimes drop", "the very material used to create", "earth. This essence can be", "used for various reasons.", "", "§e§lRARE"));
        earthEssence.setItemMeta(essenceMeta);
        for (Player player : UtilizationMethods.getNearbyPlayers(location, 4)) {
            Sounds.rareDrop(player);
        }
        location.getWorld().dropItem(location, earthEssence);
    }
}
