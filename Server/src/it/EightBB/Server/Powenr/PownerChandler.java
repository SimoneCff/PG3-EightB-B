package it.EightBB.Server.Powenr;

import it.EightBB.Server.Authservice.AuthenticationChandler;
import it.EightBB.Server.Database.DatabaseOperations;
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
        if(request.getSubSys().equals("Owner")){
            DatabaseOperations PO = PownerDBOperations.getInstance();
            switch (request.getRequest()){
                case "Modify" : Req= PO.modifyQueryFromTable(request.getData().getTable(), request.getData());
            }

        }else Req= "False";
        return  Req;
    }
}
