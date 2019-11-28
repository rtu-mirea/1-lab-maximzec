package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
            Scanner in = new Scanner(System.in);
            List<SimpleObject> simpleObjects = new ArrayList<>();
	        int choice = -1;
	        while(choice != 3){
	            System.out.println("Что хотите сделать?");
	            System.out.println("1.Ввести объекты в файл");
	            System.out.println("2.Вывести объекты из файла и напечатать");
	            System.out.println("3.Выход");
	            choice = in.nextInt();

	            switch (choice){
                    case 1:{
                        System.out.println("Введите строку:");
                        String s = in.next();
                        System.out.println("Введите число: ");
                        int a = in.nextInt();
                        SimpleObject simpleObject = new SimpleObject(s,a);

                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("ClassTextFile"));
                        os.writeObject(simpleObject);
                        break;
                    }
                    case 2:{
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ClassTextFile"));
                        while(true){
                            try {
                                simpleObjects.add((SimpleObject)ois.readObject());
                            } catch (ClassNotFoundException | IOException e){
                                break;
                            }
                        }
                        System.out.println(Arrays.toString(simpleObjects.toArray()));
                        break;
                    }
                    case 3:{
                        System.exit(0);
                    }
                }
            }
    }
}
