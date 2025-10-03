/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.library.expensetracker;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author HP
 */
abstract class Transaction {
    protected String description;
    protected double amount;
    protected LocalDateTime dateTime;
    
    
    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }
    
    
    public abstract String getTransactionType();
    
    
    public String getDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("Description: %s, Amount: $%.2f, Date: %s", 
                           description, amount, dateTime.format(formatter));
    }
    
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
}


class Expense extends Transaction {
    private String category;
    
    
    public Expense(String description, double amount, String category) {
        super(description, amount); 
        this.category = category;
    }
    
    
    public Expense(String description, double amount) {
        this(description, amount, "General"); 
    }
    
    
    @Override
    public String getTransactionType() {
        return "EXPENSE";
    }
    
    
    @Override
    public String getDetails() {
        return super.getDetails() + String.format(", Category: %s, Type: %s", category, getTransactionType());
    }
    
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
}


class Income extends Transaction {
    private String source;
    
    public Income(String description, double amount, String source) {
        super(description, amount);
        this.source = source;
    }
    
    
    public Income(String description, double amount) {
        this(description, amount, "Other");
    }
    
    @Override
    public String getTransactionType() {
        return "INCOME";
    }
    
    @Override
    public String getDetails() {
        return super.getDetails() + String.format(", Source: %s, Type: %s", source, getTransactionType());
    }
    
    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
}