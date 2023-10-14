package me.kugelblitz.luminouscore.luminousrealms.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerStats {

    private static File file;
    private static FileConfiguration PlayerStats;

    public static void setFields() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("LuminousCore").getDataFolder(), "PlayerStats.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException i) {
            }
        }
        PlayerStats = YamlConfiguration.loadConfiguration(file);

    }

    public static FileConfiguration getStats() {
        return PlayerStats;
    }

    public static void saveStats() {
        try {
            PlayerStats.options().copyDefaults(true);
            PlayerStats.save(file);
        } catch (IOException i) {
            System.out.println("Couldnt save PlayerStats.yml.");
        }
    }

    public static void reloadStats() {
        PlayerStats = YamlConfiguration.loadConfiguration(file);
    }

}
