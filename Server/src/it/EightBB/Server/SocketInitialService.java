package it.EightBB.Server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public abstract interface SocketInitialService {
    String read();
    void Write(String str);
    void endRequest();
    void Close();
    void accept();
}

