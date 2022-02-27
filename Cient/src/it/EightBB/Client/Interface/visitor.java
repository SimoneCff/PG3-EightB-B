package it.EightBB.Client.Interface;

import it.EightBB.Client.CEssentials.SocketProxy;

import javax.swing.*;
import java.io.File;

public interface visitor {
    void setFrame(JFrame F);
    void visitAuth(String where);
    void visitProxy(String where);
    void visitPclient(String where, String text);
    void visitPowner(String where, String text);
    void setHandler();
}
