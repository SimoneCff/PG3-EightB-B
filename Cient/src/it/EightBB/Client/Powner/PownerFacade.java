package it.EightBB.Client.Powner;



import it.EightBB.Client.CEssentials.FactoryMaker;
import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.Client;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Interface.SocketInterface;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Template.TextGroup;
import it.EightBB.Client.Powner.Form.RegClientLive;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
        Button gestioneEco = POF.makeButton("Econm");
        Button entiNaz = POF.makeButton("PrivAreaEnt");
        Button registrazioneStruttura = POF.makeButton("RegStruct");

        Frameprivateareatext.setText();
        Frameprivateareatext.InitialiteTextIntoFrame(F);

        //Set strutture button
        strutture.setButton();
        strutture.InitialiteButtonIntoFrame(F);
        //Set registrazioneCliente button
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

        ModifyStrForm.setForm();
        ModifyStrForm.InitialiateFormIntoFrame(F);

        Annulla.setButton();
        Annulla.InitialiteButtonIntoFrame(F);

    }

    public void RegNewStr(){
        F.getContentPane().removeAll();
        F.repaint();
        Form RegisterStrForm = POF.makeForm("RegNewStr");
        Button Annulla = POF.makeButton("ModBack");

        Annulla.setButton();
        Annulla.InitialiteButtonIntoFrame(F);


        RegisterStrForm.setForm();
        RegisterStrForm.InitialiateFormIntoFrame(F);


    }

    public void RegisteredStructure(){
        F.getContentPane().removeAll();
        F.repaint();

        SocketInterface proxy = SocketProxy.getIstance();
        try{
            proxy.write("Owner,gettura,structure,mail,"+getMail().replaceAll("\\s+",""));
            List<String> L =  Arrays.asList(proxy.read().split(","));
            System.out.println(L);
            int size = L.size();
            for(int i = 0; i<size; i++){
                JLabel name = new JLabel(L.get(i));
                JButton regclient = new JButton("Registra cliente");
                name.setBounds(50, 100+(50*i), 70, 30);
                regclient.setBounds(250, 100+(50*i), 120 ,30);

                F.add(name);
                F.add(regclient);

                int finalI = i;
                regclient.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        F.getContentPane().removeAll();
                        F.repaint();

                        RegClientLive cli = new RegClientLive();
                        JButton Back = new JButton("Indietro");
                        Back.setBounds(250,300,100,20);
                        F.add(Back);
                        Back.setActionCommand("Owner-B-Client");
                        Back.addActionListener(ConcreteHandlerThree.getInstance());
                        cli.setName(L.get(finalI));
                        cli.setForm();
                        cli.InitialiateFormIntoFrame(F);
                    }
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Button Back = POF.makeButton("ModBack");
        Back.setButton();
        Back.InitialiteButtonIntoFrame(F);
    }

}



