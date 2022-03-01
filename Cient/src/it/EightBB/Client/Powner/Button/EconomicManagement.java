/** La classe EconomicManagement serve a specificare il bottone che riguarda la sezione della gestione economica di
 *  ciascuna struttura. */

package it.EightBB.Client.Powner.Button;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Powner.ConcreteHandlerThree;

import javax.swing.*;

/**
 * implementazione del tasto di visualizzazione della pagina della gestione economica di una struttura
 * utilizzando il tasto, il proprietario verra' indirizzato in questa nuova pagina
 * verra' visualizzato il saldo di entrate ed uscite di quella determinata struttura
 * {@param EconomicManagement} parametro che implementa il button per la gestione economica dell'utente proprietario
 */
public class EconomicManagement implements Button{
    private JButton ManageEconomy=null;
    public void setButton(){
        ManageEconomy=new JButton("Gestione economica");
        ManageEconomy.setBounds(20,220,150,60);
        ManageEconomy.setActionCommand("Owner-B-Economic");
        ManageEconomy.addActionListener(ConcreteHandlerThree.getInstance());
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(ManageEconomy);
    }

}