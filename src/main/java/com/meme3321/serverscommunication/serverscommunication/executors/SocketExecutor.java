package com.meme3321.serverscommunication.serverscommunication.executors;

import com.meme3321.serverscommunication.serverscommunication.listeners.PlayerTryToJoinArenaViaSocket;
import com.meme3321.serverscommunication.serverscommunication.models.SocketPlayer;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketExecutor {

    static ServerSocket listener;
    static Socket socket;
    static BufferedReader in;

    public static void startSocketListening() {
        while (true) {
            try {
                listener = new ServerSocket(5001);
                while (true) {
                    socket = listener.accept();
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    JSONParser parser = new JSONParser();
                    JSONObject jsonObject = (JSONObject) parser.parse(in.readLine());
                    SocketPlayer socketPlayer = new SocketPlayer();
                    socketPlayer.setUUID(jsonObject);
                    socketPlayer.setName(jsonObject);
                    startProcessWithPlayer(socketPlayer);
                }

            } catch (Throwable th) {
                try {
                    listener.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private static void startProcessWithPlayer(SocketPlayer player) {
        PlayerTryToJoinArenaViaSocket playerTryToJoinArenaViaSocket = new PlayerTryToJoinArenaViaSocket();
        playerTryToJoinArenaViaSocket.startProcessOfMovingPlayerToThisServer(player);
    }
}
