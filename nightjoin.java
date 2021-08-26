package com.derek;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class nightjoin extends JavaPlugin implements Listener{

    public static final Logger _log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        nightjoin._log.info("Плагин включён!");
    }

    @Override
    public void onDisable() {
        nightjoin._log.info("Плагин отключён!");
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        if(!e.getPlayer().hasPermission("nightjoin.join")){
            e.setResult(PlayerLoginEvent.Result.KICK_OTHER);
            e.setKickMessage(ChatColor.RED + "У вас нет прав для игры на сервере!");
        }
    }
}