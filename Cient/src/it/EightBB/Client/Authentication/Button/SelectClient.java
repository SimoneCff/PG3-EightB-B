/**Bottone per selezionare il tipo di registrazione per il cliente.*/

package it.EightBB.Client.Authentication.Button;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.Interface.Template.Button;
import javax.swing.*;

/**
 * implementazione del Tasto che permette di selezionare una registrazione di tipo Cliente
 *{@param SelectClient}
 */
public class SelectClient implements Button {
    private JButton SelectClient=null;
    public void setButton() {
        //set button
        SelectClient = new JButton("Cliente");
        //set position
        SelectClient.setBounds(50,100,100,20);
        SelectClient.setActionCommand("Auth-BP-RegC");
        SelectClient.addActionListener(new ConcreteHanlderOne());
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(SelectClient);
    }


}
