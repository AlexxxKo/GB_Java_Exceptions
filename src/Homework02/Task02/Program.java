package Homework02.Task02;

public class Program {
    public static void main(String[] args) {
        int[] intArray = {2, 3, 5, 9, 9, 5, 0, -1, 5};

        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}

// Если не брать в расчёт, что массив intArray не задан, то исправлять нечего.
