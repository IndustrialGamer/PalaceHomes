package br.com.gamespalace.commands;

import br.com.gamespalace.PalaceHomes;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeleteHomeCommand implements CommandExecutor {

    PalaceHomes plugin;
    public DeleteHomeCommand (PalaceHomes plugin) {

        this.plugin = plugin;
    }
boolean exc = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command,  String label, String[] args) {

        Player p = (Player) sender;

        if (command.getName().equalsIgnoreCase("delhome")) {

            if (args.length == 0) {
                p.sendMessage(ChatColor.BLUE + "Casas> " + ChatColor.RED + "Especifique qual casa voce deseja remvoer de sua lista pessoal!");
            } else {


                try {

                    String name = args[0];
                    String l = (String) (plugin.getConfig().get(p.getName() + "Homes." + name));
               //     p.setCompassTarget(l);

                    plugin.getConfig().set(p.getName() + " _Homes." + name, null);
                    plugin.saveConfig();

                    plugin.homes = (int) plugin.getConfig().get(p.getName()) - 1;
                    if (plugin.homes <= 0) {
                        plugin.homes = 0;
                    }

                    plugin.getConfig().set(p.getName(), plugin.homes);
                    plugin.saveConfig();
                    p.sendMessage(ChatColor.BLUE + "Casas> " + ChatColor.GREEN + "A casa " + ChatColor.DARK_PURPLE + name + ChatColor.GREEN + " foi deletada com sucesso!");

                    plugin.getConfig().set(p.getName() + "_" + plugin.homes, null);
                    plugin.saveConfig();

                } catch (Exception e) {

                    p.sendMessage(ChatColor.DARK_RED + "Casas> " + ChatColor.RED + "A casa " + ChatColor.DARK_PURPLE + args[0] + ChatColor.RED + " nao existe ou ja foi deletada!");
                    return true;

                    }

             }
        }

        return false;
    }

    public Location deserializeLoc(String s){
        String[] st = s.split(",");
        return new Location(Bukkit.getWorld(st[0]), Integer.parseInt(st[1]), Integer.parseInt(st[2]), Integer.parseInt(st[3]));
    }
}
