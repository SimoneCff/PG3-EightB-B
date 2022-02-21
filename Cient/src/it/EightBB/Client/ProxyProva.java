package it.EightBB.Client;

import it.EightBB.Client.Proxy.SocketProxy;

public class ProxyProva {
    public static void main(String[] args){
        SocketProxy proxy = new SocketProxy();
        proxy.settingUP("localhost",5432);
        proxy.write("ao");
        System.out.println(proxy.read());
    }


}
