
 package Homework;

 public class Account {
     private double balance;

    public void put(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void take(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getAmount() {
        return balance;
    }
}  
// public interface Account {
//    double getAmount();
//    void put(double amount);
//    void take(double amount);
//  }