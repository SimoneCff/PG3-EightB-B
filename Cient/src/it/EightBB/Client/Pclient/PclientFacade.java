package it.EightBB.Client.Pclient;

import it.EightBB.Client.CEssentials.FactoryMaker;
import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Template.TextGroup;
import it.EightBB.Client.Pclient.Form.PrenotationOne;
import it.EightBB.Client.Pclient.Form.RicercaLuogo;

import javax.swing.*;

public class PclientFacade {
    private static PclientFacade Instance;
    private JFrame F;
    private FactoryMaker FM;
    private AbstractFactory PCF;
    private String[] text;

    public static PclientFacade getInstance(){
        if(Instance==null){
            Instance = new PclientFacade();
        } return Instance;
    }

    public JFrame getF(){ return F;}

    public PclientFacade(){
        this.FM = FactoryMaker.getInstance();
        this.PCF = FM.getFactory("pclient");
    }

    public void setF(JFrame f) { F = f; }

    public void setText(String text){
        this.text = text.split(",");
    }


    void Prenot(){
        F.getContentPane().removeAll();
        F.repaint();

        JFrame prenotation = new JFrame();

        Form prenotationForm = new PrenotationOne();

        prenotationForm.setForm();
        prenotationForm.InitialiateFormIntoFrame(prenotation);

        prenotation.setLayout(null);
        prenotation.setVisible(true);
        prenotation.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void Search(){
        F.getContentPane().removeAll();
        F.repaint();

        JFrame AreaRicerca = new JFrame();
        Form ricerca = new RicercaLuogo();
        //  Button BenvenutoUser =new WelcomeUser(); DA IMPLEMENTARE

        JLabel immagine = new JLabel();
        immagine.setIcon(new ImageIcon("C:\\Users\\Giuse\\IdeaProjects\\PG3-EightB-B\\foto_80x80.jpeg"));
        immagine.setBounds(1000,18,80 ,80);
        immagine.setVisible(true);


        //  BenvenutoUser.setButton();
        //  BenvenutoUser.InitialiteButtonIntoFrame(AreaRicerca);

        ricerca.setForm();
        ricerca.InitialiateFormIntoFrame(AreaRicerca);

        AreaRicerca.setLayout(null);
        AreaRicerca.setVisible(true);
        AreaRicerca.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AreaRicerca.add(immagine);
    }

    public void PrivateArea() {
        F.getContentPane().removeAll();
        F.repaint();
        TextGroup Frameprivateareatext = PCF.makeText("Private");

        //Set Dynamic Textroup
        JLabel Name = new JLabel(text[3]);
        JLabel Surname = new JLabel(text[4]);
        JLabel Mail = new JLabel(text[1]);
        JLabel Pass = new JLabel(text[2]);
        //Set Text
        F.add(Name);
        F.add(Surname);
        F.add(Mail);
        F.add(Pass);

        //Set Labels
        Name.setBounds(300,100,200,30);
        Surname.setBounds(300,160,200,30);
        Mail.setBounds(300,280,200,30);
        Pass.setBounds(300,340,200,30);

        //Frame
        Frameprivateareatext.setText();
        Frameprivateareatext.InitialiteTextIntoFrame(F);

        //Setting Factory
        Button uscita = PCF.makeButton("Exit");
        Button modifica =  PCF.makeButton("Mod");
        Button prenota = PCF.makeButton("Prenota");
        Button booked = PCF.makeButton("Booked");

        //Setting Up
        uscita.setButton();
        modifica.setButton();
        prenota.setButton();
        booked.setButton();

        //SetFrame
        uscita.InitialiteButtonIntoFrame(F);
        modifica.InitialiteButtonIntoFrame(F);
        prenota.InitialiteButtonIntoFrame(F);
        booked.InitialiteButtonIntoFrame(F);




    }
}
