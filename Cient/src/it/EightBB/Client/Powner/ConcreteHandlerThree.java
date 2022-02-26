package it.EightBB.Client.Powner;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.Handler.Action.ActionHandler;
import it.EightBB.Client.Powner.Form.ModifyProfile;
import it.EightBB.Client.Powner.Form.RegisterNewStructure;

import java.awt.event.ActionEvent;

public class ConcreteHandlerThree extends ActionHandler {
    private static ActionHandler Instance;

    public static ActionHandler getInstance(){
        if(Instance == null){
            Instance = new ConcreteHandlerThree();
        } return Instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("One :"+e.getActionCommand());
        if (e.getActionCommand().contains("Owner")){
            if (e.getActionCommand().contains("B")) {
                if(e.getActionCommand().contains("Mod")){
                    ClientVisitor.getInstance().visitPowner("Modify",null);
                } else if(e.getActionCommand().contains("MdBack")){
                    ClientVisitor.getInstance().visitPowner("PrivateArea",null); }
                else if (e.getActionCommand().contains("Rowner")){
                    ClientVisitor.getInstance().visitPowner("RStructure",null);
                }
            } else if (e.getActionCommand().contains("FORM")){
                if (e.getActionCommand().contains("Mod")){
                    ModifyProfile.getTextAndSendToDB();
                } else if (e.getActionCommand().contains("RegStruct")){
                    RegisterNewStructure.getFormandSendtoDB();
                }
            }
        }

    }
}
