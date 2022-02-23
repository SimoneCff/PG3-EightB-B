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
        if (true){

        } else {
            successor.handlerRequest(request, socket);
        }

    }
}
