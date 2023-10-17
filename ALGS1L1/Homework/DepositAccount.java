package Homework;

import java.time.LocalDate;

public class DepositAccount extends Account {
    private LocalDate lastWithdrawalDate;

    public void take(double amount) {
        if (amount > 0 && amount <= getAmount() && canWithdraw()) {
            super.take(amount);
            lastWithdrawalDate = LocalDate.now();
        }
    }

    private boolean canWithdraw() {
        return lastWithdrawalDate == null || lastWithdrawalDate.plusMonths(1).isBefore(LocalDate.now());
    }
}