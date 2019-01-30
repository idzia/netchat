package com.codecool.trash;

import java.io.*;
import java.net.Socket;

public class GossipClient {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) return;
        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        Socket sock = new Socket(hostname, port);


        DataInputStream istream = new DataInputStream(sock.getInputStream());

        DataOutputStream ostream = new DataOutputStream(sock.getOutputStream());
//        PrintWriter pwrite = new PrintWriter(ostream, true);


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader writer = new BufferedReader(new InputStreamReader(istream));

        System.out.println("Start the chitchat, type and press Enter key");

        String receiveMessage = "";
        String sendMessage;

        while(!receiveMessage.equals("exit")) {

            sendMessage = reader.readLine();
            ostream.writeUTF(sendMessage);
//            pwrite.println(sendMessage);
//            pwrite.flush();
            System.out.println("me: " + sendMessage);

            if((receiveMessage = istream.readUTF()) != null)
            {
                System.out.println(receiveMessage);
            }
        }
    }
}
