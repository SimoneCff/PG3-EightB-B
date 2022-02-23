package it.EightBB.Client.Powner.Button;

import it.EightBB.Client.Interface.SwingInt.Button;

import javax.swing.*;

public class GoBackO implements Button {

    private JButton GoBack=null;
    public void setButton(){
        GoBack=new JButton("Annulla");
        GoBack.setBounds(200,380,100,30);
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(GoBack);
    }

}
