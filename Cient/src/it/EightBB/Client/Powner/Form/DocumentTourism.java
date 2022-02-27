package it.EightBB.Client.Powner.Form;

import it.EightBB.Client.Client;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.Template.Form;

import javax.swing.*;
import java.awt.*;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * implementazione del form per l'invio dei documenti realativi alla struttura.
 * I documenti sono destinati alla questura e all'ente del turismo.
 * {@param DocumentTourism}
 *
 */
public class DocumentTourism extends Component implements Form {
    private JLabel seleziona = null;
    private JButton selezionaFile = null;

    @Override
    public void setForm() {
        selezionaFile = new JButton("SELEZIONA");
        seleziona = new JLabel("Selezionare il file da inviare alla questura/ente turismo");

        selezionaFile.setBounds(100, 100, 400, 400);
       seleziona.setBounds(100, 160, 400, 400);
        selezionaFile.addActionListener(e -> {selezionaFile();});
    }

    @Override
    public void InitialiateFormIntoFrame(JFrame F) {
        F.add(selezionaFile);
        F.add(seleziona);

        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));

    }
    
    public void selezionaFile(){
        JFileChooser chooser = new JFileChooser();
        //Setting chooser options
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File F = chooser.getSelectedFile();
            String Fname = F.getName().toString();
            int FileSize =(int) F.length();
            System.out.println(Fname+FileSize);
            ClientVisitor.getInstance().visitPowner("PrivateArea",null);
        }
    }
}