package it.EightBB.Client.Authentication.Button;

import it.EightBB.Client.SwingBB.Button;

import javax.swing.*;

public class RegistrationB implements Button {
    private JButton RegBt = null;
    private JLabel RegNew = null;
    @Override
    public void setButton() {
        //set button
        RegBt = new JButton("Registrati");
        RegNew = new JLabel("Nuovo Utente?");


        //set pos
        RegNew.setBounds(50,195,100,30);
        RegBt.setBounds(150,200,100,20);

    }

    @Override
    public void InitialiteButtonIntoFrame(JFrame F) {
        F.add(RegNew);
        F.add(RegBt);
    }
}
