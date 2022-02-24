package it.EightBB.Client.Powner;



import it.EightBB.Client.CEssentials.FactoryMaker;
import it.EightBB.Client.Interface.Factory.AbstractFactory;
import it.EightBB.Client.Interface.Template.Form;
import it.EightBB.Client.Powner.Button.GoBackO;
import it.EightBB.Client.Powner.Form.ModifyRegisteredStructure;
import it.EightBB.Client.Powner.Form.RegisterNewStructure;


import javax.swing.*;
import java.awt.*;

public class PownerFacade{
    private static PownerFacade Instance;
    private JFrame F;
    private FactoryMaker FM;
    private AbstractFactory POF;

    public static PownerFacade getInstance(){
        if(Instance==null){
            Instance = new PownerFacade();
        } return Instance;
    }

    public JFrame getF(){ return F;}

    public PownerFacade(){
        this.FM = FactoryMaker.getInstance();
        this.POF = FM.getFactory("powner");
    }

    public void setF(JFrame f) { F = f; }

    public void inizialize(String S){
        switch (S){
        }
    }

    /*void RegNewStr(){
        JFrame RegisterStr = new JFrame();
        Form RegisterStrForm = new RegisterNewStructure();
        Button Annulla = new GoBackO();

        Annulla.setButton();
        Annulla.InitialiteButtonIntoFrame(RegisterStr);


        RegisterStrForm.setForm();
        RegisterStrForm.InitialiateFormIntoFrame(RegisterStr);

        RegisterStr.setLayout(null);
        RegisterStr.setVisible(true);
        RegisterStr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    void ModRegStr(){
        JFrame ModifyStr = new JFrame();
        Form ModifyStrForm = new ModifyRegisteredStructure();
        Button Annulla = new GoBackO();

        Annulla.setButton();
        Annulla.InitialiteButtonIntoFrame(RegisterStr);

        ModifyStrForm.setForm();
        ModifyStrForm.InitialiateFormIntoFrame(ModifyStr);


        ModifyStr.setLayout(null);
        ModifyStr.setVisible(true);
        ModifyStr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }*/
}

