package it.EightBB.Server;

import it.EightBB.Server.Authservice.AuthenticationChandler;
import it.EightBB.Server.Database.DatabaseProxy;
import it.EightBB.Server.HandlingSubSystem.Handler;
import it.EightBB.Server.Powenr.PownerChandler;
import it.EightBB.Server.Proxy.SocketInitial;

public class Server {
    public static void main(String[] args) {
        DatabaseProxy DB = DatabaseProxy.getInstance();
        DB.connect();
        //Setting Socket DB
        SocketInitial Proxy = null;
        Proxy = new SocketInitial(5432);
        //Setting Socket for File Transfer
        SocketInitial ProxF = new SocketInitial(5430);
        setHandler();
        //Setting Hanlder

        while(true){
            if (Proxy.setSocket()){
                new EchoThread(Proxy).start();
            }
            if (ProxF.setSocket()){
                new FileThread(Proxy).start();
            }
        }
    }

    public static void setHandler(){

        Handler Auth = AuthenticationChandler.getInstance();
        Handler Powenr = PownerChandler.getInstance();
        System.out.println(Auth);
        System.out.println(Powenr);

        Auth.setSuccessor(Powenr);
        Powenr.setSuccessor(null);
    }

}


