package it.EightBB.Client.Authentication;

import it.EightBB.Client.Authentication.Form.Login;
import it.EightBB.Client.Authentication.Form.Register;
import it.EightBB.Client.Authentication.Form.RegisterO;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.Handler.Action.ActionHandler;

import java.awt.event.ActionEvent;

/**
 * classe principale del sottosistema Authenticate
 * Gestisce gli Handler Event della classe Authentication
 * {@param ConcreteHandlerOne}
 */
public class ConcreteHanlderOne extends ActionHandler {
    private static ActionHandler Instance;

    public static ActionHandler getInstance(){
        if(Instance == null){
            Instance = new ConcreteHanlderOne();
        } return Instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("One :"+e.getActionCommand());
        if (e.getActionCommand().contains("Auth")){
            if (e.getActionCommand().contains("BP")){
                 if (e.getActionCommand().contains("Register")){
                     ClientVisitor.getInstance().visitAuth("Register");
                } else if (e.getActionCommand().contains("RegC")){
                     ClientVisitor.getInstance().visitAuth("RegisterC");
                } else if (e.getActionCommand().contains("RegO")){
                     ClientVisitor.getInstance().visitAuth("RegisterO");
                } else if (e.getActionCommand().contains("RetGin")){
                     ClientVisitor.getInstance().visitAuth("Login");
                }
            } else if (e.getActionCommand().contains("BFORM")){
                if (e.getActionCommand().contains("L")){
                    Login.getTextAndSendToDB();
                } else if (e.getActionCommand().contains("RO")){
                    RegisterO.getTextAndSendToDB();
                } else if (e.getActionCommand().contains("RC")){
                    Register.getTextAndSendToDB();
                }
            }
        }
        else {
            successor.actionPerformed(e);
        }

    }

}
