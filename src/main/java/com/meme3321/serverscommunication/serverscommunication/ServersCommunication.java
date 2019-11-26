package com.meme3321.serverscommunication.serverscommunication;

import com.meme3321.serverscommunication.serverscommunication.executors.SocketExecutor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServersCommunication extends JavaPlugin {

    public static ServersCommunication plugin;

    @Override
    public void onEnable() {
        plugin = this;
        startSocketListener();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void startSocketListener() {
        Bukkit.getScheduler().runTaskAsynchronously(this,
            () -> {
                SocketExecutor.startSocketListening();
            });
    }
}
