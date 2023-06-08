package me.kugelblitz.luminouscore;

import me.kugelblitz.luminouscore.cosmetic.Footprint;
import me.kugelblitz.luminouscore.custom.customitems.ItemFix;
import me.kugelblitz.luminouscore.custom.customitems.items.ItemListener;
import me.kugelblitz.luminouscore.custom.customitems.items.LuckyCharm;
import me.kugelblitz.luminouscore.custom.custommobs.MobListener;
import me.kugelblitz.luminouscore.mechanics.abilities.AbilityListener;
import me.kugelblitz.luminouscore.mechanics.mayorsystem.CurrentMayor;
import me.kugelblitz.luminouscore.mechanics.mayorsystem.MayorHandler;
import me.kugelblitz.luminouscore.mechanics.mayorsystem.mayors.DaithiMayorM;
import me.kugelblitz.luminouscore.mechanics.mayorsystem.mayors.FionaMayorF;
import me.kugelblitz.luminouscore.mechanics.mayorsystem.mayors.MoragMayorF;
import me.kugelblitz.luminouscore.mechanics.mayorsystem.mayors.MuirgenMayorF;
import me.kugelblitz.luminouscore.mechanics.religionmanager.ReligionListener;
import me.kugelblitz.luminouscore.statmanagement.CustomDamageManager;
import me.kugelblitz.luminouscore.statmanagement.Regeneration;
import me.kugelblitz.luminouscore.ui.ClickEvent;
import me.kugelblitz.luminouscore.ui.FootprintMenu;
import me.kugelblitz.luminouscore.ui.LuminousManager.LuminousManager;
import me.kugelblitz.luminouscore.util.NullFixer;
import me.kugelblitz.luminouscore.util.PlayerStats;
import me.kugelblitz.luminouscore.util.commands.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class LuminousCore extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        if (getConfig().get("license") == null) {
            getConfig().set("license", "null");
        }
        getServer().getConsoleSender().sendMessage("§aThe license key is correct! Enabling LuminousCore...");
        plugin = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        MayorHandler.mayor = getConfig().getString("mayor");
        new LuminousManager();
        addFields();
        checkLicense();
    }


    public void checkLicense() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (LuminousCore.plugin.getConfig().get("license").equals("1aba9fdc-8ab1-461b-b2fa-831f43e85b31")) {
                    getServer().getConsoleSender().sendMessage("§aCorrect license key!");
                } else {
                    getServer().shutdown();
                }
            }
        }.runTaskTimer(plugin, 20 * 40, 20 * 60 * 20);
    }

    public void addFields() {

        PlayerStats.setFields();
        PlayerStats.getStats().options().copyDefaults(true);
        PlayerStats.saveStats();
        plugin.getConfig().options().copyDefaults(true);


        registerCommands();
        regularListeners();
        addStats();
        new DaithiMayorM().daithiEvent();
        new FionaMayorF().fionaSpeed();
        new LuckyCharm().LuckyCharmRecipe();
    }

    public void addStats() {
        getServer().getPluginManager().registerEvents(new Footprint(), this);
    }

    public void regularListeners() {
        getServer().getPluginManager().registerEvents(new DaithiMayorM(), this);
        getServer().getPluginManager().registerEvents(new MuirgenMayorF(), this);
        getServer().getPluginManager().registerEvents(new FionaMayorF(), this);
        getServer().getPluginManager().registerEvents(new MoragMayorF(), this);

        getServer().getPluginManager().registerEvents(new ItemFix(), this);
        getServer().getPluginManager().registerEvents(new AbilityListener(), this);
        getServer().getPluginManager().registerEvents(new ReligionListener(), this);
        getServer().getPluginManager().registerEvents(new MobListener(), this);
        getServer().getPluginManager().registerEvents(new ItemListener(), this);
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        getServer().getPluginManager().registerEvents(new CustomDamageManager(), this);

        getServer().getPluginManager().registerEvents(new ItemFix(), this);
        getServer().getPluginManager().registerEvents(new LuminousManager(), this);
        getServer().getPluginManager().registerEvents(new NullFixer(), this);

        new Regeneration().regenerate();
        new Regeneration().indicate();
    }

    public void registerCommands() {
        this.getCommand("mayorhandler").setExecutor(new MayorHandler(this));
        this.getCommand("currentmayor").setExecutor(new CurrentMayor());
        this.getCommand("spawncustommob").setExecutor(new SpawnCustomMob());
        this.getCommand("triggerevent").setExecutor(new TriggerEvent());
        this.getCommand("adminitem").setExecutor(new AdminItem());
        this.getCommand("reloadlumina").setExecutor(new ReloadLumina());
        this.getCommand("footprints").setExecutor(new FootprintMenu());
        this.getCommand("seteventlocation").setExecutor(new SetEventLocation());
        this.getCommand("createitem").setExecutor(new CreateItem());
        this.getCommand("terminatemobs").setExecutor(new TerminateMobs());
        this.getCommand("openlexicon").setExecutor(new OpenLexicon());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
