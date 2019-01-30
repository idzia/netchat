package com.codecool.trash;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server2 {

    public static void main(String[] args) {
        if (args.length < 1) return;

        int port = Integer.parseInt(args[0]);

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
//                writer.println("I am happy that you joined to us");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                Scanner scanner = new Scanner(System.in);
                String toClient;
                String fromClient;

                do {
                    toClient = scanner.nextLine();
                    writer.println("Server: " + toClient);

                    fromClient = reader.readLine();
                    System.out.println("Client: " + fromClient);

                } while (!toClient.equals("exit"));

                socket.close();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
