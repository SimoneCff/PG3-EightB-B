package it.EightBB.Client;

import it.EightBB.Client.Authentication.Pclient.Button.WelcomeUser;
import it.EightBB.Client.Pclient.TextArea.RicercaLuogo;
import it.EightBB.Client.SwingBB.Form;
import it.EightBB.Client.SwingBB.TextGroup;
import it.EightBB.Client.SwingBB.Button;
import it.EightBB.Client.Pclient.Form.PrenotationOne;
import it.EightBB.Client.Pclient.Button.ExitC;
import it.EightBB.Client.Pclient.Button.ModifyProfileC;
import it.EightBB.Client.Powner.Button.AllOwnerStructures;
import it.EightBB.Client.Powner.Button.ClientRegistration;
import it.EightBB.Client.Powner.Button.EconomicManagement;
import it.EightBB.Client.Powner.Button.ExitO;
import it.EightBB.Client.Powner.Button.ModifyProfileO;
import it.EightBB.Client.Powner.Button.PrivateAreaEntities;
import it.EightBB.Client.Powner.Button.RegisterStructure;
import it.EightBB.Client.Powner.TextArea.PrivateOwner;
import it.EightBB.Client.Powner.PownerFactory;

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
 * AREA PRIVATA DEL PROPRIETARIO, INCLUSI BOTTONI VARII (GUARDARE PP ING)
 *
 *
    public static void main(String[] args){
        JFrame Frameprivatearea = new JFrame();
        TextGroup Frameprivateareatext = new PrivateClient();

        Button uscita = new ExitC();
        Button modifica = new ModifyProfileC();

        Button strutture = new AllOwnerStructures();
        Button registrazioneCliente = new ClientRegistration();
        Button gestioneEco = new EconomicManagement();
        Button entiNaz = new PrivateAreaEntities();
        Button registrazioneStruttura = new RegisterStructure();

        Frameprivateareatext.setText();
        Frameprivateareatext.InitialiteTextIntoFrame(Frameprivatearea);

        //Set strutture button
        strutture.setButton();
        strutture.InitialiteButtonIntoFrame(Frameprivatearea);
        //Set registrazioneCliente button
        registrazioneCliente.setButton();
        registrazioneCliente.InitialiteButtonIntoFrame(Frameprivatearea);
        //Set gestioneEco button
        gestioneEco.setButton();
        gestioneEco.InitialiteButtonIntoFrame(Frameprivatearea);
        //Set entiNaz button
        entiNaz.setButton();
        entiNaz.InitialiteButtonIntoFrame(Frameprivatearea);
        //Set registrazioneStruttura button
        registrazioneStruttura.setButton();
        registrazioneStruttura.InitialiteButtonIntoFrame(Frameprivatearea);

        //Set uscita button
        uscita.setButton();
        uscita.InitialiteButtonIntoFrame(Frameprivatearea);
        //Set modifica button
        modifica.setButton();
        modifica.InitialiteButtonIntoFrame(Frameprivatearea);

            JLabel immagine = new JLabel();
            immagine.setIcon(new ImageIcon("C:\\Users\\Giuse\\IdeaProjects\\PG3-EightB-B\\foto.jpg"));
            immagine.setBounds(945,100,200 ,200);
            immagine.setVisible(true);

        Frameprivatearea.setLayout(null);
        Frameprivatearea.setVisible(true);
        Frameprivatearea.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Frameprivatearea.add(immagine);

    }
}*/

/**
 *  AREA SELEZIONE TIPO REGISTRAZIONE, INCLUSI TASTI CLIENTE E PROPRIETARIO
 *
 *
public static void main(String[] args){

        JFrame selectionTypeReg = new JFrame();
        TextGroup selectionTypeRegfinal = new SelectRegistrationType();

        Button SelectC = new SelectClient();
        Button SelectO = new SelectOwner();

        selectionTypeRegfinal.setText();
        selectionTypeRegfinal.InitialiteTextIntoFrame(selectionTypeReg);

        SelectC.setButton();
        SelectC.InitialiteButtonIntoFrame(selectionTypeReg);

        SelectO.setButton();
        SelectO.InitialiteButtonIntoFrame(selectionTypeReg);

        selectionTypeReg.setLayout(null);
        selectionTypeReg.setVisible(true);
        selectionTypeReg.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }*/
    /**

     AREA PER LA RICERCA DEL B&B

    public static void main(String[] args){
        JFrame AreaRicerca = new JFrame();
       Form ricerca = new RicercaLuogo();
       Button BenvenutoUser = new WelcomeUser();

       JLabel immagine = new JLabel();
        immagine.setIcon(new ImageIcon("C:\\Users\\Giuse\\IdeaProjects\\PG3-EightB-B\\foto_80x80.jpeg"));
        immagine.setBounds(1000,18,80 ,80);
        immagine.setVisible(true);


       BenvenutoUser.setButton();
       BenvenutoUser.InitialiteButtonIntoFrame(AreaRicerca);


       ricerca.setForm();
       ricerca.InitialiateFormIntoFrame(AreaRicerca);

       AreaRicerca.setLayout(null);
       AreaRicerca.setVisible(true);
       AreaRicerca.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       AreaRicerca.add(immagine);
    }*/
}




