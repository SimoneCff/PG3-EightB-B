package it.EightBB.Client.Pclient;

import it.EightBB.Client.CEssentials.FactoryMaker;
import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Pclient.Form.PrenotationOne;
import it.EightBB.Client.Pclient.Form.RicercaLuogo;

import javax.swing.*;
import java.awt.*;

public class PclientFacade {
    private static PclientFacade Istance;
    private JFrame F;
    private FactoryMaker FM;
    private AbstractFactory PCF;

    public static PclientFacade getIstance(){
        if(Istance==null){
            Istance = new PclientFacade();
        } return Istance;
    }

    public JFrame getF(){ return F;}

    public PclientFacade(){
        this.FM = FactoryMaker.getInstance();
        this.PCF = FM.getFactory("pclient");
    }

    public void setF(JFrame F) { F = f; }

    public void inizialize(String S){
        switch (S){
        }
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
}
