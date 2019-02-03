package com.codecool.models;

import com.codecool.controlleres.InputHandler;
import com.codecool.controlleres.OutputHandler;


import java.io.IOException;
import java.net.Socket;

public abstract class Mode implements Runnable{

    protected int port;
    protected String hostname;
    protected InputHandler input;
    protected OutputHandler output;

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

            while (true) {
                handleReceiveMessage(input);
                handleSendMessage(output);

            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        } catch (InterruptedException e ){
            System.out.println("bleee");
        }
    }

    protected void handlersInitializer(Socket socket) throws IOException {
        String name = Thread.currentThread().getName();
        input = new InputHandler(name, socket);
        output = new OutputHandler(name, socket);
        input.start();
        output.start();
    }

    protected void handleSendMessage(OutputHandler output) throws InterruptedException{
        Message sendMessage;
//        Thread.sleep(1000);
        if (output.getMessage() != null) {

            sendMessage = output.getMessage();

            System.out.println("mode send message: "+sendMessage.toString());
//
            output.resetMessage();
        }

    }

    protected void handleReceiveMessage(InputHandler input) throws InterruptedException{
        Message receiveMessage;
//    Thread.sleep(1000);
        if (input.getIncomingMessage()!=null) {

            receiveMessage = input.getIncomingMessage();
            System.out.println("mode receive message: "+receiveMessage.toString());
            input.resetMessage();
        }

    }


}
