package it.EightBB.Client.Proxy;

import java.io.*;
import java.net.Socket;

public interface SocketInterface {
    String read() throws IOException;
    void write(String str) throws IOException;
    void close();
}

