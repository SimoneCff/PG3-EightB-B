package it.EightBB.Client.Powner.Form;

import it.EightBB.Client.Interface.Template.Form;

import javax.swing.*;
import java.awt.*;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

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
            try {
                Socket FS = new Socket("82.55.143.63", 5430);
                OutputStream os = FS.getOutputStream();
                PrintWriter pr = new PrintWriter(FS.getOutputStream(),true);
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(F));
                Scanner in = new Scanner(FS.getInputStream());

                //File Wire
                pr.println(Fname);
                pr.println(FileSize);

                byte[] filebyte = new byte[FileSize];
                bis.read(filebyte, 0, filebyte.length);
                os.write(filebyte, 0, filebyte.length);
                System.out.println(in.nextLine());
                os.flush();
                FS.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(F);
        }
    }
}