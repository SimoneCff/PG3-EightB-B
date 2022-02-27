package it.EightBB.Client.Powner.Form;

import it.EightBB.Client.Interface.Template.Form;

import javax.swing.*;
import java.awt.*;

public class RegClientLive implements Form {
    private JTextField Name, Surname, Cf = null;
    private JLabel Namee, Surnamee, Cff = null;
    private JButton Conf = null;
    private String name = null;


    @Override
    public void setForm() {
        //fields
        Name = new JTextField();
        Surname = new JTextField();
        Cf = new JTextField();

        //Labels
        Namee = new JLabel("Nome");
        Surnamee = new JLabel("Cognome");
        Cff = new JLabel("Codice Fiscale");

        //Button
        Conf = new JButton("Conferma");


        Namee.setBounds(50, 70, 200, 30);
        Surnamee.setBounds(50, 130, 200, 30);
        Cff.setBounds(50, 190, 200, 30);

        Name.setBounds(50, 100, 200, 30);
        Surname.setBounds(50, 160, 200, 30);
        Cf.setBounds(50, 220, 200, 30);

        Conf.setBounds(50, 280, 100, 30);
    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
        F.add(Name);
        F.add(Namee);
        F.add(Surname);
        F.add(Surnamee);
        F.add(Cf);
        F.add(Cff);
        F.add(Conf);

        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));

    }

    public void setName(String name) {
        this.name = name;
    }
}
