package com.codecool.models;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Mode {

    public Server (int port) {
        super(port);
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server waiting for client on port " + port);
            Socket socket = serverSocket.accept();
            System.out.println("client connected!");

            handlersInitializer(socket);

            System.out.println("You can start chat:");


            String receiveMessage = "";
            String sendMessage = "";

            while (!sendMessage.equals("exit")) {
                sendMessage = handleSendMessage(prepareMessage, sendMessage);
                receiveMessage = handleReceiveMessage(incomingMessage, receiveMessage);

            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
