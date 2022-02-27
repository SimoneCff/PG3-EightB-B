package it.EightBB.Server;

import it.EightBB.Server.Proxy.SocketInitial;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class FileThread extends Thread{
    protected SocketInitial proxy;

    public FileThread(SocketInitial proxy){
        this.proxy = proxy;
    }

    public void run() {
        System.out.println("Thread" + Thread.currentThread().getName() + " Setted UP");
        try {
            Socket socket = proxy.getSocket();
            Scanner inp = new Scanner(socket.getInputStream());
            InputStream is = socket.getInputStream();
            PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
            String FileName = inp.nextLine();
            int FileSize = inp.nextInt();
            byte[] filebyte = new byte[FileSize];
            FileOutputStream fos = new FileOutputStream(FileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            while (true) {
                int file = is.read(filebyte, 0, filebyte.length);
                bos.write(filebyte, 0, file);

                if(FileSize == file) {
                    System.out.println("File Verificato");
                    proxy.Write("True");
                }
                else{
                    proxy.Write("False");
                    System.out.println("Thread" + Thread.currentThread().getName() + " ShutDown");
                    proxy.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }



}
