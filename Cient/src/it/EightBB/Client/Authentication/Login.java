package it.EightBB.Client.Authentication;

import it.EightBB.Client.SwingBB.Form;
import javax.swing.*;


public class Login implements Form {

    private JTextField Us;
    private JTextField Ps;

    @Override
    public void Submit(JFrame F) {
        Us= new JTextField("Username");
        Ps= new JTextField("Password");
        Us.setBounds(50,150,200,30);
        Ps.setBounds(50,150,200,30);
        F.add(Us);
        F.add(Ps);
    }


}
