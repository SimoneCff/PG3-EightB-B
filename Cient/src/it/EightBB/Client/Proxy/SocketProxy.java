package it.EightBB.Client.Proxy;

import com.mysql.cj.callback.MysqlCallbackHandler;

import java.io.*;
import java.net.Socket;
import javax.swing.*;


public class SocketProxy implements SocketInterface {
    private static SocketProxy Instance;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;


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
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {

            JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public String read() {
        String str = null;
        try {
            str =  in.readUTF();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return str;
    }


    @Override
    public void write(String str) {
        try {
           out.writeUTF(str);
           out.flush();
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
