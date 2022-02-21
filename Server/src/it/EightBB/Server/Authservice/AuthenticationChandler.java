package it.EightBB.Server.Authservice;

import it.EightBB.Server.Proxy.DatabaseProxy;
import it.EightBB.Server.HandlingSubSystem.Handler;
import it.EightBB.Server.HandlingSubSystem.Request;
import it.EightBB.Server.SocketInitialService;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationChandler extends Handler {

    @Override
    public void handlerRequest(Request request, SocketInitialService socket) {
        if (request.getSubSys().equals("Auth")){
            AuthDBOperations x = new AuthDBOperations().getInstance();
            if(request.getRequest().equals("Login")){
               ArrayList<String> query = new ArrayList<String>(List.of(request.getData()));
               if (x.checkInsideDB(new DatabaseProxy().getConnect(), "User",query)){
                   socket.Write("True");
               }
            }
        } else {
            successor.handlerRequest(request, socket);
        }

    }
}
