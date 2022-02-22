/** La classe EconomicManagement serve a specificare il bottone che riguarda la sezione della gestione economica di
 *  ciascuna struttura. */

package it.EightBB.Client.Authentication.Powner.Button;
import it.EightBB.Client.SwingBB.Button;
import javax.swing.*;
public class EconomicManagement implements Button{
    private JButton ManageEconomy=null;
    public void setButton(){
        ManageEconomy=new JButton("Gestione economica");
        ManageEconomy.setBounds(20,220,150,60);
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(ManageEconomy);
    }
}