package it.EightBB.Client.Pclient.Button;

import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Pclient.ConcreteHandlerTwo;
import it.EightBB.Client.Powner.ConcreteHandlerThree;

import javax.swing.*;

public class GoBackC implements Button {

    private JButton GoBack=null;
    public void setButton(){
        GoBack=new JButton("Annulla");
        GoBack.setBounds(200,380,100,30);
        GoBack.setActionCommand("Client-B-MdBack");
        GoBack.addActionListener(ConcreteHandlerTwo.getInstance());
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(GoBack);
    }

}
