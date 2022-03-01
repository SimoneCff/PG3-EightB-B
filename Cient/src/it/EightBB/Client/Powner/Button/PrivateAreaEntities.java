/** La classe PrivateAreaEntities serve a specificare il bottone che riguarda la sezione privata degli Enti Nazionali */

package it.EightBB.Client.Powner.Button;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Powner.ConcreteHandlerThree;

import javax.swing.*;

/**
 * implementazione del tasto di accesso alla sezione di gestione documenti per gli enti nazionali.
 * il tasto e' presente nell'area privata del proprietario.
 * {@param PrivateAreaEntities} parametro che implementa il button per l'area privata dell'utente proprietario
 */
public class PrivateAreaEntities implements Button{
    private JButton PrivateEntities=null;
    public void setButton(){
        PrivateEntities=new JButton("<html>Area privata<br />Enti nazionali</html>");
        PrivateEntities.setBounds(20,280,150,60);
        PrivateEntities.setActionCommand("Owner-B-File");
        PrivateEntities.addActionListener(ConcreteHandlerThree.getInstance());
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(PrivateEntities);
    }

}