package com.company;

import java.util.*;

public class EffectiveProductionSystem {

    private static List<User> users = new ArrayList<>();
    private static List<Request> requests = new ArrayList<>();
    private static List<Instrument> instruments = new ArrayList<>();
    private static User currentUser;

    public static void main(String[] args) throws Exception {
        addUser("Admin" , "Admin " , "Admin" , "Admin" ,0);
        int choice = -1;
        while (choice != 3)
        {
            System.out.println("Добро пожаловать!");
            System.out.println("Выберите действие:");
            System.out.println("1. Зарегистировать нового пользователя.");
            System.out.println("2. Войти в систему.");
            System.out.println("3. Выход.");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    signUp();
                    if(currentUser == null)
                        continue;
                    getMenu();
                    break;
                case 2:
                    signIn();
                    if(currentUser == null)
                        continue;
                    getMenu();
                    break;
                default:
                    continue;
            }
            currentUser = null;

        }

    }

    private static void addUser(String name , String login ,String password, String repeation , int type) throws Exception {
        if(!password.equals(repeation)) throw new Exception("Пароли не совпадают");
        for(User user : users){
            if(user.enter(login , password)) throw new Exception("Такой пользователь уже существует");
        }

        switch(type){
            case 0: users.add(new Admin(name , login , password));break;
            case 1: users.add(new Client(name , login ,password));break;
        }
    }

    private static User findUser(String login , String password) throws Exception{
        for(User user : users){
            if (user.enter(login , password)) return user;
        }
        throw new Exception("Пользователь не найден");
    }

    private static void signIn(){
        Scanner in = new Scanner(System.in);
        try {
            String Login, Password;
            System.out.println("Введите логин:");
            Login = in.next();
            System.out.println("Введите пароль:");
            Password = in.next();
            currentUser = findUser(Login, Password);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static void signUp(){
        Scanner in = new Scanner(System.in);
        try {
            String Name, Login, Password, Repeation;
            int type;
            System.out.println("Введите имя:");
            Name = in.next();
            System.out.println("Введите логин:");
            Login = in.next();
            System.out.println("Введите пароль:");
            Password = in.next();
            System.out.println("Повторите пароль:");
            Repeation = in.next();
            type = 1;
            addUser(Name, Login, Password, Repeation, type);
            currentUser = findUser(Login,Password);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static void processRequests(){

        requests.sort(new Comparator<Request>() {
            @Override
            public int compare(Request o1, Request o2) {
                return o1.getAverallTime() > o2.getAverallTime() ? 1:0;
            }
        });
    }



    static private void orderInterface(){
        int choice = -1;
        while (choice!= 2){
            System.out.println("Заказы:");
            System.out.println("\t1.Добавить новый заказ");
            System.out.println("\t2.Выйти");
            System.out.print("\tВаш выбор:");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            if(choice == 1){
                Request request = new Request();
                while(true){
                    System.out.print("Инструмент для заказа и время работы :" );
                    String name = in.nextLine();
                    int count = in.nextInt();
                    int time = in.nextInt();
                    if(time == -1) break;

                    request.addPart(new Instrument(name , count) , time );
                }
                requests.add(request);
            }
        }
    }

    static private void instrumentInterface(){
        int choice = -1;
        while (choice!= 2){
            System.out.println("Оборудование:");
            System.out.println("\t1.Добавить новый инструмент");
            System.out.println("\t2.Выйти");
            System.out.print("\tВаш выбор:");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            if(choice == 1){
                System.out.print("Введите название и количество оборудования : ");
                String name = in.nextLine();
                int count = in.nextInt();
                for(Instrument instrument : instruments){
                    if(instrument.getName().equals(name)){
                        instrument.setCount(instrument.getCount() + count); break;
                    }
                }
                instruments.add(new Instrument(name , count));
            }
        }
    }

    static private void planInterface(){
        processRequests();
        for (Request request : requests){
            System.out.println(request);
        }

    }

    public static void getMenu(){
        Scanner in = new Scanner(System.in);
        int choice = -1;
        while (choice!=4){
            System.out.println("1.Добавить оборудование");
            System.out.println("2.Прием заказов");
            System.out.println("3.Получение плана оптимального выполнения работ");
            System.out.println("4.Выход");
            choice = in.nextInt();
            switch (choice)
            {
                case 1:{
                    instrumentInterface();
                    break;
                }
                case 2:{
                    orderInterface();
                    break;
                }
                case 3:{
                    planInterface();
                    break;
                }
                default:continue;
            }
        }
    }


}
