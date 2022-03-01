package it.EightBB.Server.HandlingSubSystem;


import java.sql.SQLException;

/**
 * handler di chain of responsability, classe astratta che pone le basi per il ConcreteHandler
 * {@param Handler} implementazione della classe handler
 */
public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract String handlerRequest(Request request) throws SQLException;
}
