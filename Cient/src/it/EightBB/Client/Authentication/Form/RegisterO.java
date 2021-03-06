package it.EightBB.Client.Authentication.Form;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.SocketInterface;
import it.EightBB.Client.Powner.PownerFacade;


import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * implementazione della fase di registrazione dell'utente Proprietario nel sistema
 * {@param RegisterO} parametro che estende la classe register per la registrazione al sistema
 */
public class RegisterO extends Register {
    private static JTextField Cf, Piva = null;
    private JLabel Cff, Pivaa = null;
    private JButton RegConfBt2 = null;
    private static JFrame Frame;

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

        RegConfBt2 = new JButton("Registrati!");
        RegConfBt2.setBounds(350, 300, 200, 30);
        RegConfBt2.setActionCommand("Auth-BFORM-RO");
        RegConfBt2.addActionListener(new ConcreteHanlderOne());
    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
        super.InitialiateFormIntoFrame(F);
        this.Frame = F;
        //remove Button from super class
        F.remove(super.returnButton());
        //add Cf Form
        F.add(Cff);
        F.add(Cf);
        //add Piva Form
        F.add(Pivaa);
        F.add(Piva);
        //Add new button
        F.add(RegConfBt2);

    }

    public static void getTextAndSendToDB() {
        SocketInterface SP = SocketProxy.getIstance();
        try {
            String req ="Auth," + "Register," + "owner," + getUserFromForm() + ",type,owner"+ getStringFromForm();
            String od=",p.iva," + Piva.getText() + ",Cf," + Cf.getText();
            SP.write(req + od);
            String Result = SP.read();
            if (Result.equals("False")) {
                JOptionPane.showMessageDialog(new JFrame(), "Error, Registrazione Non Avvenuta O Utente Esistente", "Error", JOptionPane.ERROR_MESSAGE);
            } else{
                StringBuilder q = new StringBuilder(getUserFromForm()+getStringFromForm()+od);
                q.append(0);
                q.append(1);
                q.append(2);
                q.append(3);
                q.append(4);
                q.append(5);
                //append text
                ClientVisitor.getInstance().visitPowner("PrivateArea",q.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}

