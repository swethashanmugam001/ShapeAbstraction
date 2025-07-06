package com.tw.splitwise.dao;

import com.tw.splitwise.entity.Expense;

import java.util.Date;
import java.util.List;

public interface ExpenseDao {

    boolean add(Expense expense);

    Expense findById(int id);

    List<Expense> findAll();

    List<Expense> findBySenderName(String name);

    List<Expense> findByBeneficiaryName(String name);

    List<Expense> findByTransactionDate(Date transactionDate);

    List<Expense> findByCategory(String category);

}
