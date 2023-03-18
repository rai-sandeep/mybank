package com.sandeeprai.mybank.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandeeprai.mybank.service.TransactionService;

public class Application {

    public static final TransactionService transactionService = new TransactionService();
    public static final ObjectMapper objectMapper = new ObjectMapper();
}
