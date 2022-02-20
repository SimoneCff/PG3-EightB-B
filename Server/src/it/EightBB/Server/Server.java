package it.EightBB.Server;

import it.EightBB.Server.Authservice.AuthenticationChandler;
import it.EightBB.Server.HandlingSubSystem.Request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Server  {
    public static void main(String[] args){
        System.out.println("Initialized Server");
        SocketInitial ProxyServer = new SocketInitial(5432);
        System.out.println("Socket Creation: Success");
        DatabaseProxy database = new DatabaseProxy();
        database.connect();
        boolean x = true;
        System.out.println("Connection to Database: Success");
        //Set Hanlder
        AuthenticationChandler Auth = new AuthenticationChandler();
        //
            System.out.println("Waiting connections...");
            ArrayList<String> req = new ArrayList<String>(List.of(ProxyServer.read()));
            Auth.handlerRequest(new Request(req.get(1),req.get(2),req.get(3)),ProxyServer);
            ProxyServer.end();
            System.out.println("Server Shutdown");
    }
}
