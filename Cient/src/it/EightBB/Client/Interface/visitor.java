package it.EightBB.Client.Interface;

import it.EightBB.Client.CEssentials.SocketProxy;
import it.EightBB.Client.Pclient.Memento.PrenotationMemento;

import javax.swing.*;
import java.io.File;

public interface visitor {
    void visitAuth(String where);
    void visitPclient(String where, String text);
    void visitPowner(String where, String text);
}
