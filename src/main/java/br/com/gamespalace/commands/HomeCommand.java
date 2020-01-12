package br.com.gamespalace.commands;

import br.com.gamespalace.GUI;
import br.com.gamespalace.PalaceHomes;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    PalaceHomes plugin;
    GUI gui;
    public HomeCommand (PalaceHomes plugin) {

        this.plugin = plugin;
        this.gui = new GUI(plugin);

    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        String name;

        if (command.getName().equalsIgnoreCase("home")) {
            if (!p.hasPermission("palacehomes.homes")) {
                p.sendMessage(ChatColor.BLUE + "Casas> " + ChatColor.RED + "Voce nao tem permissao para utilizar o comando /home!");

                return true;

            } else {

                if (args.length == 0) {

                    gui.homesGUI(p);
                    return true;
                }
                name = args[0];
                try {

                    String loc = plugin.getConfig().get(p.getName() + " _Homes." + name).toString();

                        p.teleport(deserializeLoc(loc));
                        p.sendMessage(ChatColor.BLUE + "Casas> " + ChatColor.GREEN + "Voce foi teleportado para a casa " + ChatColor.DARK_PURPLE + name + ChatColor.GREEN + " com sucesso!");



                } catch (NullPointerException e) {
                    p.sendMessage(ChatColor.DARK_RED + "Casas> " + ChatColor.RED + "A casa " + name + " nao esta na sua lista. Considere adiciona-la atraves do comando /sethome");
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
