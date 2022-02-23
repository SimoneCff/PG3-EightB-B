package it.EightBB.Client.Authentication.Button;

import it.EightBB.Client.Interface.SwingInt.Button;
import it.EightBB.Client.Pclient.Button.ExitC;
import it.EightBB.Client.Pclient.Button.ModifyProfileC;
import it.EightBB.Client.Pclient.TextArea.PrivateClient;
import it.EightBB.Client.Powner.Button.AllOwnerStructures;
import it.EightBB.Client.Powner.Button.ClientRegistration;
import it.EightBB.Client.Powner.Button.EconomicManagement;
import it.EightBB.Client.Powner.Button.PrivateAreaEntities;
import it.EightBB.Client.Powner.Button.RegisterStructure;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeUser  { /* implements Button
    private JButton Welcome = null;

    public void setButton() {
        Welcome = new JButton("<html>Benvenuto<br />Mario Rossi </html>");
        Welcome.setBounds(1100, 25, 120, 60);

    }

    public void InitialiteButtonIntoFrame(JFrame F) {
       /* REINDIRIZZAMENTO ALL'AREA RISERVATA DEL PROPRIETARIO
        Welcome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        });
        F.add(Welcome);
    }*/
}
