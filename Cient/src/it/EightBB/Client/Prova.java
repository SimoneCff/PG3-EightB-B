package it.EightBB.Client;

import it.EightBB.Client.SwingBB.Form;

import javax.swing.*;

public class Prova {
    public static void main(String[] args){
       AbstractFactory at = FactoryMaker.getFactory("auth");
       at.getInstance();
       //make frame
       JFrame F = new JFrame("EightBB");

       // make and implement login into the main frame
       Form Login = at.makeForm("Login");

       //Setting Frame and Form for the login:
       F.setSize(400,400);
       Login.setForm();
       Login.InitialiateFormIntoFrame(F);

       //Initialize Frame and Form
       F.setVisible(true);
       F.setLayout(null);
       F.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   }
}
