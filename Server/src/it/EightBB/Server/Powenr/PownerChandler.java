package it.EightBB.Server.Powenr;

import it.EightBB.Server.Authservice.AuthenticationChandler;
import it.EightBB.Server.HandlingSubSystem.Handler;
import it.EightBB.Server.HandlingSubSystem.Request;
import it.EightBB.Server.Proxy.SocketInitialService;

public class PownerChandler extends Handler {
    private static Handler instance;

    public static Handler getInstance(){
        if(instance == null){
            instance = new AuthenticationChandler();
        } return instance;
    }

    @Override
    public String handlerRequest(Request request, SocketInitialService socket) {
        String Req = null;
        if(request.getSubSys().equals("Powner")){
            switch (request.getRequest()){
                case "Modify" : Req =
            }

        }else Req= "False";
        return  Req;
    }
}
