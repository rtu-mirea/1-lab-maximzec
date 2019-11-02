package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String text = "Иванов И.И.,xxxxx@gmail.com.\n"+
                      "Иванор И.И.,xxxxx@gmail.com.\n"+
                      "Лванов И.И.,xxxxx@mail.ru.\n"+
                      "Иванок И.И.,xxxxx@mail.ru.\n";
        String[] splitted = text.split("\n");
        System.out.print("1.Использование класса String\n" + "2.Использование класса StringBuilder\n" + "3.Использование регулярных выражений\n" + "Ваш выбор: ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice){
            case 1:{
                System.out.print("Исправленные записи в контактах:");
                System.out.print(Arrays.deepToString(myStringUsing.surnameToLowCase(splitted))+"\n");
                System.out.print("Введите поставщика услуг: ");

                String email = in.nextLine();
                System.out.print("Список контактов по поставщику услуг: ");
                System.out.print(myStringUsing.getContactsByEmail(splitted, email) + "\n");
                System.out.print("Количество адресов на com" + myStringUsing.getComCount(splitted) + "\n");
                System.out.print("Введите первый символ фамилии: ");
                String a = in.nextLine();
                System.out.print("Массив фамилий на эту букву: " + Arrays.deepToString(myStringUsing.getSurnameByChar(splitted , a.charAt(0))));
                break;
            }
            case 2:{
                in.nextLine();
                StringBuffer stringBuffer = new StringBuffer(text);

                System.out.print("Добавьте новый контакт: ");
                String input = in.nextLine();
                myStringBufferUsing.addNewContact(stringBuffer,input);
                myStringBufferUsing.repairContacts(stringBuffer);
                myStringBufferUsing.insertCountToBegin(stringBuffer);
                System.out.print(stringBuffer);
                break;
            }
            case 3:{
                in.nextLine();
                String priceText = "Цена на мешок картошки составила $2,5643663";
                System.out.print("Введите цену: ");
                String price = in.nextLine();
                if(myRegexUsing.isMatch(price)){
                    System.out.println("Подходит!");
                }else {
                    System.out.println("Не подходит");
                }
                System.out.println("Вытянули цену из текста : " + myRegexUsing.returnValue(priceText));
                break;
            }



        }

    }


}

