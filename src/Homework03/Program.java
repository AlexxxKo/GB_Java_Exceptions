package Homework03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        boolean isData;
        String[] data;
        System.out.println("Введите данные через пробел в одну строчку:");
        System.out.println("Фамилия");
        System.out.println("Имя");
        System.out.println("Отчество");
        System.out.println("Дата рождения в формате dd.mm.yyyy");
        System.out.println("Номер телефона (только цифры)");
        System.out.println("Пол (f или m)");
        do {
            isData = true;
            data = getData();
            if (data.length > 6) {
                System.out.println("Вы ввели слишком много данных. Попробуйте ещё раз.");
                isData = false;
                continue;
            }
            if (data.length < 6) {
                System.out.println("Вы ввели слишком мало данных. Попробуйте ещё раз.");
                isData = false;
                continue;
            }

            String surname = onlyLetters(data[0]);
            if (surname.equals("1")) {
                System.out.println("Фамилия должна содержать только буквы. Попробуйте ещё раз.");
                isData = false;
                continue;
            }

            String name = onlyLetters(data[1]);
            if (name.equals("1")) {
                System.out.println("Имя должно содержать только буквы. Попробуйте ещё раз.");
                isData = false;
                continue;
            }

            String partronymic = onlyLetters(data[2]);
            if (partronymic.equals("1")) {
                System.out.println("Отчество должно содержать только буквы. Попробуйте ещё раз.");
                isData = false;
                continue;
            }

            String birthday = data[3];
            boolean isBirthday = birthdayEx(birthday);
            if (!isBirthday) {
                System.out.println("Ошибка! Неверный формат даты. Попробуйте ещё раз.");
                isData = false;
                continue;
            }

            long phoneNumber;
            if (data[4].length() < 5 || data[4].length() > 11) {
                System.out.println("Ошибка! Неверное количество цифр в номере телефона. Попробуйте ещё раз.");
                isData = false;
                continue;
            }
            try {
                phoneNumber = Long.parseLong(data[4]);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Неверный формат номера телефона. Попробуйте ещё раз.");
                isData = false;
                continue;
            }

            if (data[5].length() != 1 || (!data[5].equals("f") && !data[5].equals("m"))) {
                System.out.println("Ошибка! Неверный формат пола. Попробуйте ещё раз.");
                isData = false;
                continue;
            }
        } while (!isData);
        for (Object el : data) {
            System.out.println(el);
        }
        createFile(data);
    }

    private static String[] getData() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        return data;
    }

    private static String onlyLetters(String str) {
        if (str.matches("[a-zA-Z]+")) return str;
        else return "1";
    }

    private static boolean birthdayEx(String str) {
        String dateFormat = "dd.mm.yyyy";
        try {
            DateFormat df = new SimpleDateFormat(dateFormat);
            df.setLenient(false);
            df.parse(str);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static void createFile(String[] arr) {
        String fileName = arr[0] + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String output = arr[0] + arr[1] + arr[2] + arr[3] + " " + arr[4] + arr[5];
            writer.write(output);
            writer.newLine();
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
