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

                Map<String, Double> beneficiarySummary = expenseSummary.computeIfAbsent(senderName, k -> new HashMap<>());

                beneficiarySummary.put(beneficiaryName,
                        beneficiarySummary.getOrDefault(beneficiaryName, 0.0) + amountToTransfer);
            }
        }
        return expenseSummary;
    }

    @Override
    public Map<String, Map<String, Double>> netOffAllExpenses(Map<String, Map<String, Double>> originalSummary) {
        Map<String, Map<String, Double>> netOffSummary = new HashMap<>();

        for (String firstUser : originalSummary.keySet()) {
            Map<String, Double> firstUserBeneficiaries = originalSummary.get(firstUser);

            for (String secondUser : firstUserBeneficiaries.keySet()) {
                double amountFirstToSecond = firstUserBeneficiaries.get(secondUser);
                double amountSecondToFirst = 0.0;

                if (originalSummary.containsKey(secondUser)) {
                    Map<String, Double> secondUserBeneficiaries = originalSummary.get(secondUser);
                    if (secondUserBeneficiaries.containsKey(firstUser)) {
                        amountSecondToFirst = secondUserBeneficiaries.get(firstUser);
                    }
                }

                if (amountFirstToSecond > amountSecondToFirst) {
                    double netAmount = amountFirstToSecond - amountSecondToFirst;
                    netOffSummary.computeIfAbsent(firstUser, k -> new HashMap<>()).put(secondUser, netAmount);
                }
            }
        }
        return netOffSummary;
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
