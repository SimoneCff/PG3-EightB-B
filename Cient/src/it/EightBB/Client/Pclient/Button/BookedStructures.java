/** Bottone per visualizzare le prenotazioni effettuate dal cliente*/
package it.EightBB.Client.Pclient.Button;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Pclient.ConcreteHandlerTwo;

import javax.swing.*;
public class BookedStructures implements Button{
    private JButton Bookedstr = null;

    @Override
    public void setButton() {
        //set button
        Bookedstr = new JButton("Prenotazioni Effettuate");

        //set pos
        Bookedstr.setBounds(50,295,100,30);
        Bookedstr.setActionCommand("Client-B-Booked");
        Bookedstr.addActionListener(ConcreteHandlerTwo.getInstance());
    }

    @Override
    public void InitialiteButtonIntoFrame(JFrame F) {
        F.add(Bookedstr);

    }


}
