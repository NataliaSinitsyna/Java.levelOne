
package ru.geekbrains.hw4;

import java.util.Scanner;

public class Worker {
    String fio;
    String position;
    String tel;
    int salary;
    int age;
    Worker() {
        System.out.println("Введите Ваше ФИО");
        Scanner scan = new Scanner(System.in);
        fio = scan.nextLine();
        System.out.println("Введите Вашу должность");
        position = scan.nextLine();
        System.out.println("Введите номер телефона");
        tel = scan.nextLine();
        System.out.println("Введите Вашу зарплату");
        salary = scan.nextInt();
        System.out.println("Введите Ваш возраст");
        age = scan.nextInt();
    }


    void visualFio() { System.out.println(fio); }

    void visualPosition() { System.out.println(position); }

    void visualTel() { System.out.println(tel); }

    void visualSalary() { System.out.println(salary); }

    void visualAge() { System.out.println(age); }
}