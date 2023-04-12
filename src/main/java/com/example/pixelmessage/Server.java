package com.example.pixelmessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

     static  ArrayList<ClientHandler> ClientList = new ArrayList<>();

     static ExecutorService pool = Executors.newCachedThreadPool();





    public static void main(String[] args) {

        Socket socket;
        ServerSocket server;
        System.out.println("Server Started");

        try{
            server = new ServerSocket(1018);
            while (true){

                socket = server.accept();
                System.out.println(" Server Connected");
                ClientHandler clientHandler = new ClientHandler( ClientList, socket );
                ClientList.add(clientHandler);
               clientHandler.start();



            }


        }catch (IOException e){

            e.printStackTrace();
            System.out.println("Error Connecting to Server");

        }



    }





}
