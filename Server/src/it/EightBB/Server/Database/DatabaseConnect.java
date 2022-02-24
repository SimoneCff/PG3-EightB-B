package it.EightBB.Server.Database;
import java.sql.*;
import java.util.ArrayList;

public interface DatabaseConnect {
    //
    public void connect();
    public Connection getConnect();
    public void close();

}

