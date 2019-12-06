package GUI;

import javax.swing.*;

public class ProcessWindow {

    private JFrame jFrame;
    private JLabel resultLabel;
    private JButton exitButton;

    public ProcessWindow(){

        jFrame = new JFrame("План оптимального заказа");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane() , BoxLayout.Y_AXIS));

        resultLabel = new JLabel();
        jFrame.add(resultLabel);

        exitButton = new JButton("Назад");
        jFrame.add(exitButton);

        jFrame.pack();
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setResult(String text){
        this.resultLabel.setText(text);
    }

    public void run(){
        jFrame.setVisible(true);
    }

    public void stop(){
        jFrame.setVisible(false);
    }
}
