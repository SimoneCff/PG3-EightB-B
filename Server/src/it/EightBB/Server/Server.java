package it.EightBB.Server;

import it.EightBB.Server.Authservice.AuthenticationChandler;
import it.EightBB.Server.HandlingSubSystem.Request;
import it.EightBB.Server.Proxy.DatabaseProxy;
import it.EightBB.Server.Proxy.SocketInitial;

import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Server {
    public static void main(String[] args) {
        DatabaseProxy DB = null;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try{
            serverSocket = new ServerSocket(5432);
            DB = new DatabaseProxy();
            DB.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            try{
                socket = serverSocket.accept();

            } catch (IOException e) {
                e.printStackTrace();
            }
            new EchoThread(socket).start();
        }

    }

}


