package it.EightBB.Client.Proxy;

import java.io.*;
import java.net.Socket;

public interface SocketInterface {
    public static SocketInterface getIstance() {
        return null;
    }
    public abstract String read() throws IOException;
    abstract void write(String str) throws IOException;
    abstract void close();
}

