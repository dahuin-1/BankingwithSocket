package com.example.server;

public interface IBanking {
    Integer deposit(Integer money);
    Integer withdraw(Integer money) throws Exception;
}
