package it.EightBB.Server;

public class Server  {
    public static void main(String[] args){
        System.out.println("Initialized Server");
        SocketInitial ProxyServer = new SocketInitial(5432);
        System.out.println("Socket Creation: Success");
        DatabaseProxy database = new DatabaseProxy();
        database.connect();
        System.out.println("Connection to Database: Success");

        //
        System.out.println("Waiting connections...");



        ProxyServer.end();
        System.out.println("Server Shutdown");
    }
}
