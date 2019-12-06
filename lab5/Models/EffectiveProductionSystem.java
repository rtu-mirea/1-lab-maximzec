package Models;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import GUI.*;

public class EffectiveProductionSystem {


    EnterWindow enterWindow;
    InstrumentWindow instrumentWindow;
    OrderWindow orderWindow;
    RegistrationWindow registrationWindow;
    AdminPanel adminPanel;
    UserPanel userPanel;
    ProcessWindow processWindow;

    private List<User> users = new ArrayList<>();
    private  List<Request> requests = new ArrayList<>();
    private  List<Instrument> instruments = new ArrayList<>();
    private  User currentUser;


    public void main() throws Exception {
        addUser("Admin" , "Admin" , "Admin" , "Admin" ,0);


        enterWindow = new EnterWindow();
        orderWindow = new OrderWindow();
        instrumentWindow = new InstrumentWindow();
        registrationWindow = new RegistrationWindow();
        adminPanel = new AdminPanel();
        userPanel = new UserPanel("");
        processWindow = new ProcessWindow();

        ///старт
        enterWindow.run();
        enterWindow.getEnterButton().addActionListener(v -> {
            currentUser = findUser(enterWindow.getUserNameTF().getText() , enterWindow.getPasswordTF().getText());
            if(currentUser != null){

                if(currentUser instanceof Admin){
                    adminPanel.run();
                }else {
                    userPanel.run();
                }
                enterWindow.stop();
            }
        });
        ///
        ///Окно пользователя
        userPanel.getExitButton().addActionListener(v ->{
            currentUser = null;
            userPanel.stop();
            enterWindow.run();
        });

        userPanel.getIstrumentButton().addActionListener(v -> {
            userPanel.stop();
            instrumentWindow.run();
        });

        userPanel.getOrderButton().addActionListener(v->{
            userPanel.stop();
            orderWindow.run();
        });

        userPanel.getProcessButton().addActionListener(v->{
            processRequests();
            StringBuilder result = new StringBuilder();
            for(Request request : requests){
                result.append(request.toString()).append("\n");
            }
            processWindow.setResult(result.toString());
            userPanel.stop();
            processWindow.run();
        });
        ///

        ///Окно админа
        adminPanel.getRegistrButton().addActionListener(v -> {
            adminPanel.stop();
            registrationWindow.run();
        });

        adminPanel.getIstrumentButton().addActionListener(v -> {
            adminPanel.stop();
            instrumentWindow.run();
        });

        adminPanel.getOrderButton().addActionListener(v -> {
            adminPanel.stop();
            orderWindow.run();
        });

        adminPanel.getProcessButton().addActionListener(v ->{
            processRequests();
            StringBuilder result = new StringBuilder();
            for(Request request : requests){
                result.append(request.toString()).append("\n");
            }
            processWindow.setResult(result.toString());
            adminPanel.stop();
            processWindow.run();

        });
        adminPanel.getExitButton().addActionListener(v -> {
            currentUser = null;
            adminPanel.stop();
            enterWindow.run();
        });
        ///

        ///Окно регистрации
        registrationWindow.getExitButton().addActionListener(v -> {
            registrationWindow.stop();
            if(currentUser instanceof Admin){
                adminPanel.run();
            }
            else{
                userPanel.run();
            }
        });

        registrationWindow.getAddButton().addActionListener(v -> {
            String name = registrationWindow.getNameTF().getText();
            String login = registrationWindow.getLoginTF().getText();
            String password = registrationWindow.getPasswordTF().getText();
            String repeation = registrationWindow.getRepeatTF().getText();

            try {
                addUser(name , login , password , repeation , 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        ///

        ///Окно добавления инструмента
        instrumentWindow.getExitButton().addActionListener(v -> {
            instrumentWindow.stop();
            if(currentUser instanceof Admin){
                adminPanel.run();
            }
            else{
                userPanel.run();
            }
        });

        instrumentWindow.getAddButton().addActionListener(v -> {
            String name = instrumentWindow.getNameTF().getText();
            String count = instrumentWindow.getCountTF().getText();
            instruments.add(new Instrument(name , Integer.parseInt(count)));

        });
        ///

        ///Окно добавления заказа
        orderWindow.getExitButton().addActionListener(v->{
            orderWindow.stop();
            if(currentUser instanceof Admin){
                adminPanel.run();
            }
            else{
                userPanel.run();
            }
        });

        orderWindow.getAddReqPartButton().addActionListener(v->{
            String name = orderWindow.getInstrumentTF().getText();
            String count = orderWindow.getCountTF().getText();
            String time = orderWindow.getTimeTF().getText();
            requests.get(requests.size() - 1).addPart(new Instrument(name , Integer.parseInt(count)), Integer.parseInt(time));
        });

        orderWindow.getAddRequestButton().addActionListener(v -> {
            requests.add(new Request());
        });
        ///

        ///Окно получения оптимального плана работ
        processWindow.getExitButton().addActionListener(v->{
            processWindow.stop();
            if(currentUser instanceof Admin){
                adminPanel.run();
            }
            else{
                userPanel.run();
            }
        });
        ///

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

    private User findUser(String login , String password){
        for(User user : this.users){
            if (user.enter(login , password)) return user;
        }
        return null;
    }

    /*
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
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    */
    private void processRequests(){

        requests.sort(new Comparator<Request>() {
            @Override
            public int compare(Request o1, Request o2) {
                return o1.getAverallTime() > o2.getAverallTime() ? 1:0;
            }
        });
    }








}