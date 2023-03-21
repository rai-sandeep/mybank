package com.sandeeprai.mybank.service;

import com.sandeeprai.mybank.model.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class TransactionService {

    private final String bankSlogan;

    private List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public TransactionService(@Value("${bank.slogan}") String bankSlogan) {
        this.bankSlogan = bankSlogan;
    }

    public List<Transaction> getAll() {
        return transactions;
    }

    public void create(Integer amount, String reference) {
        transactions.add(new Transaction(
                UUID.randomUUID().toString(), amount, ZonedDateTime.now(), reference, bankSlogan));
    }
}
