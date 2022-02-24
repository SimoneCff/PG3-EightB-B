package it.EightBB.Server;

import it.EightBB.Server.Proxy.DatabaseProxy;
import it.EightBB.Server.Proxy.SocketInitial;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Server {
    public static void main(String[] args) {
        DatabaseProxy DB = null;
        SocketInitial Proxy = null;
            Proxy = new SocketInitial(5432);
            DB = new DatabaseProxy();
            DB.connect();

        while(true){
            Proxy.setSocket();
            new EchoThread(Proxy).start();
        }
    }

}


