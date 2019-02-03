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

            while (true) {
                handleReceiveMessage(input);
                handleSendMessage(output);
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        } catch (InterruptedException e ){
            System.out.println("bleee");
        }
    }
}
