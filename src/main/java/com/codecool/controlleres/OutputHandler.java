package com.codecool.controlleres;

import com.codecool.models.Message;

import java.io.*;
import java.net.Socket;

public class OutputHandler extends Thread {

    private Socket socket;
    private OutputStream output;
    private BufferedReader infoReader;
    private ObjectOutputStream preparedMessage;
    private Message message;
    private boolean isDone;

    public OutputHandler(String name, Socket socket) throws IOException {
        super(name);
        this.socket = socket;
        this.output = socket.getOutputStream();
    }

    public void run() {
        try {

            String infoToSend;
            preparedMessage = new ObjectOutputStream(output);

            while (true) {

                infoReader = new BufferedReader(new InputStreamReader(System.in));


                if ((infoToSend = infoReader.readLine()) != null) {
                    //System.out.println("outpuhandle przygotowuje strumien");
//                    isDone = false;
                    message = new Message (infoToSend, Thread.currentThread().getName());

//                    preparedMessage = new ObjectOutputStream(output);
                    preparedMessage.writeObject(message);
                    //System.out.println(message.toString());
//                    isDone = true;

//                    preparedMessage.flush();
                }
            }
        } catch (IOException e) {
            System.out.println("exception outputHandler");
        }
    }

    public ObjectOutputStream getObjectOutputStream() {
        return preparedMessage;
    }

    public Message getMessage() {
        return message;
    }

    public void resetMessage() {
        this.message = null;
    }

    public boolean isDone() {
        return isDone;
    }
}

