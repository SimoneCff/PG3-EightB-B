package it.EightBB.Client.Interface;

import java.io.*;

public interface SocketInterface {
    public static SocketInterface getIstance() {
        return null;
    }
    public abstract String read() throws IOException;
    abstract void write(String str) throws IOException;
    abstract void close();
}

