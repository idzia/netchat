package com.codecool.models;

import com.codecool.controlleres.InputHandler;
import com.codecool.controlleres.OutputHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public abstract class Mode implements Runnable{

    protected int port;
    protected String hostname;
    protected InputHandler input;
    protected OutputHandler output;
    protected BufferedReader incomingMessage;
    protected BufferedReader prepareMessage;

    public Mode(String hostname, int port) {
        this.port = port;
        this.hostname = hostname;
    }

    public Mode(int port) {
        this.port = port;
    }

    public void run() {
        try (Socket socket = new Socket(hostname, port)) {

            handlersInitializer(socket);

            System.out.println("You can start chat ");

            String receiveMessage = "";
            String sendMessage = "";

            while (!sendMessage.equals("exit")) {
                sendMessage = handleSendMessage(prepareMessage, sendMessage);
                receiveMessage = handleReceiveMessage(incomingMessage, receiveMessage);
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    protected void handlersInitializer(Socket socket) throws IOException {
        input = new InputHandler(socket);
        output = new OutputHandler(socket);
        input.start();
        output.start();
        incomingMessage = input.getIncomingMessage();
        prepareMessage = output.getPrepareMessage();
    }

    protected String handleSendMessage(BufferedReader prepareMessage, String sendMessage) throws IOException {
        if (prepareMessage != null) {
            sendMessage = prepareMessage.readLine();
            System.out.println(sendMessage);
        }
        return sendMessage;
    }

    protected String handleReceiveMessage(BufferedReader incomingMessage, String receiveMessage) throws IOException {
        if (incomingMessage!=null){
            receiveMessage = incomingMessage.readLine();
            System.out.println(receiveMessage);
        }
        return receiveMessage;
    }


}
