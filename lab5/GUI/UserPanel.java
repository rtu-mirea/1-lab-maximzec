package GUI;

import javax.swing.*;

public class UserPanel {

    private JFrame jFrame;
    private JButton istrumentButton , orderButton , processButton , exitButton;
    public UserPanel(String userName){

    jFrame = new JFrame("Добро пожаловать" + userName);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane() , BoxLayout.Y_AXIS));

    istrumentButton = new JButton("1.Добавить инструмент");
        jFrame.add(istrumentButton);

    orderButton = new JButton("2.Добавить заказ");
        jFrame.add(orderButton);

    processButton = new JButton("3.Получить оптимальный план работ");
        jFrame.add(processButton);


    exitButton = new JButton("4.Выход");
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
