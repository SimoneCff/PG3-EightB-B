/** La classe ClientRegistration serve a specificare il bottone che riguarda la sezione della registrazione del cliente
 * nella struttura */

package it.EightBB.Client.Authentication.Powner.Button;
import it.EightBB.Client.SwingBB.Button;
import javax.swing.*;
public class ClientRegistration implements Button{
    private JButton ClientRegister=null;
    public void setButton(){
        ClientRegister=new JButton("<html>Registrazione<br />Cliente</html>");
        ClientRegister.setBounds(20,160,150,60);
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(ClientRegister);
    }
}