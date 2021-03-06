package it.EightBB.Client.Pclient.Form;

import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.ClientVisitor;
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

/**
 * form di implementazione che gestisce la ricerca delle strutture
 * {@param PrenotationOne} parametro che implemta la pagina di ricerca
 */
public class PrenotationOne implements Form{
    private JTextField research;
    private static JTextField n_adults;
    private static JTextField n_childrens = null;
    private static JTextField StartDate = null;
    private static JTextField EndDate = null;
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

    /**
     *
     * @param F Parametro Jframe del form
     */
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
        F.setSize(1920, 700);
        F.getContentPane().setBackground(new Color(225,204,204));
    }

    public static void getFormandSenditToDB(){
        PrenotationMemento Mori = PrenotationMemento.getIstance();
        Mori.setPrenotationMemento(PclientFacade.getInstance().getMail(), n_adults.getText(), n_childrens.getText(),
               StartDate.getText(), EndDate.getText());
        try {
            String req = "Client,One,booking,mail," + PclientFacade.getInstance().getMail() + ",date_start," +
                    StartDatee.getText() + ",date_end," + EndDatee.getText();
            SocketInterface SP = SocketProxy.getIstance();
            SP.write(req);
            String risp = SP.read();
            if (risp.equals("False")){
                JOptionPane.showMessageDialog(new JFrame(), "Error, Registrazione nona avvenuta", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                List<String> L =  Arrays.asList(risp.split("-"));
                int size = L.size();

                JPanel x = new JPanel();
                x.setBounds(600,100,1300,450);

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

                    name.setBounds(150, 70 + (50 * i), 110, 30);
                    via.setBounds(350, 70 + (50 * i), 120, 30);
                    telefono.setBounds(500, 70+ (50 * i), 70, 30);
                    descrizione.setBounds(650, 70 + (50 * i), 200, 30);
                    service.setBounds(1100, 70 + (50 * i), 200, 30);

                    regclient.setBounds(0, 70 + (50 * i), 120, 30);

                    x.add(name);
                    x.add(via);
                    x.add(telefono);
                    x.add(descrizione);
                    x.add(service);
                    x.add(regclient);

                    regclient.addActionListener(new ActionListener() {
                        /**
                         * @param e Parametro di evento
                         */
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Mori.setnome(label[0]);
                            ClientVisitor.getInstance().setMeme(Mori);
                            ClientVisitor.getInstance().visitPclient("Payment",null);
                        }
                    });

                }
                x.repaint();
                JScrollPane scrollPane = new JScrollPane(x,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.setPreferredSize(x.getPreferredSize());

                F.add(scrollPane);
                F.add(x);
                F.repaint();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
