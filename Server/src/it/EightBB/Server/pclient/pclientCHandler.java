package it.EightBB.Server.pclient;

import it.EightBB.Server.HandlingSubSystem.Handler;
import it.EightBB.Server.HandlingSubSystem.Request;
import it.EightBB.Server.Powenr.PownerChandler;
import it.EightBB.Server.Proxy.SocketInitialService;

import java.sql.SQLException;

public class pclientCHandler extends Handler {
    private static Handler instance;

    public static Handler getInstance(){
        if(instance == null){
            instance = new PclientCHandler();
        } return instance;
    }

    @Override
    public String handlerRequest(Request request, SocketInitialService socket) throws SQLException {
        return null;
    }
}
