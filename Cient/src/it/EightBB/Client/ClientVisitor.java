package it.EightBB.Client;

import it.EightBB.Client.Authentication.AuthFacade;
import it.EightBB.Client.Pclient.PclientFacade;
import it.EightBB.Client.Interface.visitor;
import it.EightBB.Client.Powner.PownerFacade;


public class ClientVisitor implements visitor {
private static visitor Instance;;
private ImplementationFacade IF;

    public static visitor getInstance(){
        if (Instance == null){
            Instance = new ClientVisitor();
        } return Instance;
    }

    public void setIF() {
        this.IF = ImplementationFacade.getInstance();
    }

    @Override
    public void visitAuth(String where) {
        AuthFacade AF = AuthFacade.getInstance();
        AF.setF(IF.getFrame());
        switch(where) {
            case "Login" -> AF.Login();
            case "Register" -> AF.Register();
            case "RegisterC" -> AF.RegisterClient();
            case "RegisterO" -> AF.RegisterOwner();
        }

    }

    @Override
    public void visitPclient(String where, String text) {
        PclientFacade PCF = PclientFacade.getInstance();
        PCF.setF(IF.getFrame());
        if (text != null){
            PCF.setText(text);
        }
        switch(where){
            case "PrivateArea"-> PCF.PrivateArea();
            case "Modify" -> PCF.ModRegStr();
            case "Prenota" -> PCF.Prenotation();
            case "Payment" -> PCF.Payment();
            case "Booked" -> PCF.Booked();
        }

    }

    @Override
    public void visitPowner(String where, String text) {
        PownerFacade POF = PownerFacade.getInstance();
        POF.setF(IF.getFrame());
        if (text != null){
            POF.setText(text);
        }
        switch(where){
            case "PrivateArea"-> POF.PrivateArea();
            case "Modify" -> POF.ModRegStr();
            case "RStructure" -> POF.RegNewStr();
            case "Client" -> POF.RegisteredStructure();
            case "Economic" -> POF.Economic();
            case "File" -> POF.File();
        }
    }

}
