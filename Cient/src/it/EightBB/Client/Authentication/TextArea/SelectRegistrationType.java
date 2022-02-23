package it.EightBB.Client.Authentication.TextArea;

import it.EightBB.Client.Interface.Template.TextGroup;
import javax.swing.*;
import java.awt.*;

public class SelectRegistrationType implements TextGroup {
    private JTextField TitleRegistration = null;

    @Override
    public void setText() {
        TitleRegistration = new JTextField("Selezionare il tipo di registrazione:");

        TitleRegistration.setBounds(77,25,200,30);

    }

    @Override
    public void InitialiteTextIntoFrame(JFrame F) {
        F.add(TitleRegistration);

        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));
    }
}
