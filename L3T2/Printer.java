import java.util.Arrays;
import java.util.ArrayList;


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
    public static void main(String[] args) { 
      Integer[] arr = {};
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
      }
      else{
        arr = Arrays.stream(args[0].split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
      }     
      
      Answer ans = new Answer();      
      ans.removeEvenNumbers(arr);
    }
}

class Answer {
    public static void removeEvenNumbers(Integer[] arr) {
      // Введите свое решение ниже

        ArrayList<Integer> result = new ArrayList<>();

        for (Integer num : arr) {
            if (num % 2 != 0) {
                result.add(num);
            }
        }

        System.out.println(result);
       
    }
}

