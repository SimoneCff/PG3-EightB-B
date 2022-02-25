package it.EightBB.Client.Authentication.Form;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.SocketInterface;
import it.EightBB.Client.Interface.Template.Form;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

public class Register implements Form, Cloneable {
    private static JTextField Name, Sur, Us = null;
    private static JPasswordField Ps = null;
    private JLabel Namee, Surr, Uss, Pss, Reg = null;
    private JButton RegConfBt = null;
    private JFrame Frame;


    @Override
    public void setForm() {
        //Fields
        Name = new JTextField();
        Sur = new JTextField();
        Us = new JTextField();
        Ps = new JPasswordField();
        RegConfBt = new JButton("Registrati!");

        //Label:
        Namee = new JLabel("Nome");
        Surr = new JLabel("Cognome");
        Uss = new JLabel("Mail");
        Pss = new JLabel("Password");
        Reg = new JLabel("Registrazione");

        //Set Fields:
        Name.setBounds(50, 100, 200, 30);
        Sur.setBounds(50, 160, 200, 30);
        Us.setBounds(50, 240, 200, 30);
        Ps.setBounds(50, 300, 200, 30);

        //Set Label:
        Reg.setBounds(50, 15, 200, 40);
        Reg.setFont(new Font("Arial", Font.PLAIN, 30));

        Namee.setBounds(50, 70, 200, 30);
        Surr.setBounds(50, 130, 200, 30);
        Uss.setBounds(50, 210, 200, 30);
        Pss.setBounds(50, 270, 200, 30);

        //set Button
        RegConfBt.setBounds(350, 300, 200, 30);
        RegConfBt.setActionCommand("Auth-BFORM-RC");
        RegConfBt.addActionListener(new ConcreteHanlderOne());
    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
        this.Frame = F;
        //add Name Form
        F.add(Namee);
        F.add(Name);
        //add Surname Form
        F.add(Surr);
        F.add(Sur);
        //add User Form
        F.add(Uss);
        F.add(Us);
        //add pass Form
        F.add(Pss);
        F.add(Ps);

        F.add(Reg);
        //Add Button

        F.add(RegConfBt);
    }

    public static String getUserFromForm(){
        return "mail," + Us.getText() + ",password," + new String(Ps.getPassword()) ;
    }

   public static String getStringFromForm(){
       return  ",Nome," + Name.getText() + ",cognome," + Sur.getText();
   }

    public static void getTextAndSendToDB() {
        SocketInterface SP = SocketProxy.getIstance();
        try {
            String req ="Auth," + "Register," + "client," + getUserFromForm()+ ",type,client" + getStringFromForm();
            SP.write(req);
            String Result = SP.read();
            if (Result.equals("False")) {
                JOptionPane.showMessageDialog(new JFrame(), "Error, Registrazione Non Avvenuta O Utente Esistente", "Error", JOptionPane.ERROR_MESSAGE);
            } else{
                StringBuilder q = new StringBuilder(getUserFromForm()+getStringFromForm());
                q.append(0);
                q.append(1);
                q.append(2);
                q.append(3);
                ClientVisitor.getInstance().visitPclient("PrivateArea", q.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public JButton returnButton(){
        return RegConfBt;
    }
}



