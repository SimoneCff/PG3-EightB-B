package it.EightBB.Server;
import java.sql.*;
import java.util.ArrayList;

public interface DatabaseConnect {
    //
    public void connect();
    public ArrayList<String> getQuery(String table, String attributes);
}

class DatabaseProxy implements DatabaseConnect{
    private String url = "jdbc:mysql://:3306/eightbb";
    private String user = "root";
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

    @Override
    public ArrayList<String> getQuery(String table, String attributes){
        ArrayList <String> Query = new ArrayList<>();
        try {
            Statement state = connect.createStatement();
            ResultSet result = null;
            ResultSetMetaData rr;
            if (attributes==null){
                result = state.executeQuery("select * from "+ table);
            }
            else {
                String query = "select" + attributes + "from" + table;
                result = state.executeQuery(query);

            }
            rr = result.getMetaData();

            while (result.next()){
                for (int i = 1; i<=rr.getColumnCount(); i++) {
                    Query.add(rr.getColumnName(i));
                    Query.add(result.getString(i));
                }
                Query.add("end");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Query;
    }

}
