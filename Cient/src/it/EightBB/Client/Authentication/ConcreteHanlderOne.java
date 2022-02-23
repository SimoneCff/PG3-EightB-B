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

                }
            }
        }

    }

}
