package me.depc;

import me.depc.webserver.WebServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotMain extends JavaPlugin {
    @Override
    public void onEnable() {

        // Initializing web service for use in backend. //
        int port = 8497;
        try {
            WebServer ws = new WebServer(port);
        } catch (Exception e) {
            for (StackTraceElement el : e.getStackTrace()) {
                getLogger().severe(el.toString());
            }
            getLogger().info(ChatColor.RED + "Failure when initializing Network+, disabling plugin.");
            Bukkit.getPluginManager().disablePlugin(this);
        } finally {
            getLogger().info(ChatColor.GOLD + "Initialized network+ webservice with port " + port);
        }
    }
}
