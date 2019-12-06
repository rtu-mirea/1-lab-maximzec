package GUI;

import javax.swing.*;

public class AdminPanel {
    private JFrame jFrame;
    private JButton istrumentButton , orderButton , processButton
            , registrButton , exitButton;

    public AdminPanel(){
        jFrame = new JFrame("Панель администратора");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane() , BoxLayout.Y_AXIS));

        istrumentButton = new JButton("1.Добавить инструмент");
        jFrame.add(istrumentButton);

        orderButton = new JButton("2.Добавить заказ");
        jFrame.add(orderButton);

        processButton = new JButton("3.Получить оптимальный план работ");
        jFrame.add(processButton);

        registrButton = new JButton("4.Зарегистрировать пользователя");
        jFrame.add(registrButton);

        exitButton = new JButton("5.Выход");
        jFrame.add(exitButton);

        jFrame.pack();

    }

    public JButton getIstrumentButton() {
        return istrumentButton;
    }

    public JButton getOrderButton() {
        return orderButton;
    }

    public JButton getProcessButton() {
        return processButton;
    }

    public JButton getRegistrButton() {
        return registrButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void run(){
        jFrame.setVisible(true);
    }

    public void stop(){
        jFrame.setVisible(false);
    }

}
