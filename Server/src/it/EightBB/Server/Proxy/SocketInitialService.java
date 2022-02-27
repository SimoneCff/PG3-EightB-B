package it.EightBB.Server.Proxy;


public abstract interface SocketInitialService {
 public boolean setSocket();
 public void setIO();
 public String Read();
 public void Write(String s);
 public void close();
}

