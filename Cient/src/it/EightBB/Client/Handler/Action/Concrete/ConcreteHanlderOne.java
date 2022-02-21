package it.EightBB.Client.Handler.Action.Concrete;

import it.EightBB.Client.Authentication.Form.Login;
import it.EightBB.Client.Handler.Action.ActionHandler;

import java.awt.*;
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
