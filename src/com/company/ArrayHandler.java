package com.company;

import java.util.Scanner;

public class ArrayHandler {

    public static void fromKeyboard(int[] array){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < array.length ; i++) {
            array[i] = in.nextInt();
        }
    }

    public static void fromRandom(int[] array){
        for (int i = 0; i < array.length ; i++) {
            array[i] = (int)(Math.random()*100);
        }
    }

    public static void printFromLeft(int[] array){
        for (int i : array) System.out.print(i + ",");
    }

    public static void printFromRight(int[] array){
        for(int i = array.length - 1 ; i>0 ; i--)
        {
            System.out.print(array[i] + ",");
        }
    }

    public static int[] newArray(int[] array){
        int[] mass = new int[array.length];
        for (int i = 0; i < array.length ; i++) {
            if(firstDigit(array[i]) > array[i] % 10 ){
                mass[i] = array[i];
            }
        }
        return mass;
    }


    public static int moreThanValue(int value , int[] array){
        int count = 0;
        for(int i : array){
            if(sumDigits(i) > value) count++;
        }
        return count;
    }

    ///heplers
    public static int firstDigit(int x) {
        if (x == 0) return 0;
        x = Math.abs(x);
        return (int) Math.floor(x / Math.pow(10, Math.floor(Math.log10(x))));
    }

    public static int sumDigits(int num){
        int sum = 0;
        while(num!=0)
        {
            sum += (num % 10);
            num/=10;
        }
        return sum;
    }
}
