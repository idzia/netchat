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
        String hostname;
        int port;

        switch (mode.toLowerCase()) {
            case "client" :
                if (args.length<3) {
                    System.out.println("not enough arguments");
                    return;
                }
                hostname = args[1];
                port = Integer.parseInt(args[2]);
                Mode client = new Client(hostname, port);
                Thread clientThread = new Thread(client, "client");
                clientThread.start();
                break;

            case "server" :
                if (args.length<2) {
                    System.out.println("not enough arguments");
                    return;
                }
                port = Integer.parseInt(args[1]);
                Mode server = new Server(port);
                Thread serverThread = new Thread(server, "server");
                serverThread.start();

                break;
            default:
                System.out.println("There is no this kind of mode");
        }
    }
}
