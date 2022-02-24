package it.EightBB.Server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public abstract interface SocketInitialService {
    String read();
    void SetIO();
    BufferedReader getIn();
    PrintWriter getOut();
    void Write(String str);
    void CloseIn();
    void CloseOut();
    void CloseServer();
    void accept();
}

