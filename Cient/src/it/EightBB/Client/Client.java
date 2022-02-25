package it.EightBB.Client;

import it.EightBB.Client.Interface.visitor;
import javax.swing.*;


public class Client {
    public static void main(String[] args){
        //Setting UP
        visitor Visitor = ClientVisitor.getInstance();
        Visitor.visitProxy("Start");
        JFrame Frame = new JFrame("EightBB");

        //Setting Login Frame (Default Frame);
        Visitor.visitAuth(Frame,"Login");

        //Setting Frame
        Frame.setLayout(null);
        Frame.setResizable(false);
        Frame.setVisible(true);
        Frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(Frame,
                        "Sicuro di Chiudere ?", "Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    Visitor.visitProxy("SendEnd");
                    System.exit(0);
                }
            }
        });
    }
}
