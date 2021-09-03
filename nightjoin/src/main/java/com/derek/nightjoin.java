package com.derek;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import java.util.logging.Logger;

public class nightjoin extends JavaPlugin implements Listener{

    public static final Logger _log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        nightjoin._log.info("Plugin is enabled!");
    }

    @Override
    public void onDisable() {
        nightjoin._log.info("Plugin is disabled!");
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    if (!e.getPlayer().hasPermission("nightjoin.join")) {
                        p.kickPlayer(ChatColor.RED + "У вас нет прав для игры на сервере!");
                    }
                }
            }
        }, 10);
    }
}
