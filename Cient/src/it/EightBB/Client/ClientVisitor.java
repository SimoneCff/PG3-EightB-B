package it.EightBB.Client;

import it.EightBB.Client.Authentication.AuthFacade;
import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.Interface.visitor;

import javax.swing.*;

public class ClientVisitor implements visitor {
private static visitor Instance;

    public static visitor getInstance(){
        if (Instance == null){
            Instance = new ClientVisitor();
        } return Instance;
    }

    @Override
    public void visitAuth(JFrame F, String where) {
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
    public void visitPclient(JFrame F, String where) {

    }

    @Override
    public void visitPowner(JFrame F,String where) {

    }
}
