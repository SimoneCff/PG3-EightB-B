package it.EightBB.Client.Proxy;

import java.io.*;
import java.net.Socket;
import javax.swing.*;


public class SocketProxy implements SocketInterface {
    private static SocketProxy Instance;
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private PrintWriter pw;

    public static SocketProxy getIstance(){
        if(Instance == null){
            Instance = new SocketProxy();
        }return Instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void settingUP(String IP, int port) {
        try {
            socket = new Socket(IP, port);
        } catch (IOException e) {

            JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }


    @Override
    public String read() {
        String s = null;
        try {
            in = socket.getInputStream();
            s = new DataInputStream(in).readUTF();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return s;
    }

    @Override
    public void write(String str) {
        try {
            out = socket.getOutputStream();
            pw = new PrintWriter(new OutputStreamWriter(out),true);
            pw.println(str);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }

}
