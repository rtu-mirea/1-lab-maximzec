package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
	// упражнение 1
        File f1 = new File("MyFile1.txt");
        f1.createNewFile();
        f1.deleteOnExit();
        boolean b = f1.exists();
        if (b) {
            System.out.println("1 exists");
        }


        File f2 = new File("D:\\MyFile2.txt");
        f2.createNewFile();
        f2.deleteOnExit();
        b = f2.exists();
        if (b) {
            System.out.println("2 exists");
        }

        File f3 = new File("C:\\Users\\User\\IdeaProjects\\lab4_1\\MyFile3.txt");
        f3.createNewFile();
        f3.deleteOnExit();
        b = f3.exists();
        if (b) {
            System.out.println("3 exists");
        }

        File f4 = new File("package\\package2\\package3");
        f4.mkdirs();
        b = f4.exists();
        if (b) {
            System.out.println("4 exists");
        }


        //упражнение 2
        if (b) {
                    System.out.println("1 exists");
                }
        if (f1.isFile()) {
            System.out.println("File "+f1.getName() + " in " + f1.getAbsolutePath().substring(0,f1.getAbsolutePath().lastIndexOf('\\')));
        }

        System.out.println( f3.getName() + " - " + f3.length() + " bytes");


        //упражнение 3
        File newFile = new File("C:\\Users\\User\\IdeaProjects\\lab4_1\\nPackage");
        newFile.mkdir();
        newFile.deleteOnExit();
        System.out.println( newFile.getParentFile().getName() + ":");
        for (String file: Objects.requireNonNull(newFile.getParentFile().list())) {
            System.out.println(file);
        }

        System.out.println(newFile.getParentFile().getName() + ":");
        int count = 0;
        for (File file: Objects.requireNonNull(newFile.getParentFile().listFiles())) {
            System.out.println(file.getName());
            if (file.isDirectory()) {count++;}
        }

        System.out.println(count);

    }
}
