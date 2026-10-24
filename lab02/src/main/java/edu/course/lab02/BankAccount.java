package edu.course.lab02;
public class BankAccount {
    private int balance;
    public BankAccount(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным");
        }
        this.balance = balance;
    }
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма депозита должна быть положительной");
        }
        balance += amount;
    }
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма вывода должна быть положительной");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
        balance -= amount;
    }
    public int getBalance() {
        return balance;
    }
}