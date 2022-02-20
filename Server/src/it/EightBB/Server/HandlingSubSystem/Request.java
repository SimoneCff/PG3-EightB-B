package it.EightBB.Server.HandlingSubSystem;

import java.util.ArrayList;

public class Request {
    private String SubSyst;
    private String Request;
    private String data;

    public Request(String subsystem, String request, String data){
        this.SubSyst = subsystem;
        this.Request = request;
        this.data = data;
    }

    public String getSubSys() {
        return this.SubSyst;
    }

    public String getRequest(){
        return this.Request;
    }

    public String getData() {
        return this.data;
    }
}
