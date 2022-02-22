package it.EightBB.Client;

import it.EightBB.Client.Authentication.Button.SelectClient;
import it.EightBB.Client.Authentication.Button.SelectOwner;
import it.EightBB.Client.Authentication.Pclient.Button.ExitC;
import it.EightBB.Client.Authentication.Pclient.Button.ModifyProfileC;
import it.EightBB.Client.Authentication.Pclient.TextArea.PrivateClient;
import it.EightBB.Client.Authentication.Powner.Button.*;
import it.EightBB.Client.Authentication.Powner.TextArea.PrivateOwner;
import it.EightBB.Client.Authentication.TextArea.SelectRegistrationType;
import it.EightBB.Client.SwingBB.Button;
import it.EightBB.Client.SwingBB.TextGroup;

import javax.swing.*;
import java.awt.*;

public class Prova {
/**
 * PRENOTAZIONE BB CON SELEZIONE DATA ENTRATA E USCITA
 *
 * public static void main(String[] args){
        JFrame prenotation = new JFrame();

        Form prenotationForm = new PrenotationOne();

      prenotationForm.setForm();
      prenotationForm.InitialiateFormIntoFrame(prenotation);

        prenotation.setLayout(null);
        prenotation.setVisible(true);
        prenotation.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    } */

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
}




