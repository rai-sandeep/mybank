package com.sandeeprai.mybank.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandeeprai.mybank.context.MyBankContextConfiguration;
import com.sandeeprai.mybank.model.Transaction;
import com.sandeeprai.mybank.service.TransactionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MyBankServlet extends HttpServlet {

    private TransactionService transactionService;
    private ObjectMapper objectMapper;

    @Override
    public void init() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                MyBankContextConfiguration.class);
        this.transactionService = ctx.getBean(TransactionService.class);
        this.objectMapper = ctx.getBean(ObjectMapper.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getRequestURI().equalsIgnoreCase("/")) {
            resp.setContentType("text/plain; charset=UTF-8");
            resp.getWriter().print("hello");
        } else if (req.getRequestURI().equalsIgnoreCase("/transactions")) {
            resp.setContentType("application/json; charset=UTF-8");
            List<Transaction> transactions = transactionService.getAll();
            resp.getWriter().print(objectMapper.writeValueAsString(transactions));
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getRequestURI().equalsIgnoreCase("/transactions")) {
            Integer amount = Integer.valueOf(req.getParameter("amount"));
            String reference = req.getParameter("reference");
            transactionService.create(amount, reference);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
