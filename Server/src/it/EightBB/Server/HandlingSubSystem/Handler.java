package it.EightBB.Server.HandlingSubSystem;

import it.EightBB.Server.Proxy.SocketInitialService;

public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract String handlerRequest(Request request, SocketInitialService socket);
}
