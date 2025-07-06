package com.tw.splitwise.dao;

import com.tw.splitwise.entity.Expense;
import com.tw.splitwise.util.FileParser;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseDaoImpl implements ExpenseDao {

    private final List<Expense> expenses;

    public ExpenseDaoImpl() {
        expenses = FileParser.getAllExpenses();
    }

    @Override
    public Expense findById(int id) {
        return expenses.stream().filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean add(Expense expense) {
        expenses.add(expense);
        return true;
    }

    @Override
    public List<Expense> findAll() {
        return expenses;
    }

    @Override
    public List<Expense> findByBeneficiaryName(String name) {
        return expenses.stream().filter(x -> x.getBeneficiaries().stream()
                        .anyMatch(user -> user.getName().equals(name)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Expense> findBySenderName(String name) {
        return expenses.stream().filter(x -> x.getSender().getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Expense> findByTransactionDate(Date transactionDate) {
        return expenses.stream().filter(x -> x.getTransactionDate() == transactionDate)
                .collect(Collectors.toList());
    }

    @Override
    public List<Expense> findByCategory(String category) {
        return expenses.stream().filter(x -> x.getCategory().equals(category))
                .collect(Collectors.toList());
    }

}
