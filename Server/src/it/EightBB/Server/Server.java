package it.EightBB.Server;

import it.EightBB.Server.Authservice.AuthenticationChandler;
import it.EightBB.Server.HandlingSubSystem.Request;
import it.EightBB.Server.Proxy.DatabaseProxy;
import it.EightBB.Server.Proxy.SocketInitial;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Server  {
    public static void main(String[] args) {
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
        System.out.println("Proxy Created, Now Server is Listening");

        try {
            while (true) {
                ProxyServer.accept();
                new Thread(new ReqHandler(ProxyServer)).start();
            }
        } finally {
            if (ProxyServer.getSsocket() != null){
                ProxyServer.CloseServer();
            }
        }
    }
   private static class ReqHandler implements Runnable{
        private final SocketInitialService Proxy;

        public ReqHandler(SocketInitialService Proxy){
            this.Proxy = Proxy;
        }

       @Override
       public void run() {
           try {
               Proxy.SetIO();
               String st;
               while ((st = Proxy.read()) != null){
                   Proxy.Write("False");
               }
           }
           finally {
                   if (Proxy.getOut() != null){
                       Proxy.CloseOut();
                   }
                   if (Proxy.getIn() != null){
                       Proxy.CloseIn();
                   }
           }
       }
   }

}


