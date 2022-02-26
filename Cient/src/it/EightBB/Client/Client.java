package it.EightBB.Client;

import it.EightBB.Client.Interface.visitor;
import javax.swing.*;


public class Client {
    public static void main(String[] args){
        //Setting UP
        visitor Visitor = ClientVisitor.getInstance();
        Visitor.visitProxy("Start");
        //Setting Login Frame (Default Frame);
        Visitor.setFrame(new JFrame("EightBB"));
        Visitor.setHandler();
        Visitor.visitAuth("Login");
    }
}
