package it.EightBB.Client.Interface;

import javax.swing.*;

public interface visitor {
    void visitAuth(JFrame F,String where);
    void visitProxy(String where);
    void visitPclient(JFrame F,String where);
    void visitPowner(JFrame F,String where);
}
