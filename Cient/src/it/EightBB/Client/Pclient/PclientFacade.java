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


    public void Prenot(){
        F.getContentPane().removeAll();
        F.repaint();


        Form prenotationForm = new PrenotationOne();

        prenotationForm.setForm();
        prenotationForm.InitialiateFormIntoFrame(F);
    }

    public void Search(){
        F.getContentPane().removeAll();
        F.repaint();

        Form ricerca = new RicercaLuogo();
        //  Button BenvenutoUser =new WelcomeUser(); DA IMPLEMENTARE


        ricerca.setForm();
        ricerca.InitialiateFormIntoFrame(F);
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
        Button modifica =  PCF.makeButton("Mod");
        Button prenota = PCF.makeButton("Prenota");
        Button booked = PCF.makeButton("Booked");

        //Setting Up
        modifica.setButton();
        prenota.setButton();
        booked.setButton();

        //SetFrame
        modifica.InitialiteButtonIntoFrame(F);
        prenota.InitialiteButtonIntoFrame(F);
        booked.InitialiteButtonIntoFrame(F);
    }

    public void ModRegStr() {
        F.getContentPane().removeAll();
        F.repaint();

        Form ModifyStrForm = PCF.makeForm("Mod");
        Button Annulla = PCF.makeButton("ModBack");

        ModifyStrForm.setForm();
        ModifyStrForm.InitialiateFormIntoFrame(F);

        Annulla.setButton();
        Annulla.InitialiteButtonIntoFrame(F);

    }

    public String getMail() {
        return text[1];
    }

    public void Prenotation(){
        F.getContentPane().removeAll();
        F.repaint();

        Form prenotationForm =PCF.makeForm("Prenot");

        prenotationForm.setForm();
        prenotationForm.InitialiateFormIntoFrame(F);
    }
}
