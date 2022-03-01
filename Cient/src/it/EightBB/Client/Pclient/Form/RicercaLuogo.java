
package it.EightBB.Client.Pclient.Form;


import it.EightBB.Client.Interface.Template.Form;

import javax.swing.*;
import java.awt.*;

/**
 * form per l'implementazione della ricerca di un luogo per un'eventuale struttura da prenotare
 * {@param RicercaLuogo} metodo che implementa la ricerca di un luogo
 */
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

    /**
     *
     * @param F parametro di Jframe del Form
     */
    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
        F.add(search);
        F.add(searchh);
        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));

    }
}
