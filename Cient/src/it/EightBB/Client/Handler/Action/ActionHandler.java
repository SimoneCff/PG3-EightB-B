package it.EightBB.Client.Handler.Action;

import java.awt.event.ActionListener;

public abstract class ActionHandler implements ActionListener {
    protected ActionHandler successor;

  public void setSuccessor(ActionHandler successor) {
        this.successor=successor;
    }
}
