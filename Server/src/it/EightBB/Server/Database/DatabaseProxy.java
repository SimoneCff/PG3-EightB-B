package it.EightBB.Server.Database;

import java.sql.*;

/**
 *implementazione del proxy per la connessione con il databse
 * {@param Databseproxy} implementazione della connessione
 */
public class DatabaseProxy implements DatabaseConnect {
    protected String url = "jdbc:mysql://localhost/eightbb";
    protected String user = "root";
    protected String password = "Programmazione3?";
    private Connection connect = null;
    private static DatabaseProxy Instance;

    public void connect() {
        try {
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the SQL Server");
        } catch (SQLException throwables) {
            System.out.println("Cant Conncet to SQL Server");
            throwables.printStackTrace();
        }
    }

    /**
     * @return verifica della connessione al server SQL
     */
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

    /**
     * @return instanza di connessione
     */
    public static DatabaseProxy getInstance() {
        if (Instance == null) {
            Instance = new DatabaseProxy();
        }
        return Instance;
    }


}
