import java.util.ArrayDeque;
import java.util.Deque;
public class Printer {
    public static void main(String[] args) {
        int a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
            a = 3;
            op = '+';
            b = 7;
            c = 4;
            op2 = '+';
            d = 7;
            undo = '<';
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
            c = Integer.parseInt(args[3]);
            op2 = args[4].charAt(0);
            d = Integer.parseInt(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);
        int result2 = calculator.calculate(op2, c, d);
        System.out.println(result2);
        int prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(prevResult);
    }
}
class Calculator {
    private Deque<Integer> stack;

    public Calculator() {
        stack = new ArrayDeque<>();
    }

    public int calculate(char op, int a, int b) {
        if (op == '+') {
            int result = a + b;
            stack.push(result);
            return result;
        } else if (op == '-') {
            int result = a - b;
            stack.push(result);
            return result;
        } else if (op == '*') {
            int result = a * b;
            stack.push(result);
            return result;
        } else if (op == '/') {
            int result = a / b;
            stack.push(result);
            return result;
        } else if (op == '<') {
            stack.pop();
            return stack.peek();
        }

        return 0;
    }
}

