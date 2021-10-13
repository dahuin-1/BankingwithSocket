package com.example.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BankingStub implements IBanking {

    @Override
    public Integer deposit(Integer money) throws Exception {
        return call("deposit", money);
    }

    @Override
    public Integer withdraw(Integer money) throws Exception {
        return call("withdraw", money);
    }


    Integer call(String command, Integer money) throws Exception {
        Socket client = new Socket("localhost", 9090);
        System.out.println("Trying connecting to server");

        InputStream in = client.getInputStream();
        PrintWriter pw = new PrintWriter(client.getOutputStream());
        pw.println(command + ":" + money);
        pw.flush();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String returnValue = reader.readLine();
        String[] propertyAndValue = returnValue.split(":");
        client.close();
        return Integer.parseInt(propertyAndValue[1].trim());
    }


}
