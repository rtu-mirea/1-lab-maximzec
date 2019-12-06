package GUI;

import javax.swing.*;

public class EnterWindow {

    private JFrame jFrame;
    private JLabel userNameLabel , passwordLabel;
    private JTextField userNameTF , passwordTF;
    private JButton enterButton;

    public EnterWindow(){
        jFrame = new JFrame("Вход в систему");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane() , BoxLayout.Y_AXIS));

        userNameLabel = new JLabel("Введите имя пользователя");
        jFrame.add(userNameLabel);

        userNameTF = new JTextField();
        jFrame.add(userNameTF);

        passwordLabel = new JLabel("Введите пароль");
        jFrame.add(passwordLabel);

        passwordTF = new JTextField();
        jFrame.add(passwordTF);

        enterButton = new JButton("Войти");
        jFrame.add(enterButton);

        jFrame.pack();


    }

    public JTextField getUserNameTF() {
        return userNameTF;
    }

    public JTextField getPasswordTF() {
        return passwordTF;
    }

    public JButton getEnterButton() {
        return enterButton;
    }


    public void run(){
        this.jFrame.setVisible(true);
    }

    public void stop(){
        this.jFrame.setVisible(false);
    }

}
