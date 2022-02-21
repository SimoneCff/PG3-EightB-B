package it.EightBB.Server.Proxy;

import it.EightBB.Server.SocketInitialService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketInitial implements SocketInitialService {
    private ServerSocket Ssocket;
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private PrintWriter pw ;

    public SocketInitial(int port) {
        try {
            Ssocket = new ServerSocket(port);
            socket = Ssocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read() {
        String s = null;
        try {
            in = socket.getInputStream();
            DataInputStream din = new DataInputStream(in);
            s = din.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public void Write(String str) {
        try {
            out = socket.getOutputStream();
            pw = new PrintWriter(new OutputStreamWriter(out),true);

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
