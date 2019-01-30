package com.codecool.trash;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) {
        if (args.length < 2) return;

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        try (Socket socket = new Socket(hostname, port)) {

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            Scanner scanner = new Scanner(System.in);
            String fromServer;
            String toServer;

            do {
                fromServer = reader.readLine();
                System.out.println(fromServer);

                toServer = scanner.nextLine();
                writer.println("Client: " + toServer);

            } while (!fromServer.equals("bye"));



        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}