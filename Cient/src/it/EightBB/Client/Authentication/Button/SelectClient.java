/**Bottone per selezionare il tipo di registrazione per il cliente.*/

package it.EightBB.Client.Authentication.Button;

import it.EightBB.Client.Interface.SwingInt.Button;
import javax.swing.*;

public class SelectClient implements Button {
    private JButton SelectClient=null;
    public void setButton() {
        //set button
        SelectClient = new JButton("Cliente");
        //set position
        SelectClient.setBounds(50,100,100,20);
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(SelectClient);
    }
}
