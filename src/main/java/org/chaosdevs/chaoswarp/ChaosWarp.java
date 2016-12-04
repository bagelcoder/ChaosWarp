package org.chaosdevs.chaoswarp;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class ChaosWarp extends JavaPlugin {

    private static ChaosWarp instance;
    private List<String> commands = new ArrayList<String>();

    @Override
    public void onEnable() {
        instance = this;
        commands = this.getConfig().getStringList("commands");

    }

    public static ChaosWarp getInstance() {
        return instance;
    }

    public List<String> getCommands() {
        return commands;
    }
}
