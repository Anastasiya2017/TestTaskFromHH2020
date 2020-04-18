import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1. Замена некоторых чисел на слова.");
        replacingNumbersWithWords();
        System.out.println("____________________________________________");

        System.out.println("Задача 2. Вычесление ф-ии: f(m,r) = m! / (r! (m-r)!)");
        functionCalculation();
    }

    private static void replacingNumbersWithWords() {
        /*
          Написать программу, которая выводит числа от 1 до 100, но вместо чисел кратных 2 нужно выводить строку Two,
          вместо чисел кратных 7 - строку Seven, вместо чисел кратных 2 и 7 - строку TwoSeven.  
         */
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i % 7 == 0 ? "TwoSeven" : "Two");
            } else if (i % 7 == 0) {
                System.out.println("Seven");
            } else {
                System.out.println(i);
            }
        }
    }

    private static void functionCalculation() {
        /*
          Написать программу, вычисляющую для любых натуральных m и r,
          таких что r ≤ m, значение функции  f(m,r) = m! / (r! (m-r)!)
         */
        System.out.print("Введите натуральное число m: ");
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        System.out.print("Введите натуральное число r (r ≤ m): ");
        int r = scan.nextInt();
        if (r <= m) {
            System.out.print("Результат: " + func(m, r) + "\r\n");
        } else {
            System.out.print("r должно быть ≤ m\r\n");
        }
    }

    private static BigInteger factorial(int n) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) ret = ret.multiply(BigInteger.valueOf(i));
        return ret;
    }

    private static BigInteger func(int m, int r) {
        return factorial(m).divide(factorial(r).multiply(factorial(m - r)));
    }
}