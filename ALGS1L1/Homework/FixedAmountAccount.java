package Homework;
public class FixedAmountAccount implements Account {
    private double balance;

    public FixedAmountAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public double getAmount() {
        return balance;
    }

    @Override
    public void put(double amount) {
        // Ничего не делаем, баланс остается неизменным
    }

    @Override
    public void take(double amount) {
        // Ничего не делаем, баланс остается неизменным
    }
}