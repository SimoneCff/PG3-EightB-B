package it.EightBB.Server.Proxy;

import it.EightBB.Server.Database.DatabaseConnect;

import java.sql.*;

public class DatabaseProxy implements DatabaseConnect {
    protected String url = "jdbc:mysql://localhost/eightbb";
    protected String user = "root";
    protected String password = "Programmazione3?";
    private Connection connect = null;
    private DatabaseConnect Instance;

    @Override

    public void connect() {
        try {
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the SQL Server");
        } catch (SQLException throwables) {
            System.out.println("Cant Conncet to SQL Server");
            throwables.printStackTrace();
        }
    }

    @Override

    public Connection getConnect(){
        return connect;
    }

    public void close(){
        try {
            connect.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public DatabaseConnect getInstance() {
        if (Instance == null) {
            Instance = new DatabaseProxy();
        }
        return Instance;
    }


}
