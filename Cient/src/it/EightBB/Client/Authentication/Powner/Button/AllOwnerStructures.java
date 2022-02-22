/** La classe OwnerAllStructure serve a specificare il bottone che riguarda tutte le strutture registrate dal
 * proprietario */

package it.EightBB.Client.Authentication.Powner.Button;
import it.EightBB.Client.SwingBB.Button;
import javax.swing.*;
public class AllOwnerStructures implements Button{
    private JButton AllStructures=null;
    public void setButton(){
        AllStructures=new JButton("Strutture Registrate");
        AllStructures.setBounds(50,100,70,20);
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(AllStructures);
    }
}