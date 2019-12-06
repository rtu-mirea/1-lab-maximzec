package GUI;

import javax.swing.*;

public class RegistrationWindow {
    private JFrame jFrame;
    private JLabel nameLabel , loginLabel , passwordLabel , repeatLabel , errorLabel;
    private JTextField nameTF , loginTF , passwordTF , repeatTF;
    private JButton addButton , exitButton;



    public RegistrationWindow(){
        jFrame = new JFrame("Регистрация пользователя");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane() , BoxLayout.Y_AXIS));

        nameLabel = new JLabel("Введите имя");
        jFrame.add(nameLabel);

        nameTF = new JTextField();
        jFrame.add(nameTF);

        loginLabel = new JLabel("Введите логин");
        jFrame.add(loginLabel);

        loginTF = new JTextField();
        jFrame.add(loginTF);

        passwordLabel = new JLabel("Введите пароль");
        jFrame.add(passwordLabel);

        passwordTF = new JTextField();
        jFrame.add(passwordTF);

        repeatLabel = new JLabel("Повторите пароль");
        jFrame.add(repeatLabel);

        repeatTF = new JTextField();
        jFrame.add(repeatTF);

        addButton = new JButton("Добавить пользователя");
        jFrame.add(addButton);

        exitButton = new JButton("Назад");
        jFrame.add(exitButton);

        errorLabel = new JLabel();
        jFrame.add(errorLabel);

        jFrame.pack();
    }


    public JTextField getNameTF() {
        return nameTF;
    }

    public JTextField getLoginTF() {
        return loginTF;
    }

    public JTextField getPasswordTF() {
        return passwordTF;
    }

    public JTextField getRepeatTF() {
        return repeatTF;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void run(){
        this.jFrame.setVisible(true);
    }

    public void stop(){
        this.jFrame.setVisible(false);
    }
}
