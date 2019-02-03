package com.codecool.trash;

import com.codecool.models.Message;

import java.io.*;
import java.time.LocalDateTime;

public class Serializing implements Serializable {

    public static void main(String[] args) {
        try {
            Message message = new Message("Wiadomosc do serializowania", "server" );
            outputToFile(message);
            Message message2 = inputFromFile();

            System.out.println(message.toString());
            System.out.println(message2.toString());
            System.out.println(message.equals(message2));

        } catch (IOException ex) {
            System.out.println("IOEX");
        } catch (ClassNotFoundException ex) {
            System.out.println("nie moge znalezc pliku");
        }
    }

    public static Message inputFromFile() throws IOException, ClassNotFoundException{
        FileInputStream fileInputStream
                = new FileInputStream("ania.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        Message message = (Message) objectInputStream.readObject();
        objectInputStream.close();
        return message;
    }

    public static void outputToFile(Message message)  throws IOException {
        FileOutputStream fileOutputStream
                = new FileOutputStream("ania.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(message);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
