package com.sandeeprai.mybank.web;

import com.sandeeprai.mybank.context.Application;
import com.sandeeprai.mybank.model.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MyBankServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getRequestURI().equalsIgnoreCase("/")) {
            resp.setContentType("text/plain; charset=UTF-8");
            resp.getWriter().print("hello");
        } else if (req.getRequestURI().equalsIgnoreCase("/transactions")) {
            resp.setContentType("application/json; charset=UTF-8");
            List<Transaction> transactions = Application.transactionService.getAll();
            resp.getWriter().print(Application.objectMapper.writeValueAsString(transactions));
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
            Application.transactionService.create(amount, reference);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
