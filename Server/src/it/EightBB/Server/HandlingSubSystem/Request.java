package it.EightBB.Server.HandlingSubSystem;

import java.util.ArrayList;

public class Request {
    private String R_SubSyst;
    private String R_Request;
    private String data;

    public Request(String subsystem, String request){
        this.R_SubSyst = subsystem;
    }

    public String getSubSys() {
        return this.R_SubSyst;
    }

    public String getRequest(){
        return this.R_Request;
    }

    public String getData() {
        return this.data;
    }
}
