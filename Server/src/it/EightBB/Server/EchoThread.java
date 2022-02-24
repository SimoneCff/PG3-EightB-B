package it.EightBB.Server;

import it.EightBB.Server.Authservice.AuthenticationChandler;
import it.EightBB.Server.Database.Query;
import it.EightBB.Server.Database.QueryAdapter;
import it.EightBB.Server.HandlingSubSystem.Request;
import it.EightBB.Server.Proxy.SocketInitial;

import java.util.Arrays;

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
            QueryAdapter QA = new QueryAdapter();
            String[] rq = x.split(",");
            Query a = QA.AdaptStringToQuery(String.join(rq[2],rq[rq.length-1]));
            Request req = new Request(rq[0],rq[1],a);
            String result = AuthenticationChandler.getInstance().handlerRequest(req,proxy);
            proxy.Write(result);
        }
    }
}