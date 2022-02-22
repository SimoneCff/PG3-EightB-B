/** Bottone per Modificare il Profilo Utente*/
package it.EightBB.Client.Authentication.Button;
import it.EightBB.Client.SwingBB.Button;

import javax.swing.*;
public class ModifyProfile implements Button{
    private JButton ModifyP = null;
    @Override
    public void setButton() {
        //set button
        ModifyP = new JButton("Modifica Profilo Utente");
        //set pos
        ModifyP.setBounds(150,200,100,20);
    }
    @Override
    public void InitialiteButtonIntoFrame(JFrame F) {

        F.add(ModifyP);
    }
}

