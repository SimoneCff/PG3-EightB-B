package it.EightBB.Client;

import it.EightBB.Client.Authentication.ConcreteHanlderOne;
import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.Interface.Handler.Action.ActionHandler;
import it.EightBB.Client.Pclient.ConcreteHandlerTwo;
import it.EightBB.Client.Powner.ConcreteHandlerThree;

import javax.swing.*;

public class ImplementationFacade {
    private JFrame F;
    private static ImplementationFacade IF;
    private SocketProxy P;

    public static ImplementationFacade getInstance(){
        if(IF == null){
            IF = new ImplementationFacade();
        }
        return IF;
    }

    public void setFrame(JFrame F) {
        this.F = F;
        F.setLayout(null);
        F.setResizable(false);
        F.setVisible(true);
        F.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(F,
                        "Sicuro di Chiudere ?", "Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    visitProxy("SendEnd");
                    System.exit(0);
                }
            }
        });
    }

    public JFrame getFrame(){
        return F;
    }

    public void visitProxy(String where) {
        P = SocketProxy.getIstance();
        switch (where) {
            case "Start" -> {
                P.settingUP("192.168.1.194",5432);
            }
            case "SendEnd" -> {
                P.SendEnd();
            }
        }
    }

    public void setHandler() {
        ActionHandler AH= ConcreteHanlderOne.getInstance();
        ActionHandler PCH = ConcreteHandlerTwo.getInstance();
        ActionHandler POW = ConcreteHandlerThree.getInstance();

        //Setting COR
        AH.setSuccessor(PCH);
        PCH.setSuccessor(POW);
    }


}
