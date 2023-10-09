import java.util.ArrayList;
import java.util.HashMap;

public class Printer {
    public static void main(String[] args) {
        String name1 = "Alice";
        String name2 = "Bob";
        int phone1 = 123456;
        int phone2 = 789012;

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name2, phone2);

        System.out.println(myPhoneBook.find(name1));
        System.out.println(PhoneBook.getPhoneBook());
        System.out.println(myPhoneBook.find("Me"));
    }
}
class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            ArrayList<Integer> numbers = phoneBook.get(name);
            numbers.add(phoneNum);
        } else {
            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.add(phoneNum);
            phoneBook.put(name, numbers);
        }
    }

    public ArrayList<Integer> find(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        } else {
            return new ArrayList<>();
        }
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }
}
