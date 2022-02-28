package it.EightBB.Server;

import it.EightBB.Server.Authservice.AuthenticationChandler;
import it.EightBB.Server.Database.DatabaseProxy;
import it.EightBB.Server.Database.Query;
import it.EightBB.Server.Database.QueryAdapter;
import it.EightBB.Server.HandlingSubSystem.Handler;
import it.EightBB.Server.HandlingSubSystem.Request;
import it.EightBB.Server.Powenr.PownerChandler;
import it.EightBB.Server.pclient.pclientCHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        DatabaseProxy DB = DatabaseProxy.getInstance();
        DB.connect();
        //Setting Socket DB
        try {
            ServerSocket ss = new ServerSocket(5432);
            System.out.println("Server Start");
            System.out.println("Aspettando Connesioni");

            //Setting Socket for File Transfer
            setHandler();
            //Setting Hanlder
            while (true) {
                Socket socket = ss.accept();
                Thread t = new Thread(){
                    public void run(){
                        try(
                           InputStream in = socket.getInputStream();
                           BufferedReader brin = new BufferedReader(new InputStreamReader(in));
                           DataOutputStream out= new DataOutputStream(socket.getOutputStream());){
                            while (true){
                                //read
                                String line;
                                line = brin.readLine();
                                if (line == null || line.equalsIgnoreCase("QUIT")){
                                    System.out.println("Thread"+Thread.currentThread().getName()+" ShutDown");
                                    return;
                                }
                                //Query
                                QueryAdapter QA = new QueryAdapter();
                                List<String> list = Arrays.asList(line.split(","));
                                ArrayList<String> rq= new ArrayList<String>(list);
                                //
                                String sub = rq.get(0);
                                rq.remove(0);
                                String riq = rq.get(0);
                                rq.remove(0);
                                System.out.println(rq);
                                //
                                String table = rq.get(0);
                                rq.remove(0);
                                System.out.println(rq);
                                Query a = QA.AdaptStringToQuery(rq);
                                a.setTable(table);
                                Request req = new Request(sub,riq,a);
                                String result = null;
                                result = AuthenticationChandler.getInstance().handlerRequest(req);
                                out. writeUTF(result);
                                out.flush();

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("Thread"+Thread.currentThread().getName()+" ShutDown");
                            return;
                        } catch (SQLException ex){
                            ex.printStackTrace();
                        }
                    }
                };
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    public static void setHandler(){

        Handler Auth = AuthenticationChandler.getInstance();
        Handler Pclient = pclientCHandler.getInstance();
        Handler Powenr = PownerChandler.getInstance();
        System.out.println(Auth);
        System.out.println(Powenr);

        Auth.setSuccessor(Pclient);
        Pclient.setSuccessor(Powenr);
    }

}


