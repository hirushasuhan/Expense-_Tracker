/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.library.expensetracker;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author HP
 */

public class ExpenseTracker {
    private List<Transaction> transactions;
    private String fileName;
    private String userLogin;
    
    
    public ExpenseTracker(String userLogin) {
        this.transactions = new ArrayList<>(); 
        this.fileName = "expense_report_" + userLogin + ".txt";
        this.userLogin = userLogin;
    }
    
    
    public ExpenseTracker() {
        this("Admin/IIT/23011");
    }
    
    
    public void addTransaction(Expense expense) {
        transactions.add(expense);
        System.out.println("Expense added successfully!");
    }
    
    public void addTransaction(Income income) {
        transactions.add(income);
        System.out.println("Income added successfully!");
    }
    
    public void addTransaction(String description, double amount, String type) {
        if (type.equalsIgnoreCase("expense")) {
            transactions.add(new Expense(description, amount));
        } else if (type.equalsIgnoreCase("income")) {
            transactions.add(new Income(description, amount));
        }
        System.out.println("Transaction added successfully!");
    }
    
   
    public double getTotalExpenses() {
         double total = 0;
         for (Transaction t : transactions) {
              if (t instanceof Expense) {
              total += t.getAmount();
             }
        }
        return total;
    }
    
   
    public double getTotalIncome() {
         double total = 0;
         for (Transaction t : transactions) {
            if (t instanceof Income) {
             total += t.getAmount();
            }
        }
    return total;
    }
    
    
    public double getBalance() {
        return getTotalIncome() - getTotalExpenses();
    }
    
    
    public void displayTransactions() {
        System.out.println("\n=== ALL TRANSACTIONS ===");
        if (transactions.isEmpty()) {
            System.out.println("No transactions found. Start by adding your first income or expense!");
            return;
        }
        
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i + 1) + ". " + transactions.get(i).getDetails());
        }
    }
    
   
    public void generateReport() {
        try (FileWriter writer = new FileWriter(fileName);
             PrintWriter printWriter = new PrintWriter(writer)) {
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            
            printWriter.println("EXPENSE TRACKER REPORT");
            printWriter.println("User: " + userLogin);
            printWriter.println("Generated on: " + LocalDateTime.now().format(formatter));
            printWriter.println("=".repeat(50));
            printWriter.println();
            
            printWriter.println("FINANCIAL SUMMARY:");
            printWriter.printf("Total Income: $%.2f%n", getTotalIncome());
            printWriter.printf("Total Expenses: $%.2f%n", getTotalExpenses());
            printWriter.printf("Current Balance: $%.2f%n", getBalance());
            printWriter.println();
            
            printWriter.println("TRANSACTION HISTORY:");
            if (transactions.isEmpty()) {
                printWriter.println("No transactions recorded.");
            } else {
                for (int i = 0; i < transactions.size(); i++) {
                    printWriter.println((i + 1) + ". " + transactions.get(i).getDetails());
                }
            }
            
            printWriter.println();
            printWriter.println("=".repeat(50));
            printWriter.println("End of Report");
            
            System.out.println("Report generated successfully: " + fileName);
        } catch (IOException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }
    
    
    public void readReport() {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("No existing report found for user: " + userLogin);
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("\n=== READING EXISTING REPORT ===");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading report: " + e.getMessage());
        }
    }
    
    
    public String getSummary() {
        return String.format("Income: $%.2f | Expenses: $%.2f | Balance: $%.2f", 
                           getTotalIncome(), getTotalExpenses(), getBalance());
    }
    
    
    public boolean isFreshStart() {
        return transactions.isEmpty();
    }
    
    
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        System.out.println("===================================================");
        System.out.println("Welcome to Expense Tracker!");
        System.out.println("User: " + tracker.userLogin);
        System.out.println("===================================================");
        
        System.out.println("Starting with clean slate - no existing transactions.");
        
        while (true) {
            System.out.println("\n=== EXPENSE TRACKER MENU ===");
            
            if (tracker.isFreshStart()) {
                System.out.println("Status: Fresh Start - Add your first transaction!");
            } else {
                System.out.println("Current Status: " + tracker.getSummary());
            }
            
            System.out.println("1. Add Expense");
            System.out.println("2. Add Income");
            System.out.println("3. View All Transactions");
            System.out.println("4. View Financial Summary");
            System.out.println("5. Generate Report File");
            System.out.println("6. Read Existing Report");
            System.out.println("7. Exit");
            System.out.print("Choose an option (1-7): ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter expense description: ");
                        String expDesc = scanner.nextLine();
                        System.out.print("Enter amount: $");
                        double expAmount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter category (or press Enter for 'General'): ");
                        String category = scanner.nextLine().trim();
                        
                        if (category.isEmpty()) {
                            tracker.addTransaction(new Expense(expDesc, expAmount));
                        } else {
                            tracker.addTransaction(new Expense(expDesc, expAmount, category));
                        }
                        break;
                        
                    case 2:
                        System.out.print("Enter income description: ");
                        String incDesc = scanner.nextLine();
                        System.out.print("Enter amount: $");
                        double incAmount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter source (or press Enter for 'Other'): ");
                        String source = scanner.nextLine().trim();
                        
                        if (source.isEmpty()) {
                            tracker.addTransaction(new Income(incDesc, incAmount));
                        } else {
                            tracker.addTransaction(new Income(incDesc, incAmount, source));
                        }
                        break;
                        
                    case 3:
                        tracker.displayTransactions();
                        break;
                        
                    case 4:
                        System.out.println("\n=== FINANCIAL SUMMARY ===");
                        if (tracker.isFreshStart()) {
                            System.out.println("No transactions recorded yet.");
                            System.out.println("Start by adding your first income or expense!");
                        } else {
                            System.out.printf("Total Income: $%.2f%n", tracker.getTotalIncome());
                            System.out.printf("Total Expenses: $%.2f%n", tracker.getTotalExpenses());
                            System.out.printf("Current Balance: $%.2f%n", tracker.getBalance());
                            if (tracker.getBalance() < 0) {
                                System.out.println(" Warning: You are spending more than you earn!");
                            } else if (tracker.getBalance() == 0) {
                                System.out.println(" You're breaking even!");
                            } else {
                                System.out.println("You're saving money!");
                            }
                        }
                        break;
                        
                    case 5:
                        if (tracker.isFreshStart()) {
                            System.out.println("No transactions to report. Add some transactions first!");
                        } else {
                            tracker.generateReport();
                        }
                        break;
                        
                    case 6:
                        tracker.readReport();
                        break;
                        
                    case 7:
                        System.out.println("Thank you for using Expense Tracker, " + tracker.userLogin + "!");
                        if (!tracker.isFreshStart()) {
                            System.out.println("Final Status: " + tracker.getSummary());
                        }
                        scanner.close();
                        return;
                        
                    default:
                        System.out.println("Invalid option. Please choose 1-7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
    }
}