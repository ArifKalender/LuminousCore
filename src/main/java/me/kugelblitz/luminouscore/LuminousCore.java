package me.kugelblitz.luminouscore;

import me.kugelblitz.luminouscore.PowerSurge.ArenaKill;
import me.kugelblitz.luminouscore.luminousrealms.cosmetic.Footprint;
import me.kugelblitz.luminouscore.luminousrealms.custom.customitems.ItemFix;
import me.kugelblitz.luminouscore.luminousrealms.custom.customitems.items.ItemListener;
import me.kugelblitz.luminouscore.luminousrealms.custom.customitems.items.LuckyCharm;
import me.kugelblitz.luminouscore.luminousrealms.custom.custommobs.MobListener;
import me.kugelblitz.luminouscore.luminousrealms.mechanics.currency.MaterialManager;
import me.kugelblitz.luminouscore.luminousrealms.mechanics.mayorsystem.CurrentMayor;
import me.kugelblitz.luminouscore.luminousrealms.mechanics.mayorsystem.MayorHandler;
import me.kugelblitz.luminouscore.luminousrealms.mechanics.mayorsystem.mayors.*;
import me.kugelblitz.luminouscore.luminousrealms.mechanics.religionmanager.BeforeReligion;
import me.kugelblitz.luminouscore.luminousrealms.mechanics.religionmanager.ReligionListener;
import me.kugelblitz.luminouscore.luminousrealms.statmanagement.CustomDamageManager;
import me.kugelblitz.luminouscore.luminousrealms.statmanagement.Regeneration;
import me.kugelblitz.luminouscore.luminousrealms.ui.ClickEvent;
import me.kugelblitz.luminouscore.luminousrealms.ui.FootprintMenu;
import me.kugelblitz.luminouscore.luminousrealms.ui.crystallexicon.CrystalListener;
import me.kugelblitz.luminouscore.luminousrealms.util.NullFixer;
import me.kugelblitz.luminouscore.luminousrealms.util.PlayerStats;
import me.kugelblitz.luminouscore.luminousrealms.util.commands.*;
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
        getServer().getPluginManager().registerEvents(new SeanMayorM(), this);
        getServer().getPluginManager().registerEvents(new FionaMayorF(), this);
        getServer().getPluginManager().registerEvents(new MoragMayorF(), this);

        getServer().getPluginManager().registerEvents(new ItemFix(), this);
        getServer().getPluginManager().registerEvents(new ReligionListener(), this);
        getServer().getPluginManager().registerEvents(new MobListener(), this);
        getServer().getPluginManager().registerEvents(new ItemListener(), this);
        getServer().getPluginManager().registerEvents(new BeforeReligion(), this);
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        getServer().getPluginManager().registerEvents(new CustomDamageManager(), this);

        getServer().getPluginManager().registerEvents(new ItemFix(), this);
        getServer().getPluginManager().registerEvents(new NullFixer(), this);
        getServer().getPluginManager().registerEvents(new CrystalListener(), this);

        getServer().getPluginManager().registerEvents(new MaterialManager(), this);


        new Regeneration().regenerate();
        new Regeneration().indicate();


        //POWER SURGE
        getServer().getPluginManager().registerEvents(new ArenaKill(), this);
    }

    public void registerCommands() {
        this.getCommand("mayorhandler").setExecutor(new MayorHandler(this));
        this.getCommand("currentmayor").setExecutor(new CurrentMayor());
        this.getCommand("spawncustommob").setExecutor(new SpawnCustomMob());
        this.getCommand("triggerevent").setExecutor(new TriggerEvent());
        this.getCommand("adminitem").setExecutor(new AdminItem());
        this.getCommand("reloadlumina").setExecutor(new ReloadLumina());
        this.getCommand("resetplayer").setExecutor(new ResetPlayer());
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
