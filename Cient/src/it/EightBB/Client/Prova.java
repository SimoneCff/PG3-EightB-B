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
       // make and implement login into the main frame
       Form Login = at.makeForm("Login");

       //Setting Frame and Form for the login:
       LoginF.setFrame();
       Login.setForm();

       //Initialize Frame and Form
       Login.InitialiateFormIntoFrame(LoginF.getFrame());
       LoginF.InitializeFrm();
   }
}
