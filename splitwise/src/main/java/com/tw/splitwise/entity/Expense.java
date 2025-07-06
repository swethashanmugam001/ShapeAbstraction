package com.tw.splitwise.entity;

import java.util.Date;
import java.util.List;

public class Expense {

    private static int expenseIdCounter = 1;
    private int id;
    private User sender;
    private double totalAmount;
    private String category;
    private Date transactionDate;
    private List<User> beneficiaries;

    public Expense(User sender, double totalAmount, String category, Date transactionDate, List<User> beneficiaries) {
        this.id = expenseIdCounter++;
        this.sender = sender;
        this.totalAmount = totalAmount;
        this.category = category;
        this.transactionDate = transactionDate;
        this.beneficiaries = beneficiaries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public List<User> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<User> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    @Override
    public String toString() {
        return "Expense{" + "id=" + id + ", sender=" + sender + ", totalAmount=" + totalAmount + ", category='" + category + '\'' + ", transactionDate=" + transactionDate + ", beneficiaries=" + beneficiaries + '}';
    }
}
