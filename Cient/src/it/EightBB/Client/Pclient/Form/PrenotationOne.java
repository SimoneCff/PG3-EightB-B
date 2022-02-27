package it.EightBB.Client.Pclient.Form;

import com.toedter.calendar.JDateChooser;
import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.Memento;
import it.EightBB.Client.Interface.SocketInterface;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Pclient.ConcreteHandlerTwo;
import it.EightBB.Client.Pclient.Memento.PrenotationMemento;
import it.EightBB.Client.Pclient.PclientFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PrenotationOne implements Form{
    private JTextField research, n_adults, n_childrens = null;
    private JTextField StartDate = null;
    private JTextField EndDate = null;
    private static JLabel researchh, n_adultss, n_childrenss, StartDatee, EndDatee = null;
    private JButton ConfBt = null;
    private static JFrame F;


    public void setForm(){
        //Fields
        research = new JTextField();
        n_adults = new JTextField();
        n_childrens = new JTextField();
        //Date chooser
        StartDate = new JTextField();
        EndDate = new JTextField();
        //Confirm button
        ConfBt = new JButton("Conferma");

        //Labels
        researchh = new JLabel("ricerca luogo");
        n_adultss = new JLabel("Numero adulti");
        n_childrenss = new JLabel("Numero bambini");
        StartDatee = new JLabel("Data inizio");
        EndDatee = new JLabel("Data fine");

        //Set Label:
        researchh.setBounds(50,70,200,30);
        n_adultss.setBounds(50,130,200,30);
        n_childrenss.setBounds(300,130,200,30);
        StartDatee.setBounds(50,190,200,30);
        EndDatee.setBounds(300,190,200,30);


        research.setBounds(50,100,200,30);
        n_adults.setBounds(50,160,200,30);
        n_childrens.setBounds(300,160,200,30);
        StartDate.setBounds(50,220,200,30);
        EndDate.setBounds(300,220,200,30);
        ConfBt.setBounds(50,280,200,30);

        ConfBt.addActionListener(ConcreteHandlerTwo.getInstance());
        ConfBt.setActionCommand("Client-FORM_Pone");
    }
    @Override
    public void InitialiateFormIntoFrame(JFrame F)
    {
        this.F=F;

        //add User Form
        F.add(research);
        F.add(researchh);
        //add pass Form
        F.add(n_adults);
        F.add(n_adultss);
        //Add Button
        F.add(n_childrens);
        F.add(n_childrenss);

        F.add(StartDate);
        F.add(StartDatee);

        F.add(EndDate);
        F.add(EndDatee);

        F.add(ConfBt);
        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));
    }

    public static void getFormandSenditToDB(){
        PrenotationMemento Mori = PrenotationMemento.getIstance();
        Mori.setPrenotationMemento(PclientFacade.getInstance().getMail(), n_adultss.getText(), n_childrenss.getText(),
               StartDatee.getText(), EndDatee.getText());
        try {
            String req = "Client,PrenotOne,booking,mail," + PclientFacade.getInstance().getMail() + ",date_start," +
                    StartDatee.getText() + ",date_end," + EndDatee.getText();
            SocketInterface SP = SocketProxy.getIstance();
            SP.write(req);
            String risp = SP.read();
            if (risp.equals("False")){
                JOptionPane.showMessageDialog(new JFrame(), "Error, Registrazione nona avvenuta", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                List<String> L =  Arrays.asList(risp.split("-"));
                int size = L.size();
                for(int i = 0; i<size; i++) {
                    String[] label = L.get(i).split(",");
                    System.out.println(Arrays.toString(label));
                    //JLabel
                    JLabel name = new JLabel(label[0]);
                    JLabel via = new JLabel(label[1]);
                    JLabel telefono = new JLabel(label[2]);
                    JLabel descrizione = new JLabel(label[3]);
                    JLabel service = new JLabel(label[4]);

                    JButton regclient = new JButton("Prenota");

                    name.setBounds(200, 100 + (50 * i), 70, 30);
                    via.setBounds(200, 120 + (50 * i), 70, 30);
                    telefono.setBounds(200, 140+ (50 * i), 70, 30);
                    descrizione.setBounds(200, 160 + (50 * i), 70, 30);
                    service.setBounds(200, 180 + (50 * i), 70, 30);

                    regclient.setBounds(250, 200 + (50 * i), 120, 30);

                    F.add(name);
                    F.add(via);
                    F.add(telefono);
                    F.add(descrizione);
                    F.add(service);
                    F.add(regclient);

                    regclient.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Mori.setnome(label[0]);
                            ClientVisitor.getInstance().setMeme(Mori);
                            ClientVisitor.getInstance().visitPclient("Payment",null);
                        }
                    });

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
