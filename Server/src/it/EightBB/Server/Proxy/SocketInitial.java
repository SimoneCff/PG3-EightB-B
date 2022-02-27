package it.EightBB.Server.Proxy;

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
    public void setIO() throws IOException {
              in = socket.getInputStream();
              brin = new BufferedReader(new InputStreamReader(in));
              out= new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public String Read() throws IOException {
          String line;
            line = brin.readLine();
            return line;
    }

    @Override
    public void Write(String s) throws IOException {
              out. writeUTF(s);
              out.flush();
    }

    @Override
    public void close() {
          try{
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
     }

     public Socket getSocket(){
          return socket;
     }
    }
