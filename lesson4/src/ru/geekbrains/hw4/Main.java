//Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
//Конструктор класса должен заполнять эти поля при создании объекта;
//Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
//Вывести при помощи методов из пункта 3 ФИО и должность.
//Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
//* Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
//*** Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный уникальный идентификационный порядковый номер

package ru.geekbrains.hw4;

public class Main {

    public static int increaseSalary(int age, int salary) {
        if (age > 45) {
            return salary = salary + 5000;
        } else {
            return salary;
        }
    }

    public static void main(String[] args) {

        Worker human = new Worker();
        human.visualFio();
        human.visualPosition();

        Worker[] people = new Worker[5];
        for (int i = 0; i < people.length; i++) {
            people[i] = new Worker();
        }

        for (int i = 0; i < people.length; i++) {
            if (people[i].age > 40) {
                System.out.println("ФИО: " + people[i].fio + "\t" + "Должность: " + people[i].position + "\t" + "Номер телефона: " + people[i].tel + "\t" + "Зарплата: " + people[i].salary + "\t" + "Возраст: " + people[i].age);123
                System.out.println(increaseSalary(people[i].age, people[i].salary));
            }
        }

    }
}