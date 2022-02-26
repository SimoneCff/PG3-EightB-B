package it.EightBB.Client.Powner.Form;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.Client;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.SocketInterface;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Powner.ConcreteHandlerThree;
import it.EightBB.Client.Powner.PownerFacade;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class ModifyProfile implements Form {
    private static JButton RegConfBt = null;
    private static JTextField Name, Sur = null;
    private static JLabel Namee, Surr, Pss = null;
    private static JPasswordField Ps = null;
    @Override
    public void setForm() {
        //Fields
        Name = new JTextField();
        Sur = new JTextField();
        Ps = new JPasswordField();
        RegConfBt = new JButton("Conferma!");

        //Labels
        Namee = new JLabel("Nome");
        Surr = new JLabel("Cognome");
        Pss = new JLabel("Password");


        //Set Fields:
        Name.setBounds(50, 100, 200, 30);
        Sur.setBounds(50, 160, 200, 30);
        Ps.setBounds(50, 220, 200, 30); //set Button

        Namee.setBounds(50, 70, 200, 30);
        Surr.setBounds(50, 130, 200, 30);
        Pss.setBounds(50, 190, 200, 30); //set Button

        RegConfBt.setBounds(350, 300, 200, 30);
        RegConfBt.setActionCommand("Owner-BFORM-Mod");
        RegConfBt.addActionListener(ConcreteHandlerThree.getInstance());

    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
        F.add(Name);
        F.add(Sur);
        F.add(Ps);

        F.add(Namee);
        F.add(Surr);
        F.add(Pss);
        F.add(RegConfBt);
    }
    public static void getTextAndSendToDB() {
        SocketInterface SP = SocketProxy.getIstance();
        try {
            String req = "Owner," + "Modify," + "owner,"+"mail,"+PownerFacade.getInstance().getMail()+",";
            StringBuilder q = new StringBuilder();
            boolean isLast = false;
            String ps = new String(Ps.getPassword());
            if (!ps.isBlank()) {
                q.append("password,").append(ps);
                isLast = true;
            }
            if (!Name.getText().isBlank()) {
                if (isLast) {
                    q.append(",");
                }
                q.append("Nome,").append(Name.getText());
                isLast = true;
            }
            if (!Sur.getText().isBlank()) {
                if (isLast) {
                    q.append(",");
                }
                q.append("cognome,").append(Sur.getText());
            }
            if (q.isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "Nessun Form Modificato", "Error", JOptionPane.ERROR_MESSAGE);
            }
            SP.write(req + q);
            String Result = SP.read();
            if (Result.equals("False")) {
                JOptionPane.showMessageDialog(new JFrame(), "Error, Modifica non Avvenuta", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Fatto!, Form Modificato", "Success",JOptionPane.INFORMATION_MESSAGE);
                ClientVisitor.getInstance().visitPclient("PrivateArea",null);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    }
