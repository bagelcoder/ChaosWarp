package org.chaosdevs.chaoswarp.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.chaosdevs.chaoswarp.ChaosWarp;

import java.util.ArrayList;

public class InventoryListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getInventory();

        if (inventory == null) {
            return;
        }
        String name = inventory.getName();
        name = ChatColor.stripColor(name);
        if (!name.equalsIgnoreCase(ChatColor.stripColor(ChaosWarp.getInstance().getConfig().getString("GUI_NAME")))) {
            return;
        }
        event.setCancelled(true);

        String rank = ChaosWarp.getInstance().getConfig().getString("slots." + event.getRawSlot() + ".rank");
        if (player.hasPermission("essentials.warps." + rank)) {
            player.performCommand("warp " + rank);
        } else {
            ArrayList<String> nopermission = (ArrayList<String>) ChaosWarp.getInstance().getConfig().get("gui.rank_invalid");
            for (String string : nopermission) {
                string = ChatColor.translateAlternateColorCodes('&',  string);
                player.sendMessage(string);
            }
        }
        player.closeInventory();
    }
}
