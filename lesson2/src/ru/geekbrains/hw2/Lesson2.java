//1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
//2 Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
//3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
//4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
//5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);
//6 ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 1, 2, 3, 4]) → true. Абстрактная граница показана символами ||, эти символы в массив не входят.
//7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен циклически сместить все элементы массива на n позиций.
//8 **** Не пользоваться вспомогательным массивом при решении задачи 7.

package ru.geekbrains.hw2;

import java.util.Arrays;

public class Lesson2 {

    private static int[] changeNum(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                a[i] = 0;
            } else {
                a[i] = 1;
            }
        } return a;
    }

    private static int[] fillArray (int[] a) {
        for (int i = 1; i < a.length; i++) {
            a[0] = 1;
            a[i] = a[i-1] + 3;
        } return a;
    }

    private static int[] multiplicNum (int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < 6) {
                a[i] *= 2;
            }
        } return a;
    }

    private static int maxInt (int[] a) {
        int[] b = a.clone();
        Arrays.sort(b);
        return b[b.length - 1];
    }

    private static int minInt (int[] a) {
        int[] b = a.clone();
        Arrays.sort(b);
        return b[0];
    }

    public static void main(String[] args) {
        int[] arrayOne = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] arrayTwo = new int[8];
        int[] arrayThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(changeNum(arrayOne)));
        System.out.println(Arrays.toString(fillArray(arrayTwo)));
        System.out.println(Arrays.toString(multiplicNum(arrayThree)));
        System.out.println(maxInt(arrayThree));
        System.out.println(minInt(arrayThree));

        int[][] qArray = new int[5][5];
        for (int i = 0; i < qArray.length; i++) {
            for (int j = 0; j < qArray.length; j++) {
                if (i == j) {
                    qArray[i][j] = 1;
                } qArray[i][qArray.length - 1 - i] = 1;
                System.out.print(qArray[i][j] + "\t");
            }System.out.println();
        }
    }



}
