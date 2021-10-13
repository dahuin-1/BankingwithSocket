package com.example.server;

public class ServerBanking implements IBanking{

    int balance = 0;

    @Override
    public Integer deposit(Integer money) {
        balance = balance + money;
        return balance;
    }

    @Override
    public Integer withdraw(Integer money) throws Exception {
        balance = balance - money;
        return balance;
    }
}
