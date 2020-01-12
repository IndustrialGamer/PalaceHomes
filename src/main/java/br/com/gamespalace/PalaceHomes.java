package br.com.gamespalace;

import br.com.gamespalace.commands.DeleteAllHomesCommand;
import br.com.gamespalace.commands.DeleteHomeCommand;
import br.com.gamespalace.commands.HomeCommand;
import br.com.gamespalace.commands.SethomeCommand;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class PalaceHomes extends JavaPlugin {

    public static int homes = 0;
    public static String homeName = "";
    public static int ID;

    @Override
    public void onEnable() {

        this.getCommand("home").setExecutor(new HomeCommand(this));
        this.getCommand("sethome").setExecutor(new SethomeCommand(this));
        this.getCommand("delhome").setExecutor(new DeleteHomeCommand(this));
        this.getCommand("DELETEALLHOMES").setExecutor(new DeleteAllHomesCommand(this));
        registerConfig();

        getServer().getPluginManager().registerEvents(new PalaceHomesEvents(this), this);

    }



    @Override
    public void onDisable() {
        HandlerList.unregisterAll();

    }

    void registerConfig () {

        this.getConfig().options().copyDefaults(true);
        saveConfig();

    }



}
