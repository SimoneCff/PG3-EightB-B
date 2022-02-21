package it.EightBB.Client;

import it.EightBB.Client.Authentication.AuthFactory;
import it.EightBB.Client.SwingBB.Button;
import it.EightBB.Client.SwingBB.Form;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Prova {
    public static void main(String[] args){
       AbstractFactory at = FactoryMaker.getFactory("auth");
       at.getInstance();

       //make login frame
       JFrame F = new JFrame("EightBB");


       // make and implement login into the main frame
       Form Login = at.makeForm("Login");
       Button Log = at.makeButton("Login");
       Button Reg = at.makeButton("Registration");


       //Setting Frame and Form for the login:
       Login.setForm();
       Log.setButton();
       Reg.setButton();
       Login.InitialiateFormIntoFrame(F);
       Log.InitialiteButtonIntoFrame(F);
       Reg.InitialiteButtonIntoFrame(F);

       //Initialize Frame and Form Login
       F.setLayout(null);
       F.setSize(400, 400);
       F.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       F.getContentPane().setBackground(new Color(225,204,204));
       F.setVisible(true);
   }
}

class Client_Server {
   public static void main(String[] args) {
      SocketProxy Proxy = new SocketProxy("192.168.1.118",5432);
      Proxy.write("Auth,Login,null");
      System.out.println(Proxy.read());
      Proxy.close();
   }

}

class Register{
   public static void main(String[] args) {
      AbstractFactory at = FactoryMaker.getFactory("auth");
      at.getInstance();

      //make login frame
      JFrame F = new JFrame("EightBB");

      Form RegisterO = at.makeForm("RegisterO");
      Button RegConfirm = at.makeButton("RegConfirm");

      RegConfirm.setButton();
      RegisterO.setForm();
      RegisterO.InitialiateFormIntoFrame(F);
      RegConfirm.InitialiteButtonIntoFrame(F);


      //Initialize Frame and Form Login
      F.setLayout(null);
      F.setSize(800, 500);
      F.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      F.getContentPane().setBackground(new Color(225,204,204));
      F.setVisible(true);


   }
}
