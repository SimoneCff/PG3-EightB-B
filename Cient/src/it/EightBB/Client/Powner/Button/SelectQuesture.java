/** La classe OwnerAllStructure serve a specificare il bottone che riguarda tutte le strutture registrate dal
 * proprietario */

package it.EightBB.Client.Powner.Button;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Powner.ConcreteHandlerThree;

import javax.swing.*;
public class SelectQuesture implements Button{
    private JButton AllStructures=null;
    public void setButton(){
        AllStructures=new JButton("Invio documenti Ente Questura");
        AllStructures.setBounds(20,100,150,60);
        AllStructures.setActionCommand("Owner-B-Client");
        AllStructures.addActionListener(ConcreteHandlerThree.getInstance());
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(AllStructures);
    }
