/** Bottone per Modificare il Profilo Utente*/
package it.EightBB.Client.Pclient.Button;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Pclient.ConcreteHandlerTwo;
import it.EightBB.Client.Pclient.Form.ModifyProfile;

import javax.swing.*;
/**
 * implementazione del tasto di Modifica Profilo dell'utente cliente
 * il tasto e' presente nella pagine personale dell'utente cliente
 * consente di modificare i dati personali del cliente
 * {@param ModifyProfileO} parametro che implementa il button per la modifica del profilo
 */
public class ModifyProfileC implements Button{
    private JButton ModifyP = null;
    @Override
    public void setButton() {
        //set button
        ModifyP = new JButton("<html>Modifica<br />Profilo utente</html>");
        //set pos
        ModifyP.setBounds(968,335,150,60);
        ModifyP.addActionListener(ConcreteHandlerTwo.getInstance());
        ModifyP.setActionCommand("Client-B-Modify");
    }
    @Override
    public void InitialiteButtonIntoFrame(JFrame F) {

        F.add(ModifyP);
    }



}

