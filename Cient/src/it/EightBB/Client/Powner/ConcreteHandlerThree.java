package it.EightBB.Client.Powner;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.Handler.Action.ActionHandler;
import it.EightBB.Client.Powner.Form.ModifyProfile;
import it.EightBB.Client.Powner.Form.RegClientLive;
import it.EightBB.Client.Powner.Form.RegisterNewStructure;

import java.awt.event.ActionEvent;

/**
 * handler del sottosistema di Powner. viene utilizzato per gli Action Event riguardante javaswing.
 * viene utilizzato per i bottoni e per i form.
 * {@param ConcreteHandlerThree}
 */
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
                } else if (e.getActionCommand().contains("Client")){
                    ClientVisitor.getInstance().visitPowner("Client",null);
                }else if(e.getActionCommand().contains("Economic")){
                    ClientVisitor.getInstance().visitPowner("Economic",null);
                }else if (e.getActionCommand().contains("File")){
                    ClientVisitor.getInstance().visitPowner("File",null);
                }
            } else if (e.getActionCommand().contains("FORM")){
                if (e.getActionCommand().contains("Mod")){
                    ModifyProfile.getTextAndSendToDB();
                } else if (e.getActionCommand().contains("RegStruct")){
                    RegisterNewStructure.getFormandSendtoDB();
                } else if (e.getActionCommand().contains("Client")){
                    RegClientLive.getTextAndSendToDB();
                }
            }
        }

    }
}
