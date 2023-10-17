package Homework;



public class CreditAccount extends Account {
    @Override
    public void take(double amount) {
        if (amount > 0 && amount <= getAmount()) {
            double fee = amount * 0.01;
            super.take(amount + fee);
        }
    }
}