package br.com.gamespalace;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.InventoryView;

public class PalaceHomesEvents implements Listener  {

    PalaceHomes plugin;
    public  PalaceHomesEvents (PalaceHomes plugin) {

        this.plugin = plugin;

    }



@EventHandler
    void playerInteractInventoryEvent (InventoryClickEvent e) {
Player p = (Player) e.getWhoClicked();
InventoryView view = e.getView();
    String name;

if (e.getCurrentItem().getType() != Material.AIR) {
   name =ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()) ;
} else {
    return;
}



    if (ChatColor.stripColor(view.getTitle()).equalsIgnoreCase("Homes")) {
        e.setCancelled(true);
        if(!(e.getCurrentItem() != null || e.getCurrentItem().getType() != Material.AIR || e.getCurrentItem().hasItemMeta())){
            p.closeInventory();
            return;
        }

            switch (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())) {

                case "Fechar \"Homes\"":
                    p.closeInventory();
                    break;

                default: p.performCommand("home " + ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

            }

        }

    }

    @EventHandler
    void onPlayerJoin (PlayerJoinEvent e) {
        Player p = e.getPlayer();
        loadHomes(p);

    }

    public int loadHomes(Player p) {

        if (plugin.getConfig().get(p.getName()) == null) {
            plugin.homes = 0;
        } else {

            plugin.homes = (int) plugin.getConfig().get(p.getName());
        }


        return plugin.homes;

    }

}
