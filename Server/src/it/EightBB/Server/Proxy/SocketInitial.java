package it.EightBB.Server.Proxy;

import it.EightBB.Server.SocketInitialService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SocketInitial implements SocketInitialService {
    private ServerSocket Ssocket;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public SocketInitial(int port) {
        try {
            Ssocket = new ServerSocket(port);
            Ssocket.setReuseAddress(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read() {
        String s = null;
        try {
            s = in.readUTF();
        } catch (SocketException ex){
            Thread.currentThread().interrupt();
        }
        catch (IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return s;
    }

    @Override
    public void Write(String str) {
        try {
            out.writeUTF(str);
            out.flush();

        } catch (SocketException ex){
            Thread.currentThread().interrupt();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void endRequest() {
        try {
           socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void accept() {
        try {
            socket = Ssocket.accept();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("New Client Connection from :"+ socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void Close() {
        try{
            out.close();
            in.close();
            Ssocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();

        }
    }

}
