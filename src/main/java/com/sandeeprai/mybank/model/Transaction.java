package com.sandeeprai.mybank.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

public class Transaction {

    private String id;
    private Integer amount;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mmZ")
    private ZonedDateTime timestamp;
    private String reference;
    private String bankSlogan;

    public Transaction() {
    }

    public Transaction(String id, Integer amount, ZonedDateTime timestamp,
                       String reference, String bankSlogan) {
        this.id = id;
        this.amount = amount;
        this.timestamp = timestamp;
        this.reference = reference;
        this.bankSlogan = bankSlogan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getBankSlogan() {
        return bankSlogan;
    }

    public void setBankSlogan(String bankSlogan) {
        this.bankSlogan = bankSlogan;
    }
}
