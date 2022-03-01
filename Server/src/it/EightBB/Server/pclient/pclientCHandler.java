package it.EightBB.Server.pclient;

import it.EightBB.Server.Database.DatabaseOperations;
import it.EightBB.Server.HandlingSubSystem.Handler;
import it.EightBB.Server.HandlingSubSystem.Request;

import java.sql.SQLException;

/**
 * handler del chain of responsability che si occupa della pagina privata del cliente
 * {@param pclientCHandler} metodo che implementa la parte privata
 */
public class pclientCHandler extends Handler {
    private static Handler instance;

    public static Handler getInstance(){
        if(instance == null){
            instance = new pclientCHandler();
        } return instance;
    }

    /**
     *
     * @param request richiesta dell'handler basato sul socket
     * @return visualizzazione della parte privata del cliente
     * @throws SQLException Eccezzione riguardante l'imput inserito ed il suo eventuale output
     */
    @Override
    public String handlerRequest(Request request) throws SQLException {
        String Req = null;
        if(request.getSubSys().equals("Client")){
            DatabaseOperations PC = new PclientDBOperations();
           if (request.getRequest().equals("Modify")){Req= PC.modifyQueryFromTable(request.getData().getTable(), request.getData());}
           else if (request.getRequest().equals("One")) {Req = PC.getQuery(request.getData().getTable(), request.getData());}
           else if(request.getRequest().equals("Prenot")){Req = PC.AddQuery(request.getData().getTable(), request.getData());}
           else if (request.getRequest().equals("getk")){
               Req = PC.getQuery(request.getData().getTable(), request.getData());
           }
        }else Req = successor.handlerRequest(request);
        return Req;
    }
}
