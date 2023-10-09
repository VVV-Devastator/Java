import java.util.Arrays;
import java.util.ArrayList;

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
    public static void main(String[] args) { 
      Integer[] arr = {};
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
      }
      else{
        arr = Arrays.stream(args[0].split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
      }     
      
      Answer ans = new Answer();      
      ans.analyzeNumbers(arr);
    }
}

class Answer {
    public static void analyzeNumbers(Integer[] arr) {
      // Введите свое решение ниже
        Arrays.sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));

        // Находим минимальное значение
        int min = arr[0];
        System.out.println("Minimum is " + min);

        // Находим максимальное значение
        int max = arr[arr.length - 1];
        System.out.println("Maximum is " + max);

        // Находим среднее арифметическое
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double average = (double) sum / arr.length;
        System.out.println("Average is " + average);
       
    }
}

