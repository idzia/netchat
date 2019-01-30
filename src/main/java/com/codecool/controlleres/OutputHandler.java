package com.codecool.controlleres;

import java.io.*;
import java.net.Socket;

public class OutputHandler extends Thread {

    private Socket socket;
    private OutputStream output;
    PrintWriter writer;
    private BufferedReader prepareMessage;

    public OutputHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.output = socket.getOutputStream();
        this.writer = new PrintWriter(output, true);
    }

    public void run() {
        try {

            String sendMessage;

            while (true) {
                prepareMessage = new BufferedReader(new InputStreamReader(System.in));

                if ((sendMessage = prepareMessage.readLine()) != null) {
                    writer.println("> " + sendMessage);
                    output.flush();
                }
            }

        } catch (IOException e) {
            System.out.println("exception outputHandler");
        }
    }

    public BufferedReader getPrepareMessage() {
        return prepareMessage;
    }
}

