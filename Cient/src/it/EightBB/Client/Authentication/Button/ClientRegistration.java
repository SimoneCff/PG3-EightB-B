/** La classe ClientRegistration serve a specificare il bottone che riguarda la sezione della registrazione del cliente
 * nella struttura */

package it.EightBB.Client.Authentication.Button;
import it.EightBB.Client.SwingBB.Button;
import javax.swing.*;
public class ClientRegistration implements Button{
    private JButton ClientRegister=null;
    public void setButton(){
        ClientRegister=new JButton("Registrazione Cliente");
        ClientRegister.setBounds(50,100,70,20);
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(ClientRegister);
    }
}