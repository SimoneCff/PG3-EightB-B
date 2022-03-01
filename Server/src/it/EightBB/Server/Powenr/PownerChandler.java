package it.EightBB.Server.Powenr;


import it.EightBB.Server.Database.DatabaseOperations;
import it.EightBB.Server.HandlingSubSystem.Handler;
import it.EightBB.Server.HandlingSubSystem.Request;

import java.sql.SQLException;

/**
 * handler del chain of responsability che si occupa della pagina privata del proprietario
 * {@param PownerChandler} metodo che estende l'handler per la parte privata del proprietario
 */
public class PownerChandler extends Handler {
    private static Handler instance;

    public static Handler getInstance(){
        if(instance == null){
            instance = new PownerChandler();
        } return instance;
    }

    /**
     *
     * @param request richiesta dell'handler basato sul socket
     * @return visualizzazione della parte privata del proprietario
     * @throws SQLException Eccezzione riguardante l'imput inserito ed il suo eventuale output
     */
    @Override
    public String handlerRequest(Request request) throws SQLException {
        String Req = null;
        if(request.getSubSys().equals("Owner")){
            DatabaseOperations PO = PownerDBOperations.getInstance();
            switch (request.getRequest()){
                case "Modify" : Req= PO.modifyQueryFromTable(request.getData().getTable(), request.getData());
                case "RegStruct" : Req = PO.AddQuery(request.getData().getTable(), request.getData());
                case "RegClient": Req = PO.AddQuery(request.getData().getTable(), request.getData());
                case "gettura": Req = PO.getQuery(request.getData().getTable(), request.getData());
            }

        }else Req= "False";
        return  Req;
    }
}
