package it.EightBB.Server.HandlingSubSystem;

import it.EightBB.Server.Database.Query;

import java.util.ArrayList;

public class Request {
    private String SubSyst;
    private String Request;
    private Query query;

    public Request(String subsystem, String request, Query query){
        this.SubSyst = subsystem;
        this.Request = request;
        this.query = query;
    }

    public String getSubSys() {
        return this.SubSyst;
    }

    public String getRequest(){
        return this.Request;
    }

    public Query getData() {
        return this.query;
    }
}
