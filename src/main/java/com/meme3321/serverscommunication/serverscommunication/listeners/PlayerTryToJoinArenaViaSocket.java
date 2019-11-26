package com.meme3321.serverscommunication.serverscommunication.listeners;

import com.meme3321.serverscommunication.serverscommunication.ServersCommunication;
import com.meme3321.serverscommunication.serverscommunication.models.SocketPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.UUID;

public class PlayerTryToJoinArenaViaSocket {
    private ServersCommunication plugin;
    private BukkitTask bukkitTask;
    private int taskCounter = 0;

    public PlayerTryToJoinArenaViaSocket() {
        plugin = ServersCommunication.plugin;
    }

    public void startProcessOfMovingPlayerToThisServer(SocketPlayer socketPlayer) {
        bukkitTask = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> {
            //TODO: Finaly version (uncomment when all will be ready)
//            Player player = Bukkit.getPlayer(socketPlayer.getUUID());

            UUID uuid = UUID.fromString("3efd5446-4b0a-3483-a76f-7a4a989767db");
            Player player = Bukkit.getPlayer(uuid);

            if (player != null && player.isOnline()) {
                //TODO: Join player to arena method
                Bukkit.broadcastMessage("§cJest online!!");
                stopTask();
                return;
            } else {
                taskCounter = taskCounter + 1;
                Bukkit.broadcastMessage("Sprawdzam...");
            }
            if(taskCounter == 15) {
                Bukkit.broadcastMessage("Próbuję przenieść gracza jeszcze raz");
                //TODO: Send message to player (Bungeecord message channel)
            }
        }, 0L, 20L);
    }

    private void stopTask() {
        bukkitTask.cancel();
    }
}
