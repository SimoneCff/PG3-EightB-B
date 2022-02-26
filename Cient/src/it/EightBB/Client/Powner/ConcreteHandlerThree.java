package it.EightBB.Client.Powner;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.ClientVisitor;
import it.EightBB.Client.Interface.Handler.Action.ActionHandler;

import java.awt.event.ActionEvent;

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
                System.out.println("Bub");
                if(e.getActionCommand().contains("Mod")){
                    ClientVisitor.getInstance().visitPowner("Modify",null);
                } else if(e.getActionCommand().contains("ModBack")){
                    System.out.println("Patt");
                    ClientVisitor.getInstance().visitPowner("PrivateArea",null); }
            }
        }

    }
}
