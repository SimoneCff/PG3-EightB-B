package it.EightBB.Client;


import it.EightBB.Client.Authentication.AuthInit;
import it.EightBB.Client.Factory.FactoryMaker;
import it.EightBB.Client.Factory.Init;
import it.EightBB.Client.Proxy.SocketProxy;

import javax.swing.*;

public class Client {
    public static void main(String[] args){
        //Setting UP
        SocketProxy Proxy = new SocketProxy("localhost",5432);
        FactoryMaker FM = FactoryMaker.getInstance();
        Init IZ;

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
