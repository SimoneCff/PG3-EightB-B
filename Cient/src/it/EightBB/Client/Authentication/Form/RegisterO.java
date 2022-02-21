package it.EightBB.Client.Authentication.Form;

import javax.swing.*;
import java.awt.*;

public class RegisterO extends Register{
    private JTextField Name, Sur, Cf, Us, Piva = null;
    private JPasswordField Ps = null;
    private JLabel Namee, Surr, Cff, Uss, Pivaa, Pss, Reg = null;
    private JSeparator Sep = null;


    @Override
    public void setForm(){
        //Fields
        Name = new JTextField();
        Sur = new JTextField();
        Cf = new JTextField();
        Us = new JTextField();
        Piva = new JTextField();
        Ps = new JPasswordField();
        //capire come inserire la data

        //Label:
        Namee = new JLabel("Nome");
        Surr = new JLabel("Cognome");
        Cff = new JLabel("Codice Fiscale");
        Uss = new JLabel("Mail");
        Pivaa = new JLabel("P.iva");
        Pss = new JLabel("Password");
        //Capire come fare il Jlabel della data

        //Set Fields:
        Name.setBounds(50,100,200,30);
        Sur.setBounds(50,160,200,30);
        Cf.setBounds(50,220,200,30);
        Us.setBounds(50,280,200,30);
        Piva.setBounds(50,340,200,30);
        Ps.setBounds(50,400,200,30);
        //Capire prima come fare il bottone e poi capire la forma e posizionamento

        //Set Label:
        Reg.setBounds(50,15,200,40);
        Reg.setFont(new Font("Arial", Font.PLAIN, 30));

        Namee.setBounds(50,100,200,30);
        Surr.setBounds(50,160,200,30);
        Cff.setBounds(50,220,200,30);
        Uss.setBounds(50,280,200,30);
        Pivaa.setBounds(50,340,200,30);
        Pss.setBounds(50,400,200,30);
    }

    @Override
    public void InitialateFormIntoFrame(JFrame O){;
        //add Name Form
        O.add(Namee);
        O.add(Name);
        //add Surname Form
        O.add(Surr);
        O.add(Sur);
        //add Cf Form
        O.add(Cff);
        O.add(Cf);
        //add User Form
        O.add(Uss);
        O.add(Us);
        //add Piva Form
        O.add(Pivaa);
        O.add(Piva);
        //add pass Form
        O.add(Pss);
        O.add(Ps);
    }
}
