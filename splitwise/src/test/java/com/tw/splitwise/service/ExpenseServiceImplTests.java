package com.tw.splitwise.service;

import com.tw.splitwise.dao.ExpenseDao;
import com.tw.splitwise.dao.ExpenseDaoImpl;
import com.tw.splitwise.entity.Expense;
import com.tw.splitwise.entity.User;
import com.tw.splitwise.exceptions.ExpenseNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseServiceImplTests {

    private static ExpenseService expenseService;

    @BeforeAll
    public static void setUp() {
        ExpenseDao expenseDao = new ExpenseDaoImpl();
        expenseService = new ExpenseServiceImpl(expenseDao);
    }

    @Test
    public void shouldSplitAllExpenses() {
        User x = new User("X");
        User y = new User("Y");
        User z = new User("Z");
        User aa = new User("AA");

        Expense expense = new Expense(x, 100.0, "Snacks", new Date(), List.of(x, y, z, aa));
        expenseService.add(expense);
        Map<String, Map<String, Double>> expenseSummary = expenseService.splitAllExpenses();

        assertNotNull(expenseSummary);
        assertTrue(expenseSummary.containsKey("X"));
        Map<String, Double> receiverSummary = expenseSummary.get("X");
        assertEquals(3, receiverSummary.size());
        assertEquals(25.0, receiverSummary.get("Y"));
        assertEquals(25.0, receiverSummary.get("Z"));
        assertEquals(25.0, receiverSummary.get("AA"));
    }

    @Test
    public void shouldNetOffAllExpenses() {
        User x = new User("XX");
        User y = new User("YY");
        User z = new User("ZZ");
        User ab = new User("AB");

        Expense expense1 = new Expense(x, 100.0, "Snacks", new Date(), List.of(x, y, z, ab));
        Expense expense2 = new Expense(y, 25.0, "Snacks", new Date(), List.of(x));
        expenseService.add(expense1);
        expenseService.add(expense2);

        Map<String, Map<String, Double>> expenseSummary = expenseService.splitAllExpenses();
        Map<String, Map<String, Double>> netoffSummary = expenseService.netOffAllExpenses(expenseSummary);

        assertNotNull(netoffSummary);
        assertTrue(netoffSummary.containsKey("XX"));
        Map<String, Double> receiverSummary = netoffSummary.get("XX");
        assertEquals(2, receiverSummary.size());
        assertNull(receiverSummary.get("YY"));
        assertEquals(25.0, receiverSummary.get("ZZ"));
        assertEquals(25.0, receiverSummary.get("AB"));
    }

    @Test
    public void shouldAdd() {
        User sender = new User("Vimal");
        User beneficiary = new User("Kumar");
        Expense expense = new Expense(sender, 100, "Cab", new Date(), List.of(beneficiary));
        assertTrue(expenseService.add(expense));
        assertNotNull(expenseService.findById(expense.getId()));
    }

    @Test
    public void shouldFindAll() {
        User sender = new User("Akshay");
        User beneficiary = new User("Kumar");
        Expense expense = new Expense(sender, 100, "Cab", new Date(), List.of(beneficiary));
        assertTrue(expenseService.add(expense));
        List<Expense> result = expenseService.findAll();
        boolean isFound = result.stream().anyMatch(x -> x.getSender().getName().equals("Akshay"));
        assertFalse(result.isEmpty());
        assertTrue(isFound);
    }

    @Test
    public void shouldFindById() {
        User sender = new User("Priya");
        User beneficiary = new User("Anand");
        Expense expense = new Expense(sender, 100, "Cab", new Date(), List.of(beneficiary));
        assertTrue(expenseService.add(expense));
        assertNotNull(expenseService.findById(expense.getId()));
    }

    @Test
    public void shouldFindBySenderName() {
        User Sender = new User("Ravi");
        User Receiver = new User("Reema");
        Expense expense = new Expense(Sender, 25.0, "Snacks", new Date(), List.of(Receiver));
        expenseService.add(expense);
        assertNotNull(expenseService.findBySenderName("Ravi"));
        assertThrows(ExpenseNotFoundException.class, () -> expenseService.findBySenderName("Ramya"));
    }

    @Test
    public void shouldFindByBeneficiaryName() {
        User Sender = new User("Vanitha");
        User Receiver = new User("Rajan");
        Expense expense = new Expense(Sender, 25.0, "Snacks", new Date(), List.of(Receiver));
        expenseService.add(expense);
        assertNotNull(expenseService.findByBeneficiaryName("Rajan"));
        assertThrows(ExpenseNotFoundException.class, () -> expenseService.findByBeneficiaryName("Mithun"));
    }

    @Test
    public void shouldFindByTransactionDate() {
        User sender = new User("Shruti");
        User beneficiary = new User("Jeeva");
        Date transactionDate = new Date();
        Expense expense = new Expense(sender, 100, "Cab", transactionDate, List.of(beneficiary));
        assertTrue(expenseService.add(expense));
        assertNotNull(expenseService.findByTransactionDate(transactionDate));
        assertThrows(ExpenseNotFoundException.class, () -> expenseService.findByTransactionDate(new Date()));
    }

    @Test
    public void shouldFindByCategory() {
        User Sender = new User("Joe");
        User Receiver = new User("Alice");
        Expense expense = new Expense(Sender, 25.0, "Snacks", new Date(), List.of(Receiver));
        expenseService.add(expense);
        assertNotNull(expenseService.findByCategory("Snacks"));
        assertThrows(ExpenseNotFoundException.class, () -> expenseService.findByCategory("Food"));
    }
}
