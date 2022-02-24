package it.EightBB.Client.Authentication.Form;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.Interface.Pclient.PclientFacade;
import it.EightBB.Client.Interface.SocketInterface;
import it.EightBB.Client.Powner.PownerFacade;
import it.EightBB.Client.Powner.PownerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class RegisterO extends Register {
    private static JTextField Cf, Piva = null;
    private JLabel Cff, Pivaa = null;
    private JButton RegConfBt = null;

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

        RegConfBt = new JButton("Registrati!");
        RegConfBt.setBounds(350, 300, 200, 30);
        RegConfBt.setActionCommand("Auth-BFORM-RO");
        RegConfBt.addActionListener(new ConcreteHanlderOne());
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

    public static void getTextAndSendToDB() {
        SocketInterface SP = SocketProxy.getIstance();
        try {
            String req ="Auth," + "RegisterO," + "owner," + getStringFromForm();
            String od="p.iva," + Piva.getText() + ",Cf," + Cf.getText();
            SP.write(req + od);
            String Result = SP.read();
            System.out.println(Result);
            if (Result.equals("False")) {
                JOptionPane.showMessageDialog(new JFrame(), "Error, Registrazione Non Avvenuta O Utente Esistente", "Error", JOptionPane.ERROR_MESSAGE);
            } else{
                PownerFacade.getInstance().setText(getStringFromForm()+od);
                PownerFacade.getInstance().PrivateArea();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}

