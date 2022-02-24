package it.EightBB.Server;

import it.EightBB.Server.Proxy.SocketInitial;

public class EchoThread extends Thread {
    protected SocketInitial proxy;

    public EchoThread(SocketInitial proxy) {
        this.proxy = proxy;
    }

    public void run() {
        System.out.println("Thread"+Thread.currentThread().getName()+" Setted UP");
        String line;
        proxy.setIO();
        while (true) {
            String x =proxy.Read();
            if (x == null || x.equalsIgnoreCase("QUIT")){
                System.out.println("Thread"+Thread.currentThread().getName()+" ShutDown");
                proxy.close();
                return;
            }
            proxy.Write("False");
        }
    }
}