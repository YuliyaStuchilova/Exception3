package org.example;

import java.io.FileWriter;
import java.util.Scanner;

public class Task {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String birthday;
    private long phone;
    private char gender;
    private Scanner sc = new Scanner(System.in);

    private void EnterFirstName() {
        System.out.println("Введите имя:");
        firstName = sc.nextLine();
        if (firstName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterLastName() {
        System.out.println("Введите фамилию:");
        lastName = sc.nextLine();
        if (lastName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterPatronymic() {
        System.out.println("Введите отчетсво: ");
        patronymic = sc.nextLine();
        if (patronymic.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterBirthday() {
        System.out.println("Введите дату рождения:");
        birthday = sc.nextLine();
        if (birthday.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterPhone() {
        try {
            System.out.println("Введите номер телефона:");
            String number = sc.nextLine();
            if (number.equals("")) {
                throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
            }
            phone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Не верный формат, попробуйте снова!");
        }
    }

    private void EnterGender() {
        System.out.println("Введите пол (f, m):");
        String gen;
        String f = "f";
        String m = "m";
        gen = sc.nextLine();
        if (gen.length() > 1) {
            throw new RuntimeException("Вы ввели слишком много символов \nпопробуйте снова!");
        }
        if (gen.equals(f) || gen.equals(m)) {
            gender = gen.charAt(0);
        } else {
            throw new RuntimeException("Вы ввели не тот символ!");

        }
    }

    private void OutPutData() {
        System.out.println("\nFirstNaame \t- \t" + firstName + "\n" +
                "LastName \t- \t" + lastName + "\n" +
                "Patronymic \t- \t" + patronymic + "\n" +
                "Birthday \t- \t" + birthday + "\n" +
                "NumberPhone \t- \t" + phone + "\n" +
                "Gender   \t- \t" + gender);
    }

    private void DataEnter() {
        EnterFirstName();
        EnterLastName();
        EnterPatronymic();
        EnterBirthday();
        EnterPhone();
        EnterGender();
        OutPutData();
    }


    public void Save() {

        DataEnter();
        String file = "C:\\Users\\Олег\\Desktop\\Исключения дз\\lesson3\\hw3\\src\\main\\java\\org\\example" + lastName + ".txt";
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("<" + firstName + "> " +
                    "<" + lastName + "> " +
                    "<" + patronymic + "> " +
                    "<" + birthday + "> " +
                    "<" + phone + "> " +
                    "<" + gender + ">\n");
        } catch (Exception e) {
            System.out.println("Ошибка!");
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public long getNumberPhone() {
        return phone;
    }

    public char getGender() {
        return gender;
    }


}
