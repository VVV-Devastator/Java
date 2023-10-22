package Homework;

public class  Homework{
    public static void main(String[] args) {
        // Создаем экземпляр класса AbstractAccount
        Account account = new AbstractAccount(1000);
        System.out.println("Текущий баланс: " + account.getAmount()); // Выводит: Текущий баланс: 1000

        // Пополняем счет
        account.put(500);
        System.out.println("Текущий баланс после пополнения: " + account.getAmount()); // Выводит: Текущий баланс после пополнения: 1500

        // Снимаем средства со счета
        account.take(200);
        System.out.println("Текущий баланс после снятия: " + account.getAmount()); // Выводит: Текущий баланс после снятия: 1300

        // Создаем экземпляр класса FixedAmountAccount
        Account fixedAccount = new FixedAmountAccount(2000);
        System.out.println("Текущий баланс фиксированного счета: " + fixedAccount.getAmount()); // Выводит: Текущий баланс фиксированного счета: 2000

        // Попытка пополнения и снятия средств с фиксированного счета
        fixedAccount.put(500);
        fixedAccount.take(300);
        System.out.println("Текущий баланс фиксированного счета: " + fixedAccount.getAmount()); // Выводит: Текущий баланс фиксированного счета: 2000 (баланс не изменился)
    }
}