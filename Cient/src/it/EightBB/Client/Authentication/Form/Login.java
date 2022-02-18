package it.EightBB.Client.Authentication.Form;

import it.EightBB.Client.SwingBB.Form;
import javax.swing.*;


public class Login implements Form {
    private JTextField Us = null;
    private JPasswordField Ps = null;
    private JLabel Uss = null;
    private JLabel Pss = null;

    @Override
    public void setForm(){
        //Fields:
        Us = new JTextField();
        Ps = new JPasswordField();
        //Label:
        Uss = new JLabel("Username");
        Pss = new JLabel("Password");

        //set Fields:
        Us.setBounds(50,100,200,30);
        Ps.setBounds(50,160,200,30);

        //set Label:

        Uss.setBounds(50,70,200,30);
        Pss.setBounds(50,130,200,30);
    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
        //add User Form
        F.add(Uss);
        F.add(Us);
        //add pass Form
        F.add(Pss);
        F.add(Ps);
    }

}
