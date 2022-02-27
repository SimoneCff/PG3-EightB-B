package it.EightBB.Client.Pclient.Form;

import com.toedter.calendar.JDateChooser;
import it.EightBB.Client.Interface.Template.Form;
import javax.swing.*;
import java.awt.*;

public class PrenotationOne implements Form{
    private JTextField research, n_adults, n_childrens = null;
    private JDateChooser StartDate = null;
    private JDateChooser EndDate = null;
    private JLabel researchh, n_adultss, n_childrenss, StartDatee, EndDatee = null;
    private JButton ConfBt = null;


    public void setForm(){
        //Fields
        research = new JTextField();
        n_adults = new JTextField();
        n_childrens = new JTextField();
        //Date chooser
        StartDate = new JDateChooser();
        EndDate = new JDateChooser();
        //Confirm button
        ConfBt = new JButton("Conferma");

        //Labels
        researchh = new JLabel("ricerca luogo");
        n_adultss = new JLabel("Numero adulti");
        n_childrenss = new JLabel("Numero bambini");
        StartDatee = new JLabel("Data inizio");
        EndDatee = new JLabel("Data fine");

        //Set Label:
        researchh.setBounds(50,70,200,30);
        n_adultss.setBounds(50,130,200,30);
        n_childrenss.setBounds(300,130,200,30);
        StartDatee.setBounds(50,190,200,30);
        EndDatee.setBounds(300,190,200,30);


        research.setBounds(50,100,200,30);
        n_adults.setBounds(50,160,200,30);
        n_childrens.setBounds(300,160,200,30);
        StartDate.setBounds(50,220,200,30);
        EndDate.setBounds(300,220,200,30);
        ConfBt.setBounds(50,280,200,30);
    }
    @Override
    public void InitialiateFormIntoFrame(JFrame F)
    {
        //add User Form
        F.add(research);
        F.add(researchh);
        //add pass Form
        F.add(n_adults);
        F.add(n_adultss);
        //Add Button
        F.add(n_childrens);
        F.add(n_childrenss);

        F.add(StartDate);
        F.add(StartDatee);

        F.add(EndDate);
        F.add(EndDatee);

        F.add(ConfBt);
        F.setSize(1366, 768);
        F.getContentPane().setBackground(new Color(225,204,204));
    }

}
