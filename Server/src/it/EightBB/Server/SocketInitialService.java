package it.EightBB.Server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public abstract interface SocketInitialService {
    void SetIO();
    BufferedReader getIn();
    PrintWriter getOut();
    void CloseIn();
    void CloseOut();
    void CloseServer();
    void accept();
}

