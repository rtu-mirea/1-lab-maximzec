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
               myStringUsing su = new myStringUsing(splitted);
                System.out.print("Исправленные записи в контактах:");
                System.out.print(Arrays.deepToString(su.surnameToLowCase())+"\n");
                System.out.print("Введите поставщика услуг: ");

                String email = in.nextLine();
                System.out.print("Список контактов по поставщику услуг: ");
                System.out.print(su.getContactsByEmail(email) + "\n");
                System.out.print("Количество адресов на com" + su.getComCount() + "\n");
                System.out.print("Введите первый символ фамилии: ");
                String a = in.nextLine();
                System.out.print("Массив фамилий на эту букву: " + Arrays.deepToString(su.getSurnameByChar(a.charAt(0))));
                break;
            }
            case 2:{
                in.nextLine();
                myStringBufferUsing ms = new myStringBufferUsing(new StringBuffer(text));
                System.out.print("Добавьте новый контакт: ");
                String input = in.nextLine();
                ms.addNewContact(input);
                ms.repairContacts();
                ms.insertCountToBegin();
                System.out.print(ms.getStringBuffer());
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

