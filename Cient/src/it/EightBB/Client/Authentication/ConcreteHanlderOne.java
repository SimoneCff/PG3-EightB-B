package it.EightBB.Client.Authentication;

import it.EightBB.Client.Authentication.Form.Login;
import it.EightBB.Client.Interface.Handler.Action.ActionHandler;

import java.awt.event.ActionEvent;

public class ConcreteHanlderOne extends ActionHandler {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("Auth")){
            if (e.getActionCommand().contains("BP")){
                if (e.getActionCommand().contains("L")){
                    Login.getTextAndSendToDB();
                } else if (e.getActionCommand().contains("Register")){
                  AuthFacade.getInstance().Register();
                } else if (e.getActionCommand().contains("RegC")){
                    AuthFacade.getInstance().RegisterClient();
                } else if (e.getActionCommand().contains("RegO")){
                    AuthFacade.getInstance().RegisterOwner();
                }
            }
        }

    }

}
