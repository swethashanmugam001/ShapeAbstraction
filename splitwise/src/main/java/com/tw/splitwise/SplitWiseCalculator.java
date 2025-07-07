package com.tw.splitwise;

import com.tw.splitwise.dao.ExpenseDao;
import com.tw.splitwise.dao.ExpenseDaoImpl;
import com.tw.splitwise.service.ExpenseService;
import com.tw.splitwise.service.ExpenseServiceImpl;
import com.tw.splitwise.util.FileParser;

import java.util.Map;

public class SplitWiseCalculator {
    public static void main(String[] args) {
        ExpenseDao expenseDao = new ExpenseDaoImpl();
        ExpenseService expenseService = new ExpenseServiceImpl(expenseDao);
        Map<String, Map<String,Double>> expenseSummary = expenseService.splitAllExpenses();
        FileParser.printExpenseSummary(expenseSummary, "Split Summary");
        FileParser.printExpenseSummary(expenseService.netOffAllExpenses(expenseSummary), "Split Summary Post Netoff");
    }
}
