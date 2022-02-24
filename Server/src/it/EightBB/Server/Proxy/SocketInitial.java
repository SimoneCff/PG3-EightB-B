package it.EightBB.Server.Proxy;

import it.EightBB.Server.SocketInitialService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketInitial implements SocketInitialService {
      private ServerSocket server = null;
      private Socket socket = null;
      private InputStream in = null;
      private BufferedReader brin = null;
      private DataOutputStream out = null;

      public SocketInitial (int port) {
          try {
              this.server = new ServerSocket(port);
              System.out.println("Setting Up Server Socket");
          } catch (IOException e){
              e.printStackTrace();
          }
      }

    @Override
    public void setSocket() {
          try {
              socket = server.accept();
              System.out.println("Client connected : "+ socket.getInetAddress());
          } catch (IOException e){
              e.printStackTrace();
          }
    }

    @Override
    public void setIO() {
          try {
              in = socket.getInputStream();
              brin = new BufferedReader(new InputStreamReader(in));
              out= new DataOutputStream(socket.getOutputStream());
          } catch (IOException e){
              e.printStackTrace();
          }
    }

    @Override
    public String Read() {
          String line;
        try {
            line = brin.readLine();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void Write(String s) {
          try {
              out.writeUTF(s);
              out.flush();
          } catch (IOException e) {
              e.printStackTrace();
          }
    }

    @Override
    public void close() {
          try{
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
    }
