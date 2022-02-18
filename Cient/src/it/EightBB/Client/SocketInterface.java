package it.EightBB.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public interface SocketInterface {
    String read();
    void write(String str);
    void close();
}

class SocketProxy implements SocketInterface {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public SocketProxy (String IP, int port, boolean wait)  {
        try {
            if (wait) {
                ServerSocket server = new ServerSocket(port);
                socket = server.accept();
            } else {
                socket = new Socket(IP, port);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String read() {
        String s = null;
        try{
            s = in.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public void write(String str) {
        out.println(str);

    }

    @Override
    public void close() {
        try {
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
