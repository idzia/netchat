package com.codecool.controlleres;

import com.codecool.models.Client;
import com.codecool.models.Mode;
import com.codecool.models.Server;

public class ThreadHandler {


    public ThreadHandler(String[] args) {
        netChatHandle(args);
    }

    public void netChatHandle(String[] args) {
        String mode = args[0];

        switch (mode.toLowerCase()) {
            case "client" :
                if (args.length<3) {
                    System.out.println("not enough arguments");
                    return;
                }
                clientSocketInitializer(args);
                break;

            case "server" :
                if (args.length<2) {
                    System.out.println("not enough arguments");
                    return;
                }
                serverSocketInitializer(args);

                break;
            default:
                System.out.println("There is no this kind of mode");
        }
    }

    private void serverSocketInitializer(String[] args) {
        int port = Integer.parseInt(args[1]);
        Mode server = new Server(port);
        Thread serverThread = new Thread(server, "server");
        serverThread.start();
    }

    private void clientSocketInitializer(String[] args) {
        String hostname = args[1].toLowerCase();
        int port = Integer.parseInt(args[2]);
        Mode client = new Client(hostname, port);
        Thread clientThread = new Thread(client, "client");
        clientThread.start();
    }
}
