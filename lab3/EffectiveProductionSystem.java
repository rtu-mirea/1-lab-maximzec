package com.company;

import java.util.*;

public class EffectiveProductionSystem {

    private  List<User> users = new ArrayList<>();
    private  List<Request> requests = new ArrayList<>();
    private  List<Instrument> instruments = new ArrayList<>();
    private  User currentUser;

    public void main(String[] args) throws Exception {
        addUser("Admin" , "Admin " , "Admin" , "Admin" ,0);
        int choice = -1;
        while (choice != 3)
        {
            System.out.println("Добро пожаловать!");
            System.out.println("Выберите действие:");
            System.out.println("1. Войти в систему");
            System.out.println("2. Выход.");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    signIn();
                    if(currentUser == null)
                        continue;
                    getMenu(this.currentUser);
                    break;
                default:
                    continue;
            }
            currentUser = null;

        }

    }

    private void addUser(String name , String login ,String password, String repeation , int type) throws Exception {
        if(!password.equals(repeation)) throw new Exception("Пароли не совпадают");
        for(User user : this.users){
            if(user.enter(login , password)) throw new Exception("Такой пользователь уже существует");
        }

        switch(type){
            case 0: this.users.add(new Admin(name , login , password));break;
            case 1: this.users.add(new Client(name , login ,password));break;
        }
    }

    private User findUser(String login , String password) throws Exception{
        for(User user : this.users){
            if (user.enter(login , password)) return user;
        }
        throw new Exception("Пользователь не найден");
    }

    private void signIn(){
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

    private void signUp(){
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

    private void processRequests(){

        requests.sort(new Comparator<Request>() {
            @Override
            public int compare(Request o1, Request o2) {
                return o1.getAverallTime() > o2.getAverallTime() ? 1:0;
            }
        });
    }



     private void orderInterface(){
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
                this.requests.add(request);
            }
        }
    }

     private void instrumentInterface(){
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
                this.instruments.add(new Instrument(name , count));
            }
        }
    }

     private void planInterface(){
        this.processRequests();
        for (Request request : this.requests){
            System.out.println(request);
        }

    }

    private void getMenu(User currentUser){
        Scanner in = new Scanner(System.in);
        int choice = -1;
        if(currentUser instanceof Admin){
        while (choice!=4){
            System.out.println("1.Добавить оборудование");
            System.out.println("2.Прием заказов");
            System.out.println("3.Получение плана оптимального выполнения работ");
            System.out.println("4.Зарегистрировать нового пользователя");
            System.out.println("5.Выход");
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
                case 4:{
                    this.signUp();
                    break;
                }
                default:continue;
            }
        }
      }else{
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
