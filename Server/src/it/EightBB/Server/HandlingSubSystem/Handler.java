package it.EightBB.Server.HandlingSubSystem;

import it.EightBB.Server.SocketInitialService;

public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handlerRequest(Request request, SocketInitialService socket);
}
