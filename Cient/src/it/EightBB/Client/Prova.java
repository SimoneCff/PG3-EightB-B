package it.EightBB.Client;


import it.EightBB.Client.Authentication.Pclient.Button.ExitC;
import it.EightBB.Client.Authentication.Pclient.Button.ModifyProfileC;
import it.EightBB.Client.Authentication.Pclient.TextArea.PrivateClient;
import it.EightBB.Client.SwingBB.Button;
import it.EightBB.Client.SwingBB.TextGroup;

import javax.swing.*;

public class Prova {
/**    public static void main(String[] args){
        JFrame pippo = new JFrame();

        Form pippoform = new PrenotationOne();

        pippoform.setForm();
        pippoform.InitialiateFormIntoFrame(pippo);

        pippo.setLayout(null);
        pippo.setVisible(true);
        pippo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
