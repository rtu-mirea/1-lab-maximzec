package GUI;

import javax.swing.*;

public class OrderWindow {
    private JFrame jFrame;
    private JLabel instrumentLabel , countLabel , timeLabel;
    private JTextField instrumentTF , countTF , timeTF;
    private JButton addRequestButton , addReqPartButton , exitButton;

    public OrderWindow(){
        jFrame = new JFrame("Добавление заказа");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane() , BoxLayout.Y_AXIS));

        instrumentLabel = new JLabel("Добавить название инструмента");
        jFrame.add(instrumentLabel);

        instrumentTF = new JTextField();
        jFrame.add(instrumentTF);

        countLabel = new JLabel("Добавить количество нужного инструмента");
        jFrame.add(countLabel);

        countTF = new JTextField();
        jFrame.add(countTF);

        timeLabel = new JLabel("Введите нужное время для части заказа");
        jFrame.add(timeLabel);

        timeTF = new JTextField();
        jFrame.add(timeTF);

        addReqPartButton = new JButton("Добавить часть заказа");
        jFrame.add(addReqPartButton);

        addRequestButton = new JButton("Добавить заказ");
        jFrame.add(addRequestButton);

        exitButton = new JButton("Назад");
        jFrame.add(exitButton);

        jFrame.pack();
    }

    public JTextField getInstrumentTF() {
        return instrumentTF;
    }

    public JTextField getCountTF() {
        return countTF;
    }

    public JTextField getTimeTF() {
        return timeTF;
    }

    public JButton getAddRequestButton() {
        return addRequestButton;
    }

    public JButton getAddReqPartButton() {
        return addReqPartButton;
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
