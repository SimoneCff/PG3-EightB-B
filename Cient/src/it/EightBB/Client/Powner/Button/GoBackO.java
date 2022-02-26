package it.EightBB.Client.Powner.Button;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Powner.ConcreteHandlerThree;

import javax.swing.*;

public class GoBackO implements Button {

    private JButton GoBack=null;
    public void setButton(){
        GoBack=new JButton("Annulla");
        GoBack.setBounds(200,380,100,30);
        GoBack.setActionCommand("Owner-B-ModBack");
        GoBack.addActionListener(ConcreteHandlerThree.getInstance());
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(GoBack);
    }

}
