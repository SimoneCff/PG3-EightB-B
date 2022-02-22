package it.EightBB.Client.Authentication.Form;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import it.EightBB.Client.SwingBB.Form;
import javax.swing.*;
import java.awt.*;
import java.lang.annotation.Inherited;

public class PrenotationOne {
    private JTextField research, n_adults, n_childrens = null;
    private JCheckBox animals = null;
    private JDateChooser StartDate = null;
    private JDateChooser EndDate = null;
    private JLabel researchh, n_adultss, n_childrenss, animalss, StartDatee, EndDatee = null;


    public void setForm(){
        //Fields
        research = new JTextField();
        n_adults = new JTextField();
        n_childrens = new JTextField();
        //Date chooser
        StartDate = new JDateChooser();
        EndDate = new JDateChooser();
        //Check box
        animals = new JCheckBox();

        //Labels
        researchh = new JLabel("ricerca luogo");
        n_adultss = new JLabel("Numero adulti");
        n_childrenss = new JLabel("Numero bambini");
        animalss = new JLabel("Ammessi animali");
        StartDatee = new JLabel("Data inizio");
        EndDatee = new JLabel("Data fine");

        //Set Label:
        researchh.setBounds(50,70,200,30);
        n_adultss.setBounds(50,130,200,30);
        n_childrenss.setBounds(300,130,200,30);
        animalss.setBounds(600,130,200,30);
        StartDatee.setBounds(50,190,200,30);
        EndDatee.setBounds(300,190,200,30);

        research.setBounds(50,100,200,30);
        n_adults.setBounds(50,160,200,30);
        n_childrens.setBounds(300,160,200,30);
        animals.setBounds(300,160,200,30);
        StartDate.setBounds(50,220,200,30);
        EndDate.setBounds(300,220,200,30);
    }


}
