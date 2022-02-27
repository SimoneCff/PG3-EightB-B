package it.EightBB.Server.Proxy;


import java.io.IOException;

public abstract interface SocketInitialService {
 public boolean setSocket();
 public void setIO();
 public String Read() throws IOException;
 public void Write(String s);
 public void close();
}

