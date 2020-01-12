package br.com.gamespalace.utils;

import br.com.gamespalace.PalaceHomes;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI {


    PalaceHomes plugin;

    public GUI (PalaceHomes plugin) {

        this.plugin = plugin;

    }

    public void homesGUI(Player p) {

    Inventory gui = Bukkit.createInventory(p, 54, ChatColor.DARK_BLUE + "Homes");

        int homes = PalaceHomes.homes ;


        ItemStack close = new ItemStack(Material.FEATHER);
        ItemMeta closeMeta = close.getItemMeta();

        ItemStack next = new ItemStack(Material.ARROW);
        ItemMeta nextMeta = next.getItemMeta();

        ItemStack prev = new ItemStack(Material.ARROW);
        ItemMeta prevMeta = prev.getItemMeta();

        nextMeta.setDisplayName(ChatColor.BLUE + "Proxima Pagina");
        next.setItemMeta(nextMeta);

        prevMeta.setDisplayName(ChatColor.BLUE + "Pagina Anterior");
        prev.setItemMeta(prevMeta);

        closeMeta.setDisplayName(ChatColor.RED + "Fechar \"Homes\"");
      close.setItemMeta(closeMeta);

      gui.setItem(49, close);
      gui.setItem(45, prev);
      gui.setItem(53, next);

       for (int i = 0; i < homes; i++) {
           ItemStack item = new ItemStack(Material.OAK_PLANKS);
           ItemMeta meta = item.getItemMeta();

          int position = i + 1;
         /*  int deletedCount;
           if (plugin.getConfig().get(p.getName() + "_deleted") == null) {
               position = i + 1;

           } else {
               deletedCount = (int) plugin.getConfig().get(p.getName() + "_deleted");
               position = i + 1 + deletedCount;
           } */

           String homeName = "";


           try {

        homeName = (String) plugin.getConfig().get(p.getName() + "_" + position);

           } catch (NullPointerException e) {

               meta.setDisplayName(ChatColor.GREEN + homeName);
           }


           meta.setDisplayName(ChatColor.GREEN + homeName);
         // meta.setDisplayName(ChatColor.GREEN + String.valueOf(i));

           item.setItemMeta(meta);
            gui.setItem(i, item);

       }

       p.openInventory(gui);


    }


}
