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
       Login.setForm();
       Login.InitialiateFormIntoFrame(LoginF.getFrame());

       //Initialize Frame and Form
       LoginF.setFrame();
       LoginF.InitializeFrm();
   }
}
