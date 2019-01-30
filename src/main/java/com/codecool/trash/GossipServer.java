package com.codecool.trash;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class GossipServer {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) return;
        int port = Integer.parseInt(args[0]);

        ServerSocket sersock = new ServerSocket(port);
        System.out.println("Server  ready for chatting");
        Socket sock = sersock.accept( );


        DataInputStream istream = new DataInputStream(sock.getInputStream());
        DataOutputStream ostream = new DataOutputStream(sock.getOutputStream());
//        PrintWriter pwrite = new PrintWriter(ostream, true);



        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

        String receiveMessage;
        String sendMessage;
        while(true)
        {
            if((receiveMessage = istream.readUTF()) != null)
            {
                System.out.println(receiveMessage);
            }
            sendMessage = keyRead.readLine();
            ostream.writeUTF(sendMessage);
            System.out.println("me: " + sendMessage);
//            pwrite.println(sendMessage);
//            pwrite.flush();
        }
    }
}
