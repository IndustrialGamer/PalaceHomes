package br.com.gamespalace.commands;

import br.com.gamespalace.PalaceHomes;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class DeleteAllHomesCommand implements CommandExecutor {

PalaceHomes plugin;
public DeleteAllHomesCommand(PalaceHomes plugin) {

    this.plugin = plugin;

}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (command.getName().equals("DELETEALLHOMES")) {
            if(!p.isOp()){
                p.sendMessage(ChatColor.DARK_RED + "Casas> " + ChatColor.RED + "Esse comando so pode ser usado por operadores do servidor!");
                return true;
            } else {
                Map<String, Object> configValues = plugin.getConfig().getValues(false);
                for (Map.Entry<String, Object> entry : configValues.entrySet()) {
                    plugin.getConfig().set(entry.getKey(), null);
                }
            }

        }

        return false;
    }
}
