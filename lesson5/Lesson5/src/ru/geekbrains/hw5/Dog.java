//Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.

package ru.geekbrains.hw5;

public class Dog extends Animal {

    private final int lengthRun = 500;
    private final float heightJump = 0.5f;
    private final int lengthSwim = 10;
    public Dog(String name, String breed, int age) { super(name, breed, age); }

    @Override
    public void run(int length, int age){
        if (length < lengthRun) {
            System.out.println(name + " пробежал!");
        } else {
            System.out.println(name + " не пробежал!");
        }
    }

    @Override
    public void jump(float height){
        if (height < heightJump) {
            System.out.println(name + " перепрыгнул!");
        } else {
            System.out.println(name + " не перепрыгнул!");
        }
    }

    public void swim(int length){
        if (length < lengthSwim) {
            System.out.println(name + " переплыл!");
        } else {
            System.out.println(name + " не переплыл!");
        }
    }
}
