/** La classe RegisterStructure serve a specificare il bottone che riguarda la sezione della registrazione della
 * struttura */

package it.EightBB.Client.Powner.Button;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Powner.ConcreteHandlerThree;

import javax.swing.*;

/**
 * implementazione del tasto di registrazione di una struttura.
 * il tasto e' presente nel form di registrazione di una struttura.
 * {@param RegisterStructure}
 */
public class RegisterStructure implements Button{
    private JButton RegisterStruct=null;
    public void setButton(){
        RegisterStruct=new JButton("Registra struttura");
        RegisterStruct.setBounds(20,340,150,60);
        RegisterStruct.setActionCommand("Owner-B-Rowner");
        RegisterStruct.addActionListener(ConcreteHandlerThree.getInstance());
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(RegisterStruct);
    }

    }