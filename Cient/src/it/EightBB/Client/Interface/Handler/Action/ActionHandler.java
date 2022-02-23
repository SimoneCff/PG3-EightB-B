package it.EightBB.Client.Interface.Handler.Action;

import java.awt.event.ActionListener;

public abstract class ActionHandler implements ActionListener {
    protected ActionHandler successor;

  public void setSuccessor(ActionHandler successor) {
        this.successor=successor;
    }
}
