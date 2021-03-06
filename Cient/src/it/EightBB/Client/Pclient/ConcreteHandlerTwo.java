package it.EightBB.Client.Pclient;

import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.Handler.Action.ActionHandler;
import it.EightBB.Client.Pclient.Form.ModifyProfile;
import it.EightBB.Client.Pclient.Form.PrenotationOne;

import java.awt.event.ActionEvent;
/**
 * classe principale del sottosistema Authenticate
 * Gestisce gli Handler Event della classe Authentication
 * {@param ConcreteHandlerTwo}
 */

public class ConcreteHandlerTwo extends ActionHandler{
    private static ActionHandler Instance;

    public static ActionHandler getInstance(){
        if(Instance == null){
            Instance = new ConcreteHandlerTwo();
        } return Instance;
    }

    /**
     *
     * @param e parametro di evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("Client")){
            if (e.getActionCommand().contains("B")) {
                if(e.getActionCommand().contains("MdBack")){
                    ClientVisitor.getInstance().visitPclient("PrivateArea",null);
            } else if (e.getActionCommand().contains("Mod")){
                    ClientVisitor.getInstance().visitPclient("Modify",null);
                } else if (e.getActionCommand().contains("Prenota")){
                    ClientVisitor.getInstance().visitPclient("Prenota",null);
                } else if (e.getActionCommand().contains("Booked")){
                    ClientVisitor.getInstance().visitPclient("Booked",null);
                }
            }else if (e.getActionCommand().contains("FORM")) {
                if (e.getActionCommand().contains("Mod")) {
                    ModifyProfile.getTextAndSendToDB();
                } else if (e.getActionCommand().contains("Pone")){
                    PrenotationOne.getFormandSenditToDB();
                }
            }
        }
    }
}
