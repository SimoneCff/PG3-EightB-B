package it.EightBB.Server;

import java.io.BufferedReader;
import java.net.ServerSocket;

public abstract interface SocketInitialService {
    void Start();
    String read();
    void Write(String str);
    void end();
}

class SocketInitial implements SocketInitialService {
    private ServerSocket socket;
    private BufferedReader read;

    @Override
    public void Start() {

    }

    @Override
    public String read() {
        return null;
    }

    @Override
    public void Write(String str) {

    }

    @Override
    public void end() {

    }
}
