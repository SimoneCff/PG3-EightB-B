package it.EightBB.Server.HandlingSubSystem;

public class Request {
    private String R_SubSyst;
    private String R_Request;

    public Request(String subsystem, String request){
        this.R_Request = request;
        this.R_SubSyst = subsystem;
    }

    public String getSubSys() {
        return this.R_SubSyst;
    }

    public String getRequest(){
        return this.R_Request;
    }

}
