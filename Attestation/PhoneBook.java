import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения данных телефонной книги
        Map<String, Set<String>> phoneBook = new HashMap<>();

        // Добавляем записи в телефонную книгу
        addContact(phoneBook, "Иванов", "12555-1234");
        addContact(phoneBook, "Петров", "23555-5678");
        addContact(phoneBook, "Сидоров", "23555-9012");
        addContact(phoneBook, "Иванов", "14555-7890");
        addContact(phoneBook, "Петров", "14555-4321");

        // Выводим содержимое телефонной книги
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {
        // Если контакт уже существует, добавляем новый номер телефона к нему
        if (phoneBook.containsKey(name)) {
            Set<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            // Если контакта нет, создаем новую запись
            Set<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    // Метод для вывода содержимого телефонной книги
    public static void printPhoneBook(Map<String, Set<String>> phoneBook) {
        // Создаем список записей телефонной книги, чтобы отсортировать их по убыванию числа телефонов
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем записи по убыванию числа телефонов
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<String, Set<String>> entry : entries) {
            String name = entry.getKey();
            Set<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}