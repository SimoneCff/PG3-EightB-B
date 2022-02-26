package it.EightBB.Client.Pclient;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.Authentication.Form.Login;
import it.EightBB.Client.Authentication.Form.Register;
import it.EightBB.Client.Authentication.Form.RegisterO;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.Handler.Action.ActionHandler;
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
        System.out.println("One :"+e.getActionCommand());
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
