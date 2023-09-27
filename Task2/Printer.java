class Answer {
    public static void printPrimeNums() {
        for (int number = 0; number <= 1000; number++) {
            if (isPrime(number) || number==1) {
                System.out.println(number);
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
    public static void main(String[] args) { 
      
      main ans = new main();      
      ans.printPrimeNums();
    }
}