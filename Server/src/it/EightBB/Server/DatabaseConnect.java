package it.EightBB.Server;
import java.sql.*;

public interface DatabaseConnect {
    public void connect();
}

class DatabaseProxy implements DatabaseConnect{
    private String url = "jdbc:mysql://eightbbsql.cjppfpusn6kv.eu-central-1.rds.amazonaws.com:3306/eughtBBSQL";
    private String user = "eightbb";
    private String password = "Programmazione3?";
    private Connection connect = null;

    @Override

    public void connect() {
        try {
            connect = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to the SQL Server");
        } catch (SQLException throwables) {
            System.out.println("Cant Conncet to SQL Server");
            throwables.printStackTrace();
        }
    }
}
