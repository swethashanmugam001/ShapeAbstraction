package com.tw.splitwise.service;

import com.tw.splitwise.dao.ExpenseDao;
import com.tw.splitwise.entity.Expense;
import com.tw.splitwise.entity.User;
import com.tw.splitwise.exceptions.ExpenseNotFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseDao expenseDao;

    public ExpenseServiceImpl(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    @Override
    public boolean add(Expense expense) {
        return expenseDao.add(expense);
    }

    @Override
    public Map<String, Map<String, Double>> splitAllExpenses() {
        Map<String, Map<String, Double>> expenseSummary = new HashMap<>();
        List<Expense> expenseList = expenseDao.findAll();
        for (Expense expense : expenseList) {
            String senderName = expense.getSender().getName();

            int splitShareCount = expense.getBeneficiaries().size();

            for (User beneficiary : expense.getBeneficiaries()) {
                String beneficiaryName = beneficiary.getName();

                if (beneficiaryName.equals(senderName)) continue;
                double amountToTransfer = expense.getTotalAmount() / splitShareCount;

                Map<String, Double> beneficiarySummary = expenseSummary.getOrDefault(senderName, new HashMap<>());
                double existingAmount = beneficiarySummary.getOrDefault(beneficiaryName, 0.0);

                beneficiarySummary.put(beneficiaryName, existingAmount + amountToTransfer);
                expenseSummary.put(senderName, beneficiarySummary);
            }
        }

        return expenseSummary;
    }


    @Override
    public Expense findById(int id) {
        return expenseDao.findById(id);
    }

    @Override
    public List<Expense> findAll() {
        return expenseDao.findAll();
    }

    @Override
    public List<Expense> findBySenderName(String name) {
        List<Expense> expenses = expenseDao.findBySenderName(name);
        if (expenses.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found for sender : " + name);
        }
        return expenses;
    }

    @Override
    public List<Expense> findByBeneficiaryName(String name) {
        List<Expense> expenses = expenseDao.findByBeneficiaryName(name);
        if (expenses.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found where beneficiary : " + name);
        }
        return expenses;
    }

    @Override
    public List<Expense> findByTransactionDate(Date transactionDate) {
        List<Expense> expenses = expenseDao.findByTransactionDate(transactionDate);
        if (expenses.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found for transactionDate : " + transactionDate);
        }
        return expenses;
    }

    @Override
    public List<Expense> findByCategory(String category) {
        List<Expense> expenses = expenseDao.findByCategory(category);
        if (expenses.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found for category : " + category);
        }
        return expenses;
    }
}
