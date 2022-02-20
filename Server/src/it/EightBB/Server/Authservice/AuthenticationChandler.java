package it.EightBB.Server.Authservice;

import it.EightBB.Server.HandlingSubSystem.Handler;
import it.EightBB.Server.HandlingSubSystem.Request;

public class AuthenticationChandler extends Handler {
    @Override
    public void handlerRequest(Request request) {
        if (request.getSubSys().equals("Auth")){
            if (request.getRequest().equals("Login")){

            } else if (request.getRequest().equals()){

            }
        }

    }
}
