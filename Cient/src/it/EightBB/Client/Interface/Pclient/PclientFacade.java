package it.EightBB.Client.Interface.Pclient;

import it.EightBB.Client.CEssentials.FactoryMaker;
import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Pclient.Form.PrenotationOne;
import it.EightBB.Client.Interface.Pclient.Form.RicercaLuogo;

import javax.swing.*;

public class PclientFacade {
    private static PclientFacade Instance;
    private String text;
    private JFrame F;
    private FactoryMaker FM;
    private AbstractFactory PCF;

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

    public void setText(String toString) {
    }

    public void PrivateArea() {
    }
}
