package it.EightBB.Server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public abstract interface SocketInitialService {
 public void setSocket();
 public void setIO();
 public String Read();
 public void Write(String s);
}

