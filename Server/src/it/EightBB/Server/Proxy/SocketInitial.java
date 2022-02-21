package it.EightBB.Server.Proxy;

import it.EightBB.Server.SocketInitialService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketInitial implements SocketInitialService {
    private ServerSocket Ssocket;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public SocketInitial(int port) {
        try {
            Ssocket = new ServerSocket(port);
            socket = Ssocket.accept();
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
