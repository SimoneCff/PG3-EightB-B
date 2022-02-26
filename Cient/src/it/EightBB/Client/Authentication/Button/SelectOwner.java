/**Bottone per scegliere il tipo di registrazione per il proprietario.*/

package it.EightBB.Client.Authentication.Button;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.Interface.Template.Button;
import javax.swing.*;

/**
 * Implementazione del tasto che permette di selezionare una registrazione di tipo Proprietario
 */
public class SelectOwner implements Button {
    private JButton SelectOwner = null;

    public void setButton() {
        //set button
        SelectOwner = new JButton("Proprietario");
        //set position
        SelectOwner.setBounds(200, 100, 100, 20);
        SelectOwner.setActionCommand("Auth-BP-RegO");
        SelectOwner.addActionListener(new ConcreteHanlderOne());
    }

    public void InitialiteButtonIntoFrame(JFrame F) {
        F.add(SelectOwner);
    }
}

