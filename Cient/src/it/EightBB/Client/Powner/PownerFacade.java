package it.EightBB.Client.Powner;



import it.EightBB.Client.CEssentials.FactoryMaker;
import it.EightBB.Client.Interface.Factory.AbstractFactory;


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


}
