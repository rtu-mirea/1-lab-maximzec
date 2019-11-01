package com.company;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String text = "Иванов И.И.,xxxxx@gmail.com.\n"+
                      "Иванор И.И.,xxxxx@gmail.com.\n"+
                      "Лванов И.И.,xxxxx@mail.ru.\n"+
                      "Иванок И.И.,xxxxx@mail.ru.\n";
        String[] splitted = text.split("\n");
        System.out.print("Исправленные записи в контактах:");
        System.out.print(Arrays.deepToString(surnameToLowCase(splitted))+"\n");
        System.out.print("Введите поставщика услуг: ");
        Scanner in = new Scanner(System.in);
        String email = in.nextLine();
        System.out.print("Список контактов по поставщику услуг: ");
        System.out.print(getContactsByEmail(splitted, email) + "\n");
        System.out.print("Количество адресов на com" + getComCount(splitted) + "\n");
        System.out.print("Введите первый символ фамилии: ");
        String a = in.nextLine();
        System.out.print("Массив фамилий на эту букву: " + Arrays.deepToString(getSurnameByChar(splitted , a.charAt(0))));
    }

    public static String[] surnameToLowCase(String[] strings){
        String[] _strings = new String[strings.length];
        for (int i = 0; i < strings.length ; i++) {
            int index = strings[i].indexOf(',');
            _strings[i] = strings[i].substring(0,index - 1).toLowerCase() + ',' + strings[i].substring(index+1);
        }
        return _strings;
    }

    public static String[] getSurnameByChar(String[] strings , char a){
        int charCount = 0;
        for (int i = 0; i < strings.length; i++) if(strings[i].charAt(0) == a) charCount++;
        String[] _strings = new String[charCount];
        for (int i = 0; i < strings.length ; i++) {
            if(strings[i].charAt(0) == a ) {
                int index = strings[i].indexOf(' ');
                _strings[charCount-1] = strings[i].substring(0 , index);
                --charCount;
            }
        }
        return _strings;
    }

    public static String getContactsByEmail(String[] strings , String email){
        String[] _strings = new String[strings.length];
        String result = "";
        for (int i = 0; i < strings.length ; ++i) {
            _strings[i] = strings[i].substring(strings[i].indexOf(',')+1);
        }
        for (int i = 0; i < _strings.length ; ++i){
            int eIndex = _strings[i].indexOf('@');
            int dIndex = _strings[i].indexOf('.');
            if(_strings[i].substring(eIndex+1 , dIndex).equals(email)){
                result = result.concat(strings[i] + " ");
            }
        }
        return result;
    }

    public static int getComCount(String[] strings){
        String[] _strings = new String[strings.length];
        int result = 0;
        for (int i = 0; i < strings.length ; ++i) {
            _strings[i] = strings[i].substring(strings[i].indexOf(',')+1);
        }

        for (int i = 0; i < _strings.length ; i++) {
            int eIndex = _strings[i].indexOf('.');
            int endIndex = _strings[i].length() - 1;
                if(_strings[i].substring(eIndex+1 , endIndex).equals("com")) ++result;
            }
        return result;
        }
}

