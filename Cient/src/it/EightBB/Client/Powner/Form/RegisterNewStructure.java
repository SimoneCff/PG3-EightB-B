package it.EightBB.Client.Powner.Form;

import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.SocketInterface;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Powner.ConcreteHandlerThree;
import it.EightBB.Client.Powner.PownerFacade;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * implementazione del form di registrazione di una struttura.
 * il proprietario, accedendo alla sua pagina personale, puo' aggiungere una struttura
 *inserendo i dati della struttura, come il nome, la posizione, i contatti, e tutti i servizi offerti.
 * {@param RegisterNewStructure}
 */
public class RegisterNewStructure implements Form {
    private static JTextField Name, Address,n_room, telephone, services, description = null;
    private JLabel Namee, Addresss, n_roomm, telephonee, servicess, descriptionn = null;
    private JButton confirmation = null;

    @Override
    public void setForm(){
        //Text Fields
        Name = new JTextField();
        Address = new JTextField();
        n_room = new JTextField();
        telephone = new JTextField();
        services = new JTextField();
        description = new JTextField();


        //Labels
        Namee = new JLabel("Nome struttura");
        Addresss = new JLabel("Indirizzo");
        n_roomm = new JLabel("Numero stanze");
        telephonee = new JLabel("Numero di telefono");
        servicess = new JLabel("Servizi offerti");
        descriptionn = new JLabel("Descrizione struttura");

        //Button
        confirmation = new JButton("Conferma");

        //set Text
        Name.setBounds(200,100,200,30);
        Address.setBounds(200,160,200,30);
        n_room.setBounds(200,220,200,30);
        telephone.setBounds(550,100,200,30);
        services.setBounds(550,160,200,90);
        description.setBounds(200,280,550,90);

        //Set Labels
        Namee.setBounds(200,70,200,30);
        Addresss.setBounds(200,130,200,30);
        n_roomm.setBounds(200,190,200,30);
        telephonee.setBounds(550,70,200,30);
        servicess.setBounds(550,130,200,30);
        descriptionn.setBounds(200,250,200,30);

        //set Button
        confirmation.setBounds(650,380,100,30);
        confirmation.setActionCommand("Owner-FORM-RegStruct");
        confirmation.addActionListener(ConcreteHandlerThree.getInstance());

    }
    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
        //adding Fields
        F.add(Name);
        F.add(Address);
        F.add(n_room);
        F.add(telephone);
        F.add(services);
        F.add(description);

        //adding Labels
        F.add(Namee);
        F.add(Addresss);
        F.add(n_roomm);
        F.add(telephonee);
        F.add(servicess);
        F.add(descriptionn);

        //adding Button
        F.add(confirmation);

        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));
    }

    public static void getFormandSendtoDB(){
        SocketInterface SP = SocketProxy.getIstance();
        try{
            String q = "Owner,RegStruct,structure,mail,"+
                    PownerFacade.getInstance().getMail().replaceAll("\\s+","")+",nome,"+ Name.getText()+
                    ",via,"+Address.getText()+",n_camere,"+n_room.getText()+",telefono,"+telephone.getText()
                    +",descrizione,"+description.getText()+",service,"+ services.getText();
            SP.write(q);
            String Result = SP.read();
            if (Result.equals("False")) {
                JOptionPane.showMessageDialog(new JFrame(), "Error, Registrazione nona avvenuta o Struttura esistente", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Fatto!, Struttura Registrata", "Success",JOptionPane.INFORMATION_MESSAGE);
                ClientVisitor.getInstance().visitPowner("PrivateArea",null);
            }

            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }



