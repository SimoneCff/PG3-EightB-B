package it.EightBB.Client.Pclient;

import it.EightBB.Client.CEssentials.FactoryMaker;
import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Interface.SocketInterface;
import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Interface.Template.TextGroup;
import it.EightBB.Client.Pclient.Form.PrenotationOne;
import it.EightBB.Client.Pclient.Form.RicercaLuogo;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

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

    public void Payment() {
        F.getContentPane().removeAll();
        F.repaint();
        Form PayForm = PCF.makeForm("Payment");

        PayForm.setForm();
        PayForm.InitialiateFormIntoFrame(F);
    }

    public void Booked() {
        F.getContentPane().removeAll();
        F.repaint();
        Button Annulla = PCF.makeButton("ModBack");

        Annulla.setButton();
        Annulla.InitialiteButtonIntoFrame(F);

        SocketInterface proxy = SocketProxy.getIstance();
        try{
            proxy.write("Client,getk,booking1,mail,"+getMail().trim());
            String q =" ," + proxy.read();
            List<String> L = List.of(q.split("-"));
            int size = L.size();
            for(int i = 0; i<size; i++) {
                String[] label = L.get(i).split(",");

                JLabel name = new JLabel(label[0]);
                JLabel n_person = new JLabel(label[2]);
                JLabel n_child = new JLabel(label[3]);
                JLabel date_start = new JLabel(label[4]);
                JLabel date_end = new JLabel(label[5]);
                JLabel pay_type = new JLabel(label[6]);
                JLabel  pay_data = new JLabel(label[7]);

                name.setBounds(50, 100+(50*i), 100, 30);
                n_person.setBounds(80, 100+(50*i), 100, 30);
                n_child.setBounds(110, 100+(50*i), 100, 30);
                date_start.setBounds(140, 100+(50*i), 100, 30);
                date_end.setBounds(170, 100+(50*i), 100, 30);
                pay_type.setBounds(200, 100+(50*i), 100, 30);
                pay_data.setBounds(230, 100+(50*i), 100, 30);

                F.add(name);
                F.add(n_person);
                F.add(n_person);
                F.add(n_child);
                F.add(date_start);
                F.add(date_end);
                F.add(pay_type);
                F.add(pay_data);
            }

            F.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
