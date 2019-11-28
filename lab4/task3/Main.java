package com.company;

import java.io.*;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws IOException {
        Task1();
        Task2();
        Task3();
    }


    public static void Task1() throws IOException {
        FileReader fl = new FileReader("C:\\Users\\User\\IdeaProjects\\lab4_3\\txt1");
        FileWriter fw = new FileWriter("C:\\Users\\User\\IdeaProjects\\lab4_3\\txt2");
        int jchar = 0;
        while((jchar = fl.read()) != -1){
            fw.write((char)jchar);
        }

        fl.close();
        fw.close();
    }

    public static void Task2() throws IOException {
        BufferedReader inb = new BufferedReader(new FileReader("A"),128);
        BufferedWriter oub = new BufferedWriter(new FileWriter("B"), 128);
        char [] buf = new char[128];
        int x;
        while ((x = inb.read(buf))!=-1) {
            oub.write(buf);
            oub.write(10);
        }
        inb.close();
        oub.close();

    }


    public static void Task3() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("a"), "Cp1251"));
            System.out.println(Charset.defaultCharset().name());
            String a;
            while ((a = in.readLine()) != null) {
                System.out.println(a);
            }
            in.close();

    }

}
