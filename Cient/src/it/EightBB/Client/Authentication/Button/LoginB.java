package it.EightBB.Client.Authentication.Button;

import it.EightBB.Client.SwingBB.Button;

import javax.swing.*;

public class LoginB  implements Button {
    private JButton LogBt = null;
    @Override
    public void setButton() {
        //set button
        LogBt = new JButton("Login");

        //set pos
        LogBt.setBounds(50,400,200,30);

    }

    @Override
    public void InitialiteButtonIntoFrame(JFrame F) {
        F.add(LogBt);
    }
}
