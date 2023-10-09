import java.util.HashMap;

public class Printer {
    public static void main(String[] args) {
        String name1 = "Elena";
        String name2 = "Elena";
        String name3 = "Elena";
        String name4 = "Ivan";
        String name5 = "Ivan";

        NamesCounter namesCounter = new NamesCounter();

        namesCounter.addName(name1);
        namesCounter.addName(name2);
        namesCounter.addName(name3);
        namesCounter.addName(name4);
        namesCounter.addName(name5);

        namesCounter.showNamesOccurrences();
    }
}

class NamesCounter {
    private HashMap<String, Integer> names = new HashMap<>();

    public void addName(String name) {
        if (names.containsKey(name)) {
            int count = names.get(name);
            names.put(name, count + 1);
        } else {
            names.put(name, 1);
        }
    }

    public void showNamesOccurrences() {
        System.out.println(names);
    }
}

