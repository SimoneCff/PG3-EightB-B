package it.EightBB.Client.Powner;



import it.EightBB.Client.CEssentials.FactoryMaker;
import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Template.TextGroup;
import it.EightBB.Client.Powner.Button.GoBackO;
import it.EightBB.Client.Powner.Form.ModifyRegisteredStructure;


import javax.swing.*;
import java.awt.*;
import java.sql.Array;

public class PownerFacade{
    private static PownerFacade Instance;
    private JFrame F;
    private FactoryMaker FM;
    private AbstractFactory POF;
    private String[] text;

    public static PownerFacade getInstance(){
        if(Instance==null){
            Instance = new PownerFacade();
        } return Instance;
    }

    public void setText(String text){
        this.text = null;
        this.text = text.split(",");
    }

    public String getMail(){
        return text[1];
    }

    public JFrame getF(){ return F;}

    public PownerFacade(){
        this.FM = FactoryMaker.getInstance();
        this.POF = FM.getFactory("powner");
    }

    public void setF(JFrame f) { F = f; }

    public void PrivateArea(){
        F.getContentPane().removeAll();
        F.repaint();
        TextGroup Frameprivateareatext = POF.makeText("Private");

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

        Button modifica =  POF.makeButton("Mod");

        Button strutture = POF.makeButton("AllOwnStruct");
        Button registrazioneCliente = POF.makeButton("ClientReg");
        Button gestioneEco = POF.makeButton("Econm");
        Button entiNaz = POF.makeButton("PrivAreaEnt");
        Button registrazioneStruttura = POF.makeButton("RegStruct");

        Frameprivateareatext.setText();
        Frameprivateareatext.InitialiteTextIntoFrame(F);

        //Set strutture button
        strutture.setButton();
        strutture.InitialiteButtonIntoFrame(F);
        //Set registrazioneCliente button
        registrazioneCliente.setButton();
        registrazioneCliente.InitialiteButtonIntoFrame(F);
        //Set gestioneEco button
        gestioneEco.setButton();
        gestioneEco.InitialiteButtonIntoFrame(F);
        //Set entiNaz button
        entiNaz.setButton();
        entiNaz.InitialiteButtonIntoFrame(F);
        //Set registrazioneStruttura button
        registrazioneStruttura.setButton();
        registrazioneStruttura.InitialiteButtonIntoFrame(F);

        //Set modifica button
        modifica.setButton();
        modifica.InitialiteButtonIntoFrame(F);
    }


    public void ModRegStr() {
        F.getContentPane().removeAll();
        F.repaint();


        Form ModifyStrForm = POF.makeForm("Mod");
        Button Annulla = POF.makeButton("ModBack");

        Annulla.setButton();
        Annulla.InitialiteButtonIntoFrame(F);

        Annulla.setButton();
        Annulla.InitialiteButtonIntoFrame(F);
    }

    /*void RegNewStr(){
        JFrame RegisterStr = new JFrame();
        Form RegisterStrForm = new RegisterNewStructure();
        Button Annulla = new GoBackO();

        Annulla.setButton();
        Annulla.InitialiteButtonIntoFrame(RegisterStr);


        RegisterStrForm.setForm();
        RegisterStrForm.InitialiateFormIntoFrame(RegisterStr);

        RegisterStr.setLayout(null);
        RegisterStr.setVisible(true);
        RegisterStr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    }*/
}



