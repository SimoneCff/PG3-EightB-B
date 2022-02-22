/** La classe RegisterStructure serve a specificare il bottone che riguarda la sezione della registrazione della
 * struttura */

package it.EightBB.Client.Authentication.Powner.Button;
import it.EightBB.Client.SwingBB.Button;
import javax.swing.*;
public class RegisterStructure implements Button{
    private JButton RegisterStruct=null;
    public void setButton(){
        RegisterStruct=new JButton("Registra struttura");
        RegisterStruct.setBounds(50,100,70,20);
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(RegisterStruct);
    }
}