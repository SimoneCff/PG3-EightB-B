package it.EightBB.Client.Powner.TextArea;

import it.EightBB.Client.Interface.Template.TextGroup;

import javax.swing.*;
import java.awt.*;

public class SelectEnte implements TextGroup {
    private JLabel seleziona = null;
    @Override
    public void setText() {
        seleziona = new JLabel("Selezionare il file da inviare alla questura/ente turismo");


        seleziona.setBounds(50, 60, 100, 30 );
    }

    @Override
    public void InitialiteTextIntoFrame(JFrame F) {
        F.add(seleziona);

        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));
    }
}
