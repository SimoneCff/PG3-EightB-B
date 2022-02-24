package it.EightBB.Server;

import it.EightBB.Server.Authservice.AuthenticationChandler;
import it.EightBB.Server.HandlingSubSystem.Handler;
import it.EightBB.Server.Proxy.SocketInitial;

public class Server {
    public static void main(String[] args) {
        SocketInitial Proxy = null;
        Proxy = new SocketInitial(5432);
        setHandler();
        //Setting Hanlder

        while(true){
            Proxy.setSocket();
            new EchoThread(Proxy).start();
        }
    }

    public static void setHandler(){
        Handler Auth = AuthenticationChandler.getInstance();

        Auth.setSuccessor(null);
    }

}


