//Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.

package ru.geekbrains.hw5;

public abstract class Animal {

    String name;
    private String breed;
    private int age;

    public Animal(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public abstract void run(int length);

    public abstract void jump(float height);
}
