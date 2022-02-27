package it.EightBB.Server;

import it.EightBB.Server.Authservice.AuthenticationChandler;
import it.EightBB.Server.Database.Query;
import it.EightBB.Server.Database.QueryAdapter;
import it.EightBB.Server.HandlingSubSystem.Request;
import it.EightBB.Server.Proxy.SocketInitial;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            List<String> list = Arrays.asList(x.split(","));
            ArrayList<String> rq= new ArrayList<String>(list);
            System.out.println(rq);
            //
            String sub = rq.get(0);
            rq.remove(0);
            String riq = rq.get(0);
            rq.remove(0);
            System.out.println(rq);
            //
            String table = rq.get(0);
            rq.remove(0);
            Query a = QA.AdaptStringToQuery(rq);
            a.setTable(table);
            Request req = new Request(sub,riq,a);
            String result = null;
            try {
                result = AuthenticationChandler.getInstance().handlerRequest(req,proxy);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            proxy.Write(result);
        }
    }
}