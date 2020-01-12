package br.com.gamespalace.commands;

import br.com.gamespalace.PalaceHomes;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SethomeCommand implements CommandExecutor {

    PalaceHomes plugin;
    public SethomeCommand (PalaceHomes plugin) {

        this.plugin = plugin;

    }
int homes;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

    String name = args[0];
        if (command.getName().equalsIgnoreCase("sethome")) {
            if(!p.hasPermission("palacehomes.sethome")) {
                p.sendMessage(ChatColor.BLUE + "Casas> " + ChatColor.RED +  "Voce nao tem permissao para criar casas!");
                return true;

            } else {

                  setHome(p, name);

                  PalaceHomes.homeName = args[0];

                if (plugin.getConfig().get(p.getName()) != null) {

                      plugin.homes = (int) plugin.getConfig().get(p.getName()) + 1;

                  } else {

                    plugin.homes = 1;
                }

                   // plugin.homes++;

                    plugin.getConfig().set(p.getName() + "_" + plugin.homes , PalaceHomes.homeName);
                    plugin.saveConfig();


                    plugin.getConfig().set(p.getName(), plugin.homes);
                    plugin.saveConfig();

                  p.sendMessage(ChatColor.BLUE + "Casas> " + ChatColor.GREEN + "A casa " + ChatColor.DARK_PURPLE + name + ChatColor.GREEN + " foi criada com sucesso em sua localizaçao atual!");

            }



        }

        return false;
    }

    void setHome (Player p, String name) {

        String homeName = name;

        Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());

        plugin.getConfig().set(p.getName() + " _Homes." + homeName, serializeLoc(loc));
        plugin.saveConfig();

    }

    public String serializeLoc(Location l){
        return l.getWorld().getName()+","+l.getBlockX()+","+l.getBlockY()+","+l.getBlockZ();
    }

}
