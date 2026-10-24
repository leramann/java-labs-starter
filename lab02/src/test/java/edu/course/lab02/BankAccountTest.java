package edu.course.lab02;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BankAccountTest {
    @Test
    void createsAccountWithValidBalance() {
        BankAccount account = new BankAccount(1000);
        assertEquals(1000, account.getBalance());
    }
    @Test
    void rejectsNegativeInitialBalance() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount(-1)
        );
    }
    @Test
    void depositsMoney() {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }
    @Test
    void rejectsZeroDeposit() {
        BankAccount account = new BankAccount(1000);
        assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(0)
        );
    }
    @Test
    void withdrawsMoney() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }
    @Test
    void rejectsWithdrawalGreaterThanBalance() {
        BankAccount account = new BankAccount(1000);
        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(1500)
        );
    }
    @Test
    void rejectsNegativeWithdrawal() {
        BankAccount account = new BankAccount(1000);
        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(-100)
        );
    }
    @Test
    void allowsWithdrawalOfEntireBalance() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(1000);
        assertEquals(0, account.getBalance());
    }
}