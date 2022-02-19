package it.EightBB.Server;



public class Server {
    public static void main(String[] args){
        SocketInitial ProxyServer = new SocketInitial(5432);
        System.out.println(ProxyServer.read());
        ProxyServer.Write("Sto cazzo");
        ProxyServer.end();

    }
}

class Db  {
    public static void main(String[] args){
        DatabaseProxy database = new DatabaseProxy();
        database.connect();
    }
}