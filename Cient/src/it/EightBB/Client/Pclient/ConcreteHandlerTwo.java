package it.EightBB.Client.Pclient;

import it.EightBB.Client.Authentication.Form.Login;
import it.EightBB.Client.Authentication.Form.Register;
import it.EightBB.Client.Authentication.Form.RegisterO;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.Handler.Action.ActionHandler;
import java.awt.event.ActionEvent;

public class ConcreteHandlerTwo extends ActionHandler{

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("Client")){
            if (e.getActionCommand().contains("BFORM")) {
                if(e.getActionCommand().contains("PC")){
                    //ClientVisitor.getInstance().visitAuth("RegisterC")
                }else if (e.getActionCommand().contains("PB")){
                    //ClientVisitor.getInstance().visitAuth("RegisterC")
                }
            }
        }
        else {
            successor.actionPerformed(e);
        }
    }
}
