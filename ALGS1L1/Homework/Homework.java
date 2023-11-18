package Homework;

public class  Homework{
    public static void main(String[] args) {
        // Создаем экземпляр класса Account
        Account account = new Account();
        account.put(1000);
        System.out.println("Текущий баланс обычного счета: " + account.getAmount());

        // Пополняем счет
        account.put(500);
        System.out.println("Текущий баланс после пополнения: " + account.getAmount()); // Выводит: Текущий баланс после пополнения: 1500

        // Снимаем средства со счета
        account.take(200);
        System.out.println("Текущий баланс после снятия: " + account.getAmount()); // Выводит: Текущий баланс после снятия: 1300

        // Снимаем средства со счета
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