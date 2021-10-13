package com.example.client;

public class DummyBanking implements IBanking {
    @Override
    public Integer deposit(Integer money) {
        return -1;
    }

    @Override
    public Integer withdraw(Integer money) throws Exception {
        return -1;
    }
}
