package it.EightBB.Client;

import it.EightBB.Client.Interface.Template.Button;
import it.EightBB.Client.Interface.Template.TextGroup;
import it.EightBB.Client.Powner.TextArea.SelectEnte;

import javax.swing.*;

public class Prova {
/**
 * PRENOTAZIONE BB CON SELEZIONE DATA ENTRATA E USCITA
 *
  public static void main(String[] args){
        JFrame prenotation = new JFrame();

        Form prenotationForm = new PrenotationOne();

      prenotationForm.setForm();
      prenotationForm.InitialiateFormIntoFrame(prenotation);

        prenotation.setLayout(null);
        prenotation.setVisible(true);
        prenotation.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }*/

/**
 * AREA PRIVATA CLIENTE CON BOTTONI DI MODIFICA E USCITA INCLUSI
 *
 * public static void main(String[] args){
            JFrame Frameprivatearea = new JFrame();
            TextGroup Frameprivateareatext = new PrivateClient();

            Button uscita = new ExitC();
            Button modifica = new ModifyProfileC();

            Frameprivateareatext.setText();
            Frameprivateareatext.InitialiteTextIntoFrame(Frameprivatearea);

            uscita.setButton();
            uscita.InitialiteButtonIntoFrame(Frameprivatearea);
            modifica.setButton();
            modifica.InitialiteButtonIntoFrame(Frameprivatearea);

            Frameprivatearea.setLayout(null);
            Frameprivatearea.setVisible(true);
            Frameprivatearea.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        }*/

/**
 * RICERCA LUOGO, DOPO AVER CERCATO SI VISUALIZZA LA LISTA DEI RISULTATI (ANCORA DA IMPLEMENTARE) E CI SI PUÒ CLICCARE SOPRA
 *
 *
    public static void main(String[] args){
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
    }*/

/*
    public static void main(String[] args) {
        JFrame Payment = new JFrame();
        Form PayForm = new PaymentPage();

        PayForm.setForm();
        PayForm.InitialiateFormIntoFrame(Payment);

        Payment.setLayout(null);
        Payment.setVisible(true);
        Payment.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}*/

/**
    public static void main(String[] args){
        JFrame docQuest = new JFrame();
        Form docQuestForm = new DocumentQuesture();

        docQuestForm.setForm();
        docQuestForm.InitialiateFormIntoFrame(docQuest);

        docQuest.setLayout(null);
        docQuest.setVisible(true);
        docQuest.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }*/
/**
public static void main (String[] args){
    JFrame RegClient = new JFrame();
    Form RegForm = new RegClientLive();

    RegForm.setForm();
    RegForm.InitialiateFormIntoFrame(RegClient);

    RegClient.setLayout(null);
    RegClient.setVisible(true);
    RegClient.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}*/
    public static void main (String[] args){
        JFrame SelEnt = new JFrame();
        TextGroup SelEntT = new SelectEnte();

        SelEntT.setText();
        SelEntT.InitialiteTextIntoFrame(SelEnt);


        SelEnt.setLayout(null);
        SelEnt.setVisible(true);
        SelEnt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}






