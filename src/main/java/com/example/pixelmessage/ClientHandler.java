package com.example.pixelmessage;



import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {


    ArrayList<ClientHandler> Clients = new ArrayList<>();
    BufferedReader reader;
    PrintWriter writer;

    Socket ClientSocket;

    public ClientHandler(ArrayList<ClientHandler> clients, Socket clientSocket) {

        try {
            this.Clients = clients;
            this.ClientSocket = clientSocket;
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new PrintWriter(clientSocket.getOutputStream(), true);

        } catch (IOException e) {

            e.printStackTrace();
            System.out.println("Error Connecting CLIENT");
        }
    }

    @Override
    public void run() {
        try {
            String msg;
            while ((msg = reader.readLine())!= null) {
                for (ClientHandler cl : Clients) {
                    cl.writer.println(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                reader.close();
                ClientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
