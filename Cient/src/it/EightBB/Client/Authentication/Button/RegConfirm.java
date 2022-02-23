package it.EightBB.Client.Authentication.Button;
import it.EightBB.Client.Interface.Template.Button;

import javax.swing.*;

public class RegConfirm implements Button {
    private JButton RegConfBt = null;

    public void setButton(){
        //set button
        RegConfBt = new JButton("Registrati!");

        //Set position
        RegConfBt.setBounds(350,300,200,30);
    }

    @Override
    public void InitialiteButtonIntoFrame(JFrame F) {
        F.add(RegConfBt);
    }


}
