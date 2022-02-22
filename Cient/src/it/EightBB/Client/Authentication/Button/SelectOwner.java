/**Bottone per scegliere il tipo di registrazione per il proprietario.*/

package it.EightBB.Client.Authentication.Button;

import it.EightBB.Client.SwingBB.Button;
import javax.swing.*;

public class SelectOwner implements Button {
    private JButton SelectOwner=null;
    public void setButton() {
        //set button
        SelectOwner = new JButton("Proprietario");
        //set position
        SelectOwner.setBounds(50,100,70,20);
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(SelectOwner);
    }
}