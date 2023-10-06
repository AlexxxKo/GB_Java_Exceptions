package Homework02.Task01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Вы ввели число: " + getFloatInput());
    }

    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите дробное число: ");
                float num = Float.parseFloat(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите дробное число.");
                System.out.println();
            }
        }
    }
}
