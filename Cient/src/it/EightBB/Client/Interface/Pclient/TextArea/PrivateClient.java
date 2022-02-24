package it.EightBB.Client.Interface.Pclient.TextArea;

import it.EightBB.Client.Interface.Template.TextGroup;
import javax.swing.*;
import java.awt.*;

public class PrivateClient implements TextGroup {
    private JLabel Name, Surname, BirthDate, Mail, Pass = null;

    @Override
    public void setText() {
    //Labels
        Name = new JLabel("Nome:");
        Surname = new JLabel("Cognome:");
        BirthDate = new JLabel("Data di Nascita:");
        Mail = new JLabel("Mail:");
        Pass = new JLabel("Password:");


        //Set Labels
        Name.setBounds(200,100,200,30);
        Surname.setBounds(200,160,200,30);
        BirthDate.setBounds(200,220,200,30);
        Mail.setBounds(200,280,200,30);
        Pass.setBounds(200,340,200,30);

    }

    @Override
    public void InitialiteTextIntoFrame(JFrame F) {
        F.add(Name);
        F.add(Surname);
        F.add(BirthDate);
        F.add(Mail);
        F.add(Pass);

        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));
    }
}
