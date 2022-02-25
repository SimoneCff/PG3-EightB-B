package it.EightBB.Client.Powner.TextArea;

import it.EightBB.Client.Interface.Template.TextGroup;

import javax.swing.*;
import java.awt.*;

public class PrivateOwner implements TextGroup {
    private JLabel Name, Surname, Mail, Pass = null;

    @Override
    public void setText() {
    //Labels
        Name = new JLabel("Nome:");
        Surname = new JLabel("Cognome:");
        Mail = new JLabel("Mail:");
        Pass = new JLabel("Password:");


        //Set Labels
        Name.setBounds(200,100,200,30);
        Surname.setBounds(200,160,200,30);
        Mail.setBounds(200,280,200,30);
        Pass.setBounds(200,340,200,30);

    }

    @Override
    public void InitialiteTextIntoFrame(JFrame F) {
        F.add(Name);
        F.add(Surname);
        F.add(Mail);
        F.add(Pass);

        F.setSize(880, 500);
        F.getContentPane().setBackground(new Color(225,204,204));
    }
}
