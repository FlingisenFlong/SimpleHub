package xyz.glowberry.simplehub;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleHub extends JavaPlugin {

    private static SimpleHub instance;
    private String hubWorld;
    private String confirmmsg;
    private double hubX;
    private double hubY;
    private double hubZ;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        loadConfigValues();
        registerCommands();
        Bukkit.getLogger().info("[SimpleHub] Plugin enabled");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[SimpleHub] Plugin disabled");
    }

    private void loadConfigValues() {
        hubWorld = getConfig().getString("world", "world");
        confirmmsg = getConfig().getString("confirmmsg", "&aTeleported to hub successfully!");
        hubX = getConfig().getDouble("x", 0);
        hubY = getConfig().getDouble("y", 64);
        hubZ = getConfig().getDouble("z", 0);
    }

    private void registerCommands() {
        getCommand("hub").setExecutor(new HubCommand());
    }

    public static SimpleHub getInstance() {
        return instance;
    }

    public String getHubWorld() {
        return hubWorld;
    }

    public String getConfirmmsg() {
        return confirmmsg;
    }

    public double getHubX() {
        return hubX;
    }

    public double getHubY() {
        return hubY;
    }

    public double getHubZ() {
        return hubZ;
    }
}
