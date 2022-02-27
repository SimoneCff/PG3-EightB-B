package it.EightBB.Server.Proxy;


import java.io.IOException;

public abstract interface SocketInitialService {
 public void setSocket();
 public void setIO() throws IOException;
 public String Read() throws IOException;
 public void Write(String s) throws IOException;
 public void close();
}

