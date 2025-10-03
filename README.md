# Expense-_Tracker
The Expense Tracker is a comprehensive Java-based financial management application designed to help you take control of your personal finances. Built with modern Object-Oriented Programming principles, this application provides an intuitive and powerful platform for tracking income, monitoring expenses, and generating detailed financial reports.


# Expense Tracker

A simple **Java-based expense management system** that helps users track income, record expenses, and generate financial reports. The project demonstrates core **Object-Oriented Programming (OOP)** concepts such as encapsulation, abstraction, inheritance, and polymorphism.

---

## 📖 Table of Contents

* [Introduction](#introduction)
* [Features](#features)
* [Project Structure](#project-structure)
* [Installation](#installation)
* [Usage](#usage)
* [Configuration](#configuration)
* [Dependencies](#dependencies)
* [Examples](#examples)
* [Troubleshooting](#troubleshooting)
* [Contributors](#contributors)
* [License](#license)

---

## 📝 Introduction

The **Expense Tracker** is a command-line application for personal finance management. It allows users to:

* Add incomes and expenses.
* View all transactions.
* Generate financial summaries and reports.

It is designed as a learning project to apply **Java programming principles** while solving a real-world problem.

---

## ✨ Features

* ✅ Add new expense records.
* ✅ Track income sources.
* ✅ View transaction history.
* ✅ Generate reports of total income, total expenses, and balance.
* ✅ Built with **OOP concepts** for clean design and modularity.

---

## 📂 Project Structure

```
Expense-_Tracker/
│
├── ExpenseTracker/        # Java source code
│   ├── Expense.java       # Expense model
│   ├── Income.java        # Income model
│   ├── Transaction.java   # Base class for all records
│   ├── ExpenseTracker.java # Main entry point
│   └── ...
│
├── project expense tracker_2.pdf # Project documentation
└── README.md              # Project overview
```

---

## ⚙️ Installation

### Prerequisites

* **Java JDK 8+** installed
* A terminal or IDE (IntelliJ, Eclipse, or VS Code with Java support)

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/hirushasuhan/Expense-_Tracker.git
   cd Expense-_Tracker
   ```

2. Compile the Java files:

   ```bash
   javac ExpenseTracker/*.java
   ```

3. Run the program:

   ```bash
   java ExpenseTracker.ExpenseTracker
   ```

---

## 🚀 Usage

* Run the program and follow the menu options.
* Example:

  * Add income: enter source and amount.
  * Add expense: enter category and amount.
  * Generate report: view income, expenses, and balance.

---

## ⚡ Configuration

No special configuration required. Transactions are stored during runtime (in memory). You may extend the project to use **file storage or a database** for persistence.

---

## 📦 Dependencies

* Pure **Java SE** (no external libraries).

---

## 🖼️ Examples

```
Welcome to Expense Tracker  
1. Add Income  
2. Add Expense  
3. View Transactions  
4. Generate Report  
5. Exit  

Enter choice: 1  
Enter income source: Salary  
Enter amount: 2000  
✅ Income added successfully!  
```

---

## 🛠️ Troubleshooting

* **Program doesn’t run?**

  * Ensure you are inside the project root folder.
  * Check that Java is installed:

    ```bash
    java -version
    ```
* **Compilation errors?**

  * Make sure you are using Java 8 or higher.

---

## 👨‍💻 Contributors

* [Hirusha Suhan](https://github.com/hirushasuhan)

---

## 📜 License

This project is licensed under the **MIT License** – feel free to use and modify.

---
