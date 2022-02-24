package it.EightBB.Server;

import it.EightBB.Server.Proxy.SocketInitial;

import java.io.*;
import java.net.Socket;

public class EchoThread extends Thread {
    protected SocketInitial proxy;

    public EchoThread(SocketInitial proxy) {
        this.proxy = proxy;
    }

    public void run() {
        String line;
        while (true) {
            String x =proxy.Read();
            proxy.Write("False");
        }
    }
}