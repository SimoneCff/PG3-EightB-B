package it.EightBB.Client.Authentication.Button;

import it.EightBB.Client.SwingBB.Button;

import javax.swing.*;

public class RegistrationB implements Button {
    private JButton RegBt = null;
    @Override
    public void setButton() {
        //set button
        RegBt = new JButton("Registrati");


        //set pos
        RegBt.setBounds(50,230,200,30);

    }

    @Override
    public void InitialiteButtonIntoFrame(JFrame F) {
        F.add(RegBt);
    }
}
