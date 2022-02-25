/** Bottone per Modificare il Profilo Utente*/
package it.EightBB.Client.Powner.Button;
import it.EightBB.Client.Interface.Template.Button;

import javax.swing.*;

public class ModifyProfileO implements Button{
    private JButton ModifyP = null;
    @Override
    public void setButton() {
        //set button
        ModifyP = new JButton("<html>Modifica<br />Profilo utente</html>");
        //set pos
        ModifyP.setBounds(700,150,150,60);
    }
    @Override
    public void InitialiteButtonIntoFrame(JFrame F) {

        F.add(ModifyP);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

