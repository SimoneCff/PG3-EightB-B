package it.EightBB.Server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public abstract interface SocketInitialService {
    String read();
    void Write(String str);
    void end();
}

class SocketInitial implements SocketInitialService {
    private ServerSocket Ssocket;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public SocketInitial (int port) {
        try {
            Ssocket = new ServerSocket(port);
            socket = Ssocket.accept();
            //Input & Output
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read() {
        String s = null;
        try {
           s = in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public void Write(String str) {
        try {
            out.writeUTF(str);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void end() {
        try {
            socket.close();
            in.close();
            Ssocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
