package it.EightBB.Client.Authentication.Button;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.Interface.Template.Button;

import javax.swing.*;

public class ReturnSel implements Button {
    private JButton Return;
    @Override
    public void setButton() {
        Return = new JButton("Indietro");

        Return.setBounds(470, 20, 80, 20);
        Return.setActionCommand("Auth-BP-Register");
        Return.addActionListener(new ConcreteHanlderOne());
    }

    @Override
    public void InitialiteButtonIntoFrame(JFrame F) {
        F.add(Return);
    }
}
