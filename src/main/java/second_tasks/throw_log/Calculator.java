package second_tasks.throw_log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Calculator {

    final static Logger logger = LoggerFactory.getLogger(Calculator.class);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int num;

        try{
            num = calc(getInt(), getInt(), getOperation());
            System.out.println("Ответ: " + num);
        } catch (IllegalArgumentException e){
            logger.error(e.getMessage());
        }

    }

    public static int getInt() {
        while(true) {
            try {
                System.out.print("Введите число: ");
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                logger.error("Введен неверный формат числа, попробуйте еще раз");
            }
        }
    }

    public static char getOperation() {
        System.out.print("Введите операцию: ");
        return scanner.next().charAt(0);
    }

    public static int calc(int num1, int num2, char operation) {
        return switch (operation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num1 == 0 || num2 == 0) {
                    throw new IllegalArgumentException("Деление на ноль запрещено");
                }
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Введена неверная операция");
        };
    }

}
