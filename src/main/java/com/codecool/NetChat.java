package com.codecool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetChat {
//    public static void main(String[] args) {
//        if (args.length<1) {
//            return;
//        }
//
//        int port = Integer.parseInt(args[0]);
//        try (ServerSocket serverSocket = new ServerSocket(port)) {
//            System.out.println("Waiting for a client on port: " + port);
//            while (true) {
//
//                Socket socket = serverSocket.accept();
//                System.out.println("New clilent connected");
//
//                OutputStream output = socket.getOutputStream();
//                PrintWriter writer = new PrintWriter(output, true);
//
//                writer.println("This is a message");
//
//            }
//
//        } catch (IOException e) {
//            System.out.println("During creating the socket occurred i/o error");
//        }
//    }
}
