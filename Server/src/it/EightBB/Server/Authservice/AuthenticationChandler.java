package it.EightBB.Server.Authservice;

import it.EightBB.Server.Database.DatabaseOperations;
import it.EightBB.Server.HandlingSubSystem.Handler;
import it.EightBB.Server.HandlingSubSystem.Request;
import it.EightBB.Server.SocketInitialService;

public class AuthenticationChandler extends Handler {
    private static Handler instance;

    public static Handler getInstance(){
        if(instance == null){
            instance = new AuthenticationChandler();
        } return instance;
    }

    @Override
    public String handlerRequest(Request request, SocketInitialService socket) {
        String Req = null;
        if (request.getSubSys().equals("Auth")) {
            DatabaseOperations ADB = new AuthDBOperations();
            if (request.getRequest().equals("Login")) {
                Req = ADB.checkInsideDB(request.getData().getTable(), request.getData());
            } else if (request.getRequest().equals("Register")) {
                Req = ADB.AddQuery(request.getData().getTable(), request.getData());
            }
        } else {
            Req = successor.handlerRequest(request, socket);
        }return Req;
    }
}
