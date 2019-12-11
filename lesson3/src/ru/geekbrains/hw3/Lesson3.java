// 1. Полностью разобраться с кодом;
// 2. Переделать проверку победы, чтобы она не была реализована просто набором условий.
// 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
// 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока, и пытаться выиграть сам.

package ru.geekbrains.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static void initField() {
        fieldSizeY = 3;
        fieldSizeX = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
        }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите, пожалуйста, координаты X от 1 до 3 и Y от 1 до 3 через пробел");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    private static boolean checkWin(char c) {
        int horizontal = 0;
        int diagonal = 0;
        int valueWin = fieldSizeX;
        int diagonalReverse = valueWin;
        int diagonalReverseValue = 0;
        ArrayList<Integer> valueY = new ArrayList<Integer>();       //списочный массив для проверки победы по горизонтали
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == c) {
                    horizontal++;
                    valueY.add(j);
                    if (horizontal == valueWin) {
                        return true;
                    }else if (i == j) {
                        diagonal++;
                        diagonalReverse--;
                        diagonalReverseValue++;
                        if (diagonal == valueWin) {
                            return true; }
                    }else if (j == diagonalReverse - 1) {
                        diagonalReverse--;
                        diagonalReverseValue++;
                        if (diagonalReverseValue == valueWin) {
                            return true; }
                    }
                }
            }
            horizontal = 0;
        }
        Collections.sort(valueY);
        if (valueY.size() != 0) {
            int countInt = 0;
            for (int g = 0; g < (valueY.size() - 1); g++) {
                if (valueY.get(g).intValue() == valueY.get(g + 1).intValue()) {
                    countInt++;
                    int valueYSize = valueY.size();
                    int valueIf = valueYSize - (g + 2);
                    if (valueIf == 0) {
                        countInt++;
                    }
                } else {countInt = 0;}
            }
            if (countInt == valueWin) {
                return true;
            } else { return false; }
        } else { return false; }
    }

    private static boolean checkWin2(char c) {
        int horizontal = 0;
        int diagonal = 0;
        int diagonalRight = 0;
        int diagonalBelow = 0;
        int valueWin = fieldSizeX - 1;
        int diagonalReverse = valueWin;
        int diagonalReverseLeft = valueWin;
        int diagonalReverseBelow = valueWin;
        int diagonalReverseValueLeft = 0;
        int diagonalReverseValueBelow = 0;
        int diagonalReverseValue = 0;
        ArrayList<Integer> valueY = new ArrayList<Integer>();       //списочный массив для проверки победы по горизонтали
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == c) {
                    horizontal++;
                    valueY.add(j);
                    if (horizontal == valueWin) {
                        return true;
                    }else if (j == diagonalReverseBelow && i + 1 == j) {
                        diagonalReverseBelow--;
                        diagonalReverseValueBelow++;
                        diagonalRight++;
                    }else if (j == (diagonalReverseLeft - 1) && i + 1 == j) {
                        diagonalReverseLeft--;
                        diagonalReverseValueLeft++;
                        diagonalRight++;
                    }else if (j == diagonalReverseBelow && i == j + 1) {
                        diagonalReverseBelow--;
                        diagonalReverseValueBelow++;
                        diagonalBelow++;
                    }else if (j == diagonalReverseLeft - 1 && i == j + 1) {
                        diagonalReverseLeft--;
                        diagonalReverseValueLeft++;
                        diagonalBelow++;
                    }else if (i == j) {
                        diagonal++;
                        diagonalReverse--;
                        diagonalReverseValue++;
                        if (diagonal == valueWin) {
                            return true; }
                    }else if (i + 1 == j) {
                        diagonalRight++;
                        if (diagonalRight == valueWin) {
                            return true; }
                    }else if (i == j + 1) {
                        diagonalBelow++;
                        if (diagonalBelow == valueWin) {
                            return true;
                        }
                    }else if (j == diagonalReverseLeft - 1) {
                        diagonalReverseLeft--;
                        diagonalReverseValueLeft++;
                        if (diagonalReverseValueLeft == valueWin) {
                            return true; }
                    }else if (j == diagonalReverseBelow) {
                        diagonalReverseBelow--;
                        diagonalReverseValueBelow++;
                        if (diagonalReverseValueBelow == valueWin) {
                            return true; }
                    }else if (j == diagonalReverse) {
                        diagonalReverse--;
                        diagonalReverseValue++;
                        if (diagonalReverseValue == valueWin) {
                            return true; }
                    }
                }
            }
            horizontal = 0;
        }
        Collections.sort(valueY);
        if (valueY.size() != 0) {
            int countInt = 0;
            for (int g = 0; g < (valueY.size() - 1); g++) {
                if (valueY.get(g).intValue() == valueY.get(g + 1).intValue()) {
                    countInt++;
                    int valueYSize = valueY.size();
                    int valueIf = valueYSize - (g + 2);
                    if (valueIf == 0) {
                        countInt++;
                    }
                } else {countInt = 0;}
            }
            if (countInt == valueWin) {
                return true;
            } else { return false; }
        } else { return false; }
    }

    private static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initField();
        printField();
        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Human win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI)) {
                System.out.println("Computer win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}
