package com.example.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
    public static void main( String[] args ) throws Exception {
        ServerSocket server = new ServerSocket(9090);
        System.out.println("Waiting for client");

        ServerBanking banking = new ServerBanking();


        while(true) {

            Socket socket = server.accept();

            System.out.println("A client connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            String depositCommand = reader.readLine();
            String commandAndParam [] = depositCommand.split(":");

            int balance = 0;
            if("deposit".equals(commandAndParam[0])) {
               balance = banking.deposit(Integer.parseInt(commandAndParam[1]));
            }else if("withdraw".equals(commandAndParam[0])) {
                balance = banking.withdraw(Integer.parseInt(commandAndParam[1]));
            }
            pw.println("balance: " + balance);
            pw.flush();



           /*  pw.println("http/1.1 200 OK");
             pw.println("http/1.1 200 OK");
             pw.println("http/1.1 200 OK");
             pw.println("http/1.1 200 OK");
             pw.println("http/1.1 200 OK");
             pw.flush();*/
        }


    

    }
}
