package com.tw.splitwise.util;

import com.tw.splitwise.entity.Expense;
import com.tw.splitwise.entity.User;
import com.tw.splitwise.exceptions.EmptyUserNameException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileParser {

    private static final Logger LOGGER = Logger.getLogger(FileParser.class.getName());
    private static final Map<String, User> userMap = new HashMap<>();
    private static final List<Expense> expenseList = parseInputFile();

    private FileParser() {
    }

    public static List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public static List<Expense> getAllExpenses() {
        return expenseList;
    }

    public static void printExpenseSummary(Map<String, Map<String, Double>> expenseSummary) {
        for (Map.Entry<String, Map<String, Double>> entry : expenseSummary.entrySet()) {
            Map<String, Double> receiverSummary = entry.getValue();
            for (var receiver : receiverSummary.entrySet()) {
                System.out.println(receiver.getKey() + " pays " + entry.getKey() + " " + receiver.getValue());
            }
        }
    }

    private static List<Expense> parseInputFile() {
        List<Expense> expenses;
        try {
            Path path = Paths.get(ClassLoader.getSystemResource("split_expense.txt").toURI());
            try (Stream<String> lines = Files.lines(path)) {
                expenses = lines.filter(line -> !line.isEmpty())
                        .map(FileParser::parseEachLine)
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return new ArrayList<>();
        }
        return expenses;
    }

    private static Expense parseEachLine(String line) {
        String REGEX = " spent | for ";
        String[] column = line.split(REGEX);

        User sender = getUser(column[0].trim());
        double amount = Double.parseDouble(column[1].trim());
        String category = column[2].trim();
        List<String> beneficiaryNames = Arrays.asList(column[3].trim().split(","));
        List<User> beneficiariesExceptSelf = beneficiaryNames.stream()
                .map(String::trim)
                .map(FileParser::getUser)
                .collect(Collectors.toList());

        return new Expense(sender, amount, category, new Date(), beneficiariesExceptSelf);
    }

    private static User getUser(String name) {
        if (name == null || name.isEmpty())
            throw new EmptyUserNameException("Beneficiary name cannot be null or empty");
        if (!userMap.containsKey(name)) {
            userMap.put(name, new User(name));
        }
        return userMap.get(name);
    }
}
