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

        // Hämta hub-informationsvariabler
        String hubWorldName = plugin.getHubWorld();
        double hubX = plugin.getHubX();
        double hubY = plugin.getHubY();
        double hubZ = plugin.getHubZ();
        String confirmmsg = plugin.getConfirmmsg();

        // Hämta Multiverse-världen
        World hubWorld = Bukkit.getWorld(hubWorldName);

        if (hubWorld == null) {
            player.sendMessage("The hub world is not loaded or does not exist.");
            return true;
        }

        // Skapa en ny location baserat på konfigurationskoordinaterna
        Location hubLocation = new Location(hubWorld, hubX, hubY, hubZ);

        // Teleportera spelaren till den specificerade hub-lokationen
        player.teleport(hubLocation);
        player.sendMessage(confirmmsg); // Skicka bekräftelsemeddelandet till spelaren

        return true;
    }
}
