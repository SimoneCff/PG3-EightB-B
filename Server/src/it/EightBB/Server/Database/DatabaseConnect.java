package it.EightBB.Server.Database;
import java.sql.*;
import java.util.ArrayList;
/**
 * implementazione dell'interfaccia per la connessione col database
 * {@param DatabaseConnect}
 */
public interface DatabaseConnect {
    //
    public void connect();
    public Connection getConnect();
    public void close();

}

