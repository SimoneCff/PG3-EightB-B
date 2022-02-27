package it.EightBB.Client.Powner.Form;

import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.SocketInterface;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Powner.ConcreteHandlerThree;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * implementazione del form di Registrazione del cliente all'arrivo in struttura.
 * il proprietario, nella pagina dedicata, immette i dati del cliente, e procede,
 * alla comparazione e verifica dei dati, affinche' risultino uguali a quelli della prenotazione.
 * {@param RegisterClientLive}
 */
public class RegClientLive implements Form {
    private static JTextField Name, Surname, Cf = null;
    private JLabel Namee, Surnamee, Cff = null;
    private JButton Conf = null;
    private static String name = null;


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

        Conf.addActionListener(ConcreteHandlerThree.getInstance());
        Conf.setActionCommand("Owner-FORM-Client");
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


    public void setName(String s) {
        this.name=s;
    }

    public static void getTextAndSendToDB() {
        SocketInterface SP = SocketProxy.getIstance();
        try {
            String req="Owner,RegClient,client_live,nome,"+name+",name_p,"+Name.getText()+",surname_p,"
                    +Surname.getText()+",CF,"+Cf.getText();
            SP.write(req);
            String res =SP.read();
            if (res.equals("False")){
                JOptionPane.showMessageDialog(new JFrame(), "Error, Registrazione nona avvenuta", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Fatto!, Cliente Registrato", "Success",JOptionPane.INFORMATION_MESSAGE);
                ClientVisitor.getInstance().visitPowner("PrivateArea",null);
            }
         } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
