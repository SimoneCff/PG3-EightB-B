package it.EightBB.Client.Pclient.Button;

import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Pclient.ConcreteHandlerTwo;

import javax.swing.*;
/**
 * Bottone che implementa la prenotazione di una determinata struttura
 * {@param Prenota} metodo che implementa il button di prenotazione
 */
public class Prenota implements Button {
    private JButton Bookedstr = null;

    @Override
    public void setButton() {
        //set button
        Bookedstr = new JButton("Ricerca");

        //set pos
        Bookedstr.setBounds(50,195,100,30);
        Bookedstr.setActionCommand("Client-B-Prenota");
        Bookedstr.addActionListener(ConcreteHandlerTwo.getInstance());
    }

    @Override
    public void InitialiteButtonIntoFrame(JFrame F) {
        F.add(Bookedstr);

    }
}
