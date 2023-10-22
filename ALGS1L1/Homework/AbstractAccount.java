package Homework;
public class AbstractAccount implements Account {
    protected double balance;

    public AbstractAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public double getAmount() {
        return balance;
    }

    @Override
    public void put(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public void take(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
