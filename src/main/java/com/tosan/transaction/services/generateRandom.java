package com.tosan.transaction.services;

import java.util.Random;

public class generateRandom {

    static int lowNumber = 10000;
    static int highNumber = 99999;

    public static int generateRandomTransactionNumber() {
        Random r = new Random();
        return r.nextInt(highNumber - lowNumber) + lowNumber;
    }

}
