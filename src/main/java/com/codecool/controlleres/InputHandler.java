package com.codecool.controlleres;

import com.codecool.models.Message;

import java.io.*;
import java.net.Socket;

public class InputHandler extends Thread {

    private Socket socket;
    private InputStream input;
    private ObjectInputStream incomingMessage;
    private Message message;
    private boolean isDone;

    public InputHandler(String name, Socket socket) throws IOException {
        super(name);
        this.socket = socket;
        this.input = socket.getInputStream();
    }

    public void run() {
        try {

            incomingMessage = new ObjectInputStream(input);

            while (true) {
                if (incomingMessage != null) {

                    message = (Message) incomingMessage.readObject();

                }

            }

        } catch (IOException e) {
            System.out.println("exception InputHandler");
        } catch (ClassNotFoundException e) {
            System.out.println("I can not found appropriate class");
        }
    }

    public Message getIncomingMessage() {
        return message;
    }

    public void resetMessage() {
        this.message = null;
    }

    public boolean isDone() {
        return isDone;
    }
}
