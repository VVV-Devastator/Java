package Homework;

public class Homework {
    public static void main(String[] args) {
        Account account = new Account();
        account.put(1000);
        System.out.println("Текущий баланс обычного счета: " + account.getAmount());

        CreditAccount creditAccount = new CreditAccount();
        creditAccount.put(500);
        creditAccount.take(200);
        System.out.println("Текущий баланс кредитного счета: " + creditAccount.getAmount());

        DepositAccount depositAccount = new DepositAccount();
        depositAccount.put(2000);
        depositAccount.take(1000);
        System.out.println("Текущий баланс депозитного счета: " + depositAccount.getAmount());

        depositAccount.take(500); // Попытка снять средства второй раз в течение месяца
        System.out.println("Текущий баланс депозитного счета: " + depositAccount.getAmount());
    }
}