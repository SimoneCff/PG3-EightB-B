package it.EightBB.Client;

import it.EightBB.Client.Authentication.AuthInit;
import it.EightBB.Client.CEssentials.FactoryMaker;
import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.Interface.Factory.Init;

import javax.swing.*;


public class Client {
    public static void main(String[] args){
        //Setting UP
        SocketProxy Proxy = (SocketProxy) SocketProxy.getIstance();
        Proxy.settingUP("localhost",5432);
        FactoryMaker FM = FactoryMaker.getInstance();
        Init IZ;

        //Set ActionHandler

        //Setting Login Frame (Default Frame);
        JFrame Frame = new JFrame("EightBB");
        IZ = AuthInit.getInstance(Frame);
        IZ.Inizialize("Login");

        //Setting Frame
        Frame.setLayout(null);
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
