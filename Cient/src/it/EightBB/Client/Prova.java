package it.EightBB.Client;

import it.EightBB.Client.SwingBB.Form;
import it.EightBB.Client.SwingBB.Frame;

import javax.swing.*;

public class Prova {
    public static void main(String[] args){
       AbstractFactory at = FactoryMaker.getFactory("auth");
       at.getInstance();
       //make frame
       Frame LoginF = at.makeFrame("Login");
       LoginF.setFrame();
       // make and implement login into the main frame
       Form Login = at.makeForm("Login");
       Login.Submit(LoginF.getFrame());
       //Initialize Frame
       LoginF.InitializeFrm(LoginF.getFrame());
   }
}
