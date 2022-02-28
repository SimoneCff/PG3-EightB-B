/** Bottone per Modificare il Profilo Utente*/
package it.EightBB.Client.Powner.Button;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Powner.ConcreteHandlerThree;

import javax.swing.*;

/**
 * implementazione del tasto di Modifica Profilo dell'utente proprietario
 * il tasto e' presente nella pagine personale dell'utente proprietario
 * consente di modificare i dati personali del proprietario
 * {@param ModifyProfileO} parametro che implementa il button per la modifica del profilo
 */
public class ModifyProfileO implements Button{
    private JButton ModifyP = null;
    @Override
    public void setButton() {
        //set button
        ModifyP = new JButton("<html>Modifica<br />Profilo utente</html>");
        //set pos
        ModifyP.setBounds(700,150,150,60);
        ModifyP.setActionCommand("Owner-B-Mod");
        ModifyP.addActionListener(ConcreteHandlerThree.getInstance());
    }
    @Override
    public void InitialiteButtonIntoFrame(JFrame F) {

        F.add(ModifyP);
    }


}

