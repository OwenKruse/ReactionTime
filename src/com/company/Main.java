package com.company;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Main {

    public static void main(String[] args) {
	JFrame frame = new JFrame("Reaction time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button = new JButton("Wait");
        button.setForeground(Color.GREEN);
        frame.getContentPane().add(button);
        frame.setVisible(true);
        Timer sw = new Timer();
        int I = 0;



        int min = 2000;
        int max = 6000;
        int ran = (int) Math.floor(Math.random() * (max - min + 1) + min);
        try
        {
            Thread.sleep(ran);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        button.setText("Click");
        sw.start();
        button.setBackground(Color.RED);
        button.setForeground(Color.RED);
        while(I == 0) {
            button.addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {
                    sw.stop();
                    button.setText(sw.getElapsedTime().toMillis() + "ms");
                    button.setForeground(Color.GREEN);


                }
            });
            I--;
        }

    }
}
