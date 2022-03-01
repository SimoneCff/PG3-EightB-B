package it.EightBB.Client.Pclient.Button;

import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Pclient.ConcreteHandlerTwo;
import it.EightBB.Client.Powner.ConcreteHandlerThree;

import javax.swing.*;
/**
 * implementazione del tasto di Annulla
 * il tasto permette al cliente di tornare alla pagina precedente
 * o di annullare una determinata scelta o selezione
 * {@param GobackC} parametro che implementa il button per tornare indietro
 */
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
