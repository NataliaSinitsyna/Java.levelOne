//Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой, где a, b, c, d – целочисленные входные параметры этого метода;
//Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
//Написать метод, которому в качестве параметра передается целое число, метод должен проверить положительное ли число передали, или отрицательное. Замечание: ноль считаем положительным числом. Результат работы метода вывести в консоль
//Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вернуть приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль.
//*Написать метод, который определяет является ли год високосным. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный. Для проверки работы вывести результаты работы метода в консоль

package ru.geekbrains.hw1;

public class Lesson1 {

    public static void main(String[] args) {
        System.out.println(culculate(5, 7, 4, 3));
        System.out.println(culculate(5,3, 2, 0));
        System.out.println(range(10, 5));
        System.out.println(range(5, 2));
        System.out.println(positiveNumber(5));
        System.out.println(positiveNumber(-5));
        System.out.println(greeting("User"));
        System.out.println(yearVis(2020));
        System.out.println(yearVis(2021));

    }

    private static String culculate (int a, int b, int c, int d) {
        float af = a;
        float bf = b;
        float cf = c;
        float df = d;
        if (d != 0) {
            return "результат: " + Float.toString(af * (bf + (cf / df)));
        } else {
            return "на ноль делить нельзя";
        }
    }

    private static boolean range (int a, int b) {
        if (10 <= a + b && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    private static String positiveNumber (int a) {
        if (a >= 0) {
            return "Число " + a + " положительное";
        } else {
            return "Число " + a + " отрицательное";
        }
    }

    private static String greeting (String name) {
        return "Привет, " + name + "!";
    }

    private static String yearVis (int year) {
        if (year % 4 == 0 || year % 100 != 0 && year % 400 == 0) {
            return year + " год является високосным";
        } else {
            return year + " год не является високосным";
        }
    }
}
