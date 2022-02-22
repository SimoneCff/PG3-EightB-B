package it.EightBB.Client;

import it.EightBB.Client.Authentication.Pclient.Button.ExitC;
import it.EightBB.Client.Authentication.Pclient.Button.ModifyProfileC;
import it.EightBB.Client.Authentication.Pclient.TextArea.PrivateClient;
import it.EightBB.Client.Authentication.Powner.TextArea.PrivateOwner;
import it.EightBB.Client.SwingBB.Button;
import it.EightBB.Client.SwingBB.TextGroup;

import javax.swing.*;

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

       public static void main(String[] args){
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

        }
}
