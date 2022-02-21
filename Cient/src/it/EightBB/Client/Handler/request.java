package it.EightBB.Client.Handler;

import it.EightBB.Server.HandlingSubSystem.Request;

public class request {
    private String m_request;
    private String m_subrequest;

    public request(String request, String subrequest){
        m_request = request;
        m_subrequest = subrequest;
    }

    public String getM_request() {
        return m_request;
    }

    public void setM_request(String m_request) {
        this.m_request = m_request;
    }

}
