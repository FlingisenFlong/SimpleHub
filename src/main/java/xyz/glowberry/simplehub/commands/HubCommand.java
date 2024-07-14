package xyz.glowberry.simplehub.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import xyz.glowberry.simplehub.SimpleHub;

public class HubCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;


        SimpleHub plugin = SimpleHub.getInstance();

        // Retrieve hub information variables
        String hubWorldName = plugin.getHubWorld();
        double hubX = plugin.getHubX();
        double hubY = plugin.getHubY();
        double hubZ = plugin.getHubZ();
        String confirmmsg = plugin.getConfirmmsg();

        // Get the Multiverse world
        World hubWorld = Bukkit.getWorld(hubWorldName);

        if (hubWorld == null) {
            player.sendMessage("The hub world is not loaded or does not exist.");
            return true;
        }

        // Create a new location based on the config coordinates
        Location hubLocation = new Location(hubWorld, hubX, hubY, hubZ);

        // Teleport the player to the specified hub location
        player.teleport(hubLocation);
        player.sendMessage(confirmmsg); // Send confirmation message to the player

        return true;
    }
}
