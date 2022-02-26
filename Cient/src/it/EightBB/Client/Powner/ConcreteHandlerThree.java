package it.EightBB.Client.Powner;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.Interface.Handler.Action.ActionHandler;

import java.awt.event.ActionEvent;

public class ConcreteHandlerThree extends ActionHandler {
    private static ActionHandler Instance;

    public static ActionHandler getInstance(){
        if(Instance == null){
            Instance = new ConcreteHanlderOne();
        } return Instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
