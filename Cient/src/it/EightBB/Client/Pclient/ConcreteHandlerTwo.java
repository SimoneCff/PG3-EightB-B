package it.EightBB.Client.Pclient;

import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.Handler.Action.ActionHandler;
import it.EightBB.Client.Pclient.Form.ModifyProfile;

import java.awt.event.ActionEvent;

public class ConcreteHandlerTwo extends ActionHandler{
    private static ActionHandler Instance;

    public static ActionHandler getInstance(){
        if(Instance == null){
            Instance = new ConcreteHandlerTwo();
        } return Instance;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("Client")){
            if (e.getActionCommand().contains("B")) {
                if(e.getActionCommand().contains("MdBack")){
                    ClientVisitor.getInstance().visitPclient("PrivateArea",null);
            }
            }else if (e.getActionCommand().contains("FORM")) {
                if (e.getActionCommand().contains("Mod")) {
                    ModifyProfile.getTextAndSendToDB();
                }
            }
        } else {
            successor.actionPerformed(e);
        }
    }
}
