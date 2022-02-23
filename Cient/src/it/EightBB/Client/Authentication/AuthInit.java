package it.EightBB.Client.Authentication;

import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.FactoryMaker;
import it.EightBB.Client.Interface.Factory.Init;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;

import javax.swing.*;
import java.awt.*;

public class AuthInit implements Init {
    private static AuthInit Instance;
    private JFrame F;
    private FactoryMaker FM;
    private AbstractFactory AF;

    public static Init getInstance(JFrame F) {
        if (Instance== null){
           Instance = new AuthInit(F);
        } return Instance;
    }

    public AuthInit(JFrame F){
        this.F=F;
        this.FM = FactoryMaker.getInstance();
        this.AF = FM.getFactory("auth");

    }

    @Override
    public void Inizialize(String S) {
        switch (S) {
            case "Login" -> Login();
        }
    }


    void Login(){

        //Setting Button & Form
       Button Bf = AF.makeButton("Registration");
       Form Ff = AF.makeForm("Login");

       //Setting Up
        Bf.setButton();
        Ff.setForm();

        //Setting Frame
        Bf.InitialiteButtonIntoFrame(F);
        Ff.InitialiateFormIntoFrame(F);

        F.setSize(400,400);
        F.getContentPane().setBackground(new Color(225,204,204));
    }


}
