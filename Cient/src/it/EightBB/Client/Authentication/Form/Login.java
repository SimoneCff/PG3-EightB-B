package it.EightBB.Client.Authentication.Form;

import it.EightBB.Client.SwingBB.Form;
import javax.swing.*;
import java.awt.*;


public class Login implements Form {
    private JTextField Us = null;
    private JPasswordField Ps = null;
    private JLabel Uss, Pss, Log = null;
    private JSeparator Sep = null;

    @Override
    public void setForm(){
        //Fields:
        Us = new JTextField();
        Ps = new JPasswordField();

        //Label:
        Uss = new JLabel("Username");
        Pss = new JLabel("Password");
        Log = new JLabel("Login :");

        //set Fields:
        Us.setBounds(50,100,200,30);
        Ps.setBounds(50,160,200,30);

        //set Label:
        Log.setBounds(50,15,200,40);
        Log.setFont(new Font("Arial", Font.PLAIN, 30));

        Uss.setBounds(50,70,200,30);
        Pss.setBounds(50,130,200,30);

    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {;
        //add User Form
        F.add(Uss);
        F.add(Us);
        //add pass Form
        F.add(Log);
        F.add(Pss);
        F.add(Ps);
    }

}
