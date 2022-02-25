package it.EightBB.Client;

import it.EightBB.Client.Authentication.AuthFacade;
import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.Interface.visitor;

import javax.swing.*;

public class ClientVisitor implements visitor {
private static visitor Instance;
private JFrame F;

    public static visitor getInstance(){
        if (Instance == null){
            Instance = new ClientVisitor();
        } return Instance;
    }

    @Override
    public void setFrame(JFrame F) {
        this.F = F;
        F.setLayout(null);
        F.setResizable(false);
        F.setVisible(true);
        F.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(F,
                        "Sicuro di Chiudere ?", "Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    visitProxy("SendEnd");
                    System.exit(0);
                }
            }
        });
    }

    @Override
    public void visitAuth(String where) {
        AuthFacade AF = AuthFacade.getInstance();
        AF.setF(F);
        switch(where) {
            case "Login" -> AF.Login();
            case "Register" -> AF.Register();
            case "RegisterC" -> AF.RegisterClient();
            case "RegisterO" -> AF.RegisterOwner();
        }

    }

    @Override
    public void visitProxy(String where) {
        SocketProxy Proxy = SocketProxy.getIstance();
        switch (where) {
            case "Start" -> Proxy.settingUP("87.19.149.155",5432);
            case "SendEnd" -> Proxy.SendEnd();
        }

    }

    @Override
    public void visitPclient( String where) {

    }

    @Override
    public void visitPowner(String where) {

    }
}
