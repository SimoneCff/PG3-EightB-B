package it.EightBB.Server;

import it.EightBB.Server.Authservice.AuthenticationChandler;
import it.EightBB.Server.HandlingSubSystem.Request;
import it.EightBB.Server.Proxy.DatabaseProxy;
import it.EightBB.Server.Proxy.SocketInitial;

import java.util.ArrayList;
import java.util.List;

public class Server  {
    public static void main(String[] args){
        int x = 0;
        System.out.println("Initialize DB");
        DatabaseProxy database = new DatabaseProxy();
        database.connect();
        System.out.println("Connection to Database: Success");

        //Set Hanlder
        AuthenticationChandler Auth = new AuthenticationChandler();

        //Set Connection
        System.out.println("Initialized Server");
        SocketInitial ProxyServer = new SocketInitial(5432);

        while (true) {
            x++;
            System.out.println(ProxyServer.read());
            ArrayList<String> req = new ArrayList<String>(List.of(ProxyServer.read()));
            Auth.handlerRequest(new Request(req.get(1), req.get(2), req.get(3)), ProxyServer);
            if (x == 5){
                ProxyServer.end();
                System.out.println("Server Shutdown");
            }
        }

    }
}
