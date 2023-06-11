/** 4) К калькулятору из предыдущего ДЗ добавить логирование.
3+4=7
1+2=3
6/3=2 */

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class zadacha4 {
    private static Logger logger = Logger.getLogger(zadacha4.class.getName());
    private static FileHandler fh;

    static {
        try {
            fh = new FileHandler("calculator.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.setLevel(Level.INFO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double a = scanner.nextDouble();
        System.out.print("Введите второе число: ");
        double b = scanner.nextDouble();
        System.out.print("Введите операцию (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        double res;
        switch (op) {
            case '+':
                res = a + b;
                logger.log(Level.INFO, a + " + " + b + " = " + res);
                break;
            case '-':
                res = a - b;
                logger.log(Level.INFO, a + " - " + b + " = " + res);
                break;
            case '*':
                res = a * b;
                logger.log(Level.INFO, a + " * " + b + " = " + res);
                break;
            case '/':
                if (b == 0) {
                    logger.log(Level.WARNING, "Деление на 0: " + a + " / " + b);
                    System.out.println("Деление на 0");
                    return;
                }
                res = a / b;
                logger.log(Level.INFO, a + " / " + b + " = " + res);
                break;
            default:
                logger.log(Level.WARNING, "Недопустимая операция: " + a + " " + op + " " + b);
                System.out.println("Недопустимая операция");
                return;
        }
        System.out.println(a + " " + op + " " + b + " = " + res);
    }
}
