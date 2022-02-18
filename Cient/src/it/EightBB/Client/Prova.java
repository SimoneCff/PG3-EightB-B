package it.EightBB.Client;

import it.EightBB.Client.SwingBB.Button;
import it.EightBB.Client.SwingBB.Form;

import javax.swing.*;
import java.awt.*;

public class Prova {
    public static void main(String[] args){
       AbstractFactory at = FactoryMaker.getFactory("auth");
       at.getInstance();

       //make frame
       JFrame F = new JFrame("EightBB");

       // make and implement login into the main frame
       Form Login = at.makeForm("Login");
       Button Log = at.makeButton("Login");

       //Setting Frame and Form for the login:
       Login.setForm();
       Log.setButton();
       Login.InitialiateFormIntoFrame(F);
       Log.InitialiteButtonIntoFrame(F);

       //Initialize Frame and Form
       F.setLayout(null);
       F.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       F.getContentPane().setBackground(new Color(225,204,204));
       F.setVisible(true);

   }
}

class FactoryMaker {
   private static AbstractFactory fc = null;
   static AbstractFactory getFactory(String Choise) {
      if (Choise.equals("auth")) {
         fc = new AuthFactory();
      }
      if (Choise.equals("bo")){ fc = null;}
      return fc;
   }
}