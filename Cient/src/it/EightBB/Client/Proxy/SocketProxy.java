package it.EightBB.Client.Proxy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketProxy implements SocketInterface {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;


    public SocketProxy(String IP, int port) {
        try {
            socket = new Socket(IP, port);
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
    public void write(String str) {
        try {
            out.writeUTF(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
