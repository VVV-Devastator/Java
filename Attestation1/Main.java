import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите элементы массива через пробел: ");
        String input = scanner.nextLine();
        String[] array = input.split(" ");
        
        String[] result = filterArray(array);
        
        System.out.print("Результат: ");
        for (String item : result) {
            System.out.print(item + " ");
        }
    }
    
    public static String[] filterArray(String[] array) {
        int count = 0;
        for (String item : array) {
            if (item.length() <= 3) {
                count++;
            }
        }
        
        String[] result = new String[count];
        int index = 0;
        for (String item : array) {
            if (item.length() <= 3) {
                result[index] = item;
                index++;
            }
        }
        
        return result;
    }
}