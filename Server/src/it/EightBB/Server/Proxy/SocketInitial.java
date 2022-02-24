package it.EightBB.Server.Proxy;

import it.EightBB.Server.SocketInitialService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SocketInitial implements SocketInitialService {
    private ServerSocket Ssocket;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public SocketInitial(int port) {
        try {
            Ssocket = new ServerSocket(port);
            Ssocket.setReuseAddress(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerSocket getSsocket() {
        return Ssocket;
    }

    @Override
    public String read() {
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void Write(String str) {
            out.println(str);
            out.flush();
    }


    @Override
    public void accept() {
        try {
            socket = Ssocket.accept();
            System.out.println("New Client Connection from :"+ socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void SetIO(){
        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void CloseIn() {
        try{
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void CloseOut(){
            out.close();
    }

    @Override
    public void CloseServer(){
        try {
            Ssocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public BufferedReader getIn(){
        return in;
    }
    @Override
    public PrintWriter getOut(){
        return out;
    }


}
