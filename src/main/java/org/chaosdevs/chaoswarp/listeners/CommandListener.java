package org.chaosdevs.chaoswarp.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.chaosdevs.chaoswarp.ChaosWarp;

public class CommandListener implements Listener {

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        boolean command = false;

        for (String string : ChaosWarp.getInstance().getCommands()) {
            if (event.getMessage().equalsIgnoreCase("/" + string)) {
                command = true;
            }
        }
        if (!command) {
            return;
        }
        event.setCancelled(true);
    }
}
