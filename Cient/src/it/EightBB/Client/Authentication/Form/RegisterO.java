package it.EightBB.Client.Authentication.Form;

import javax.swing.*;

public class RegisterO extends Register {
    private JTextField Cf, Piva = null;
    private JLabel Cff, Pivaa = null;

    @Override
    public void setForm() {
        super.setForm();
        //Fields
        Cf = new JTextField();
        Piva = new JTextField();
        //capire come inserire la data

        //Label:
        Cff = new JLabel("Codice Fiscale");
        Pivaa = new JLabel("P.iva");
        //Capire come fare il Jlabel della data

        //Set Fields:
        Cf.setBounds(350,100,200,30);
        Piva.setBounds(350,160,200,30);
        //Capire prima come fare il bottone e poi capire la forma e posizionamento


        Cff.setBounds(350,70,200,30);
        Pivaa.setBounds(350,130,200,30);
    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
        super.InitialiateFormIntoFrame(F);
        //add Cf Form
        F.add(Cff);
        F.add(Cf);
        //add Piva Form
        F.add(Pivaa);
        F.add(Piva);

    }
}

