package it.EightBB.Client.Authentication.Form;

import it.EightBB.Client.SwingBB.Form;
import javax.swing.*;
import java.awt.*;
import java.lang.annotation.Inherited;

public class Register implements Form{
    private JTextField Name, Sur, Us = null;
    private JPasswordField Ps = null;
    private JLabel Namee, Surr, Uss, Pss, Reg = null;


    @Override
    public void setForm(){
        //Fields
        Name = new JTextField();
        Sur = new JTextField();
        Us = new JTextField();
        Ps = new JPasswordField();

        //Label:
        Namee = new JLabel("Nome");
        Surr = new JLabel("Cognome");
        Uss = new JLabel("Mail");
        Pss = new JLabel("Password");
        Reg = new JLabel("Registrazione");

        //Set Fields:
        Name.setBounds(50,100,200,30);
        Sur.setBounds(50,160,200,30);
        Us.setBounds(50,240,200,30);
        Ps.setBounds(50,300,200,30);

        //Set Label:
        Reg.setBounds(50,15,200,40);
        Reg.setFont(new Font("Arial", Font.PLAIN, 30));

        Namee.setBounds(50,70,200,30);
        Surr.setBounds(50,130,200,30);
        Uss.setBounds(50,210,200,30);
        Pss.setBounds(50,270,200,30);
    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
        //add Name Form
        F.add(Namee);
        F.add(Name);
        //add Surname Form
        F.add(Surr);
        F.add(Sur);
        //add User Form
        F.add(Uss);
        F.add(Us);
        //add pass Form
        F.add(Pss);
        F.add(Ps);
    }

}

