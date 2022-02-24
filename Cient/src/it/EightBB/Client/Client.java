package it.EightBB.Client;

import it.EightBB.Client.Authentication.AuthFacade;
import it.EightBB.Client.CEssentials.FactoryMaker;
import it.EightBB.Client.CEssentials.SocketProxy;

import javax.swing.*;


public class Client {
    public static void main(String[] args){
        //Setting UP
        SocketProxy Proxy = (SocketProxy) SocketProxy.getIstance();
        Proxy.settingUP("87.19.149.155",5432);
        FactoryMaker FM = FactoryMaker.getInstance();
        AuthFacade IZ;

        //Set ActionHandler

        //Setting Login Frame (Default Frame);
        JFrame Frame = new JFrame("EightBB");
        IZ = AuthFacade.getInstance();
        IZ.setF(Frame);
        IZ.Inizialize("Login");

        //Setting Frame
        Frame.setLayout(null);
        Frame.setVisible(true);
        Frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(Frame,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    Proxy.SendEnd();
                    System.exit(0);
                }
            }
        });
    }



}
