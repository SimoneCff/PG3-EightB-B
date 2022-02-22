/** La classe PrivateAreaEntities serve a specificare il bottone che riguarda la sezione privata degli Enti Nazionali */

package it.EightBB.Client.Authentication.Powner.Button;
import it.EightBB.Client.SwingBB.Button;
import javax.swing.*;
public class PrivateAreaEntities implements Button{
    private JButton PrivateEntities=null;
    public void setButton(){
        PrivateEntities=new JButton("<html>Area privata<br />Enti nazionali</html>");
        PrivateEntities.setBounds(20,280,150,60);
    }
    public void InitialiteButtonIntoFrame(JFrame F){
        F.add(PrivateEntities);
    }
}