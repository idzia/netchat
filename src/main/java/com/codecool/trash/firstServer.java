package com.codecool.trash;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class firstServer {
//    public static void main(String[] args) {
//        if (args.length < 1) return;
//        int port = Integer.parseInt(args[0]);
//
//        try (ServerSocket serverSocket = new ServerSocket(port)) {
//
//            System.out.println("Server waiting for client on port " + port);
//            Socket socket = serverSocket.accept();
//            System.out.println("first client connected!");
//
//            OutputStream output = socket.getOutputStream();
//            PrintWriter writer = new PrintWriter(output, true);
//
//            InputStream input = socket.getInputStream();
//
//            BufferedReader prepareMessage = new BufferedReader(new InputStreamReader(System.in));
//            BufferedReader incomingMessage = new BufferedReader(new InputStreamReader(input));
//
//            String receiveMessage;
//            String sendMessage = "";
//
//            while (!sendMessage.equals("exit")) {
//
//                receiveMessage = incomingMessage.readLine();
//                System.out.println(receiveMessage );
//
//                sendMessage = prepareMessage.readLine();
//                writer.println("server: " + sendMessage);
//                System.out.println("me: " + sendMessage);
//                output.flush();
//            }
//
//        } catch (IOException ex) {
//            System.out.println("Server exception: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//    }
}
