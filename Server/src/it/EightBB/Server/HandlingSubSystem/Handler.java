package it.EightBB.Server.HandlingSubSystem;


import java.sql.SQLException;

public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract String handlerRequest(Request request) throws SQLException;
}
