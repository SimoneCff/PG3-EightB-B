package it.EightBB.Client.Authentication;

import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.CEssentials.FactoryMaker;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Template.TextGroup;

import javax.swing.*;
import java.awt.*;

public class AuthFacade {
    private static AuthFacade Instance;
    private JFrame F;
    private FactoryMaker FM;
    private AbstractFactory AF;

    public static AuthFacade getInstance (){
        if (Instance== null){
           Instance = new AuthFacade();
        } return Instance;
    }

    public JFrame getF() {
        return F;
    }

    public AuthFacade(){
        this.FM = FactoryMaker.getInstance();
        this.AF = FM.getFactory("auth");

    }

    public void setF(JFrame f) {
        F = f;
    }

    public void Inizialize(String S) {
        switch (S) {
            case "Login" -> Login();
        }
    }


    void Login(){
        F.getContentPane().removeAll();
        F.repaint();

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

    void Register() {
        F.getContentPane().removeAll();
        F.repaint();
        TextGroup selectionTypeRegfinal = AF.makeText("Select");
        Button SelectC = AF.makeButton("SelectC");
        Button SelectO = AF.makeButton("SelectO");

        //SetUp Components
        selectionTypeRegfinal.setText();
        SelectC.setButton();
        SelectO.setButton();

        //SettingUP into Frame
        selectionTypeRegfinal.InitialiteTextIntoFrame(F);
        SelectC.InitialiteButtonIntoFrame(F);
        SelectO.InitialiteButtonIntoFrame(F);

        F.setSize(400,400);
        F.getContentPane().setBackground(new Color(225,204,204));
    }

    void RegisterOwner() {
        Register();
        Form Reg = AF.makeForm("RegisterO");

        //Setting UP
        Reg.setForm();

        //Build-Up
        Reg.InitialiateFormIntoFrame(F);

        F.setSize(400,400);
        F.getContentPane().setBackground(new Color(225,204,204));
    }

    void RegisterClient() {
        Register();
        Form Reg = AF.makeForm("Register");

        //Setting UP
        Reg.setForm();

        //Build-Up
        Reg.InitialiateFormIntoFrame(F);

        F.setSize(400,400);
        F.getContentPane().setBackground(new Color(225,204,204));
    }
}
