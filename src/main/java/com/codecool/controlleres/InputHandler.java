package com.codecool.controlleres;

import java.io.*;
import java.net.Socket;

public class InputHandler extends Thread {

    private Socket socket;
    private InputStream input;
    private BufferedReader incomingMessage;

    public InputHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.input = socket.getInputStream();
    }

    public void run() {
        try {

            String receiveMessage;

            while (true) {
                incomingMessage = new BufferedReader(new InputStreamReader(input));

                if ((receiveMessage = incomingMessage.readLine()) != null) {
                    System.out.println(receiveMessage);
                }
            }
        } catch (IOException e) {
            System.out.println("exception InputHandler");
        }
    }

    public BufferedReader getIncomingMessage() {
        return this.incomingMessage;
    }

}
