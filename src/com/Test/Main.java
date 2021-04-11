package com.Test;
//import javax.management.remote.JMXProviderException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JFrame mainFrame;
    private JButton startButton;
    private JProgressBar progressBar;
    private Task task;

    public Main(){
        mainFrame = new JFrame("Progress Bar Example");
        mainFrame.setSize(600,400);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(3);

        startButton = new JButton("Start");
        startButton.setBounds(50,50,100,50);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task = new Task();
                task.start();
                //JOptionPane.showMessageDialog(null,"finish");
            }
        });
        progressBar = new JProgressBar(0,100);
        progressBar.setBounds(50,50,100,50);
        progressBar.setStringPainted(true);
        mainFrame.add(progressBar);
        mainFrame.add(startButton);
        mainFrame.setVisible(true);

    }

    public static void main(String[] args) {
        new Main();
	// write your code here
    }

    private class Task extends Thread{
        @Override
        public void run(){
            for (int i = 0;1<=100; i++){
                progressBar.setValue(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
