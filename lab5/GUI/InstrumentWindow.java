package GUI;

import javax.swing.*;

public class InstrumentWindow {
    private JFrame jFrame;
    private JLabel nameLabel , countLabel;
    private JTextField nameTF , countTF;
    private JButton addButton , exitButton;

    public InstrumentWindow(){

        jFrame = new JFrame("Добавить инструмент");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane() , BoxLayout.Y_AXIS));

        nameLabel = new JLabel("Введите название инструмента");
        jFrame.add(nameLabel);

        nameTF = new JTextField();
        jFrame.add(nameTF);

        countLabel = new JLabel("Введите количество инструмента");
        jFrame.add(countLabel);

        countTF = new JTextField();
        jFrame.add(countTF);

        addButton = new JButton("Добавить");
        jFrame.add(addButton);

        exitButton = new JButton("Назад");
        jFrame.add(exitButton);

        jFrame.pack();
    }

    public JTextField getNameTF() {
        return nameTF;
    }

    public JTextField getCountTF() {
        return countTF;
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
