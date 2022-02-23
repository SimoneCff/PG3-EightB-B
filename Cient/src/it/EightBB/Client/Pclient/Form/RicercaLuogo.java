
package it.EightBB.Client.Pclient.Form;


import it.EightBB.Client.Interface.SwingInt.Form;

import javax.swing.*;
import java.awt.*;

public class RicercaLuogo implements Form {
    private JTextField search= null;
    private JLabel searchh = null;

    @Override
    public void setForm() {
        search = new JTextField();
        searchh = new JLabel("Ricerca luogo");
        search.setBounds(400,160,450,30);
        searchh.setBounds(400,130,100,30);
    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
        F.add(search);
        F.add(searchh);
        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));

    }
}
