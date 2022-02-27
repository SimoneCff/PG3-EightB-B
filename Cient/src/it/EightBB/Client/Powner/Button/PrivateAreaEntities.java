/** La classe PrivateAreaEntities serve a specificare il bottone che riguarda la sezione privata degli Enti Nazionali */

package it.EightBB.Client.Powner.Button;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Powner.ConcreteHandlerThree;

import javax.swing.*;
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