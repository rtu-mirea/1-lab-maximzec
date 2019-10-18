package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    System.out.print("Введите длину массива:");
	    int n = in.nextInt();
	    boolean flag = true;
	    int[] array = new int[n];
	    System.out.print("1.Ввести массив с помощью чисел"+
        "\n2.С помощью рандомных чисел"+"\n");
	    int choice = in.nextInt();
	    switch (choice)
        {
            case 1:
                ArrayHandler.fromKeyboard(array);
                break;
            case 2:
                ArrayHandler.fromRandom(array);
                break;
            default:
                ArrayHandler.fromRandom(array);
                break;
        }

        System.out.print("1.Вывести полученный массив слева направо"+
        "\n2.Вывести массив справа налево"+
                "\n3.Вывести массив из чисел , в которых первая цифра больше последней"+
                "\n4.Вывести количество чисел массива , у которых сумма цифр больше заданного значения"+"\n");
	    choice = in.nextInt();
	    switch (choice)
        {
            case 1:
                ArrayHandler.printFromLeft(array);
                break;
            case 2:
                ArrayHandler.printFromRight(array);
                break;
            case 3:
                System.out.print(Arrays.toString(ArrayHandler.newArray(array)));
                break;
            case 4:
                System.out.print("Введите значение:");
                System.out.print(ArrayHandler.moreThanValue(in.nextInt() , array));
                break;
        }

    }



}
