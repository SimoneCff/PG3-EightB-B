/** La classe EconomicManagement serve a specificare il bottone che riguarda la sezione della gestione economica di
 *  ciascuna struttura. */

package it.EightBB.Client.Authentication.Button;
import it.EightBB.Client.SwingBB.Button;
import javax.swing.*;
public class EconomicManagement implements Button{
    private JButton ManageEconomy=null;
    public void setButton(){
        ManageEconomy=new JButton("Gestione economica");
        ManageEconomy.setBounds(50,100,70,20);
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(ManageEconomy);
    }
}