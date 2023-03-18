package com.sandeeprai.mybank.service;

import com.sandeeprai.mybank.model.Transaction;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionService {

    private List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public List<Transaction> getAll() {
        return transactions;
    }

    public void create(Integer amount, String reference) {
        transactions.add(new Transaction(
                UUID.randomUUID().toString(), amount, ZonedDateTime.now(), reference));
    }
}
