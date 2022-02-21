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

            System.out.println(ProxyServer.read());
            ProxyServer.Write("False");
            ProxyServer.end();
            System.out.println("Server Shutdown");

    }
}
