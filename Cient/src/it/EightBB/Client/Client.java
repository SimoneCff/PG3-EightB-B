package it.EightBB.Client;

import it.EightBB.Client.Interface.visitor;
import javax.swing.*;


public class Client {
    public static void main(String[] args){
        //Setting UP
        visitor Visitor = ClientVisitor.getInstance();
        ImplementationFacade IF = ImplementationFacade.getInstance();
        //Setting Login Frame (Default Frame);
        IF.setFrame(new JFrame("EightBB"));
        //Setting Handler
        IF.setHandler();
        //Setting Proxy
        IF.visitProxy("Start");
        //Visit Auth
        Visitor.visitAuth("Login");
    }
}
