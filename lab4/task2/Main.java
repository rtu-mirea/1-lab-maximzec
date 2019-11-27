package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        int choice = -1;
        Scanner in = new Scanner(System.in);
        String fileName;
        FileManager fileManager;

        System.out.println("Введите имя файла , куда будем записывать: ");
        fileName = in.next();
        fileManager = new FileManager(fileName);
        List<Doll> dolls = new ArrayList<>();
        while(choice != 4){
            System.out.println("1.Добавление в список кукол");
            System.out.println("2.Чтение списка из файла");
            System.out.println("3.Работа с произвольным доступом");
            System.out.println("4.Выход");
            System.out.println("Ваш выбор : ");
            choice = in.nextInt();
            System.out.println();
            switch (choice){
                case 1:{

                    if(fileManager.isFileExists()) {
                        System.out.println("Файл существует");
                        for (int i = 0; i < 2; i++) {
                            String producer;
                            int price, startAge, endAge;
                            System.out.println("Введите производителя куклы: ");
                            producer = in.next();
                            System.out.println("Введите цену куклы: ");
                            price = in.nextInt();
                            System.out.println("Введите стартовый возраст игрушки: ");
                            startAge = in.nextInt();
                            System.out.println("Введите конечный возраст игрушки");
                            endAge = in.nextInt();
                            fileManager.write(new Doll(producer, price, startAge, endAge));
                            dolls.add(new Doll(producer,price,startAge,endAge));
                        }
                    }else {
                        System.out.println("Файл не существует");
                    }
                    break;
                }
                case 2:{
                    String producer;
                    System.out.println("Введите имя производителя: ");
                    producer = in.nextLine();
                    fileManager.read(dolls , producer);
                    System.out.println(Arrays.deepToString(dolls.toArray()));
                    break;

                }
                case 3:{
                    fileManager.randomAccess(dolls);
                    break;
                }
            }
        }
    }


}
