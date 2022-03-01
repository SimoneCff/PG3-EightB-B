package it.EightBB.Server.HandlingSubSystem;

import it.EightBB.Server.Database.Query;

import java.util.ArrayList;

/**
 * implementazione della richiesta per la connessione al database
 * {@param Request}
 */
public class Request {
    private String SubSyst;
    private String Request;
    private Query query;

    public Request(String subsystem, String request, Query query){
        this.SubSyst = subsystem;
        this.Request = request;
        this.query = query;
    }

    /**
     * @return visualizzazione del sottosistema
     */
    public String getSubSys() {
        return this.SubSyst;
    }

    /**
     * @return visualizzazione della richiesta
     */
    public String getRequest(){
        return this.Request;
    }

    /**
     * @return visualizzazione delle query
     */
    public Query getData() {
        return this.query;
    }
}
