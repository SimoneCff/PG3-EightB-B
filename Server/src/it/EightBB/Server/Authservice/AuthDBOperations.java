package it.EightBB.Server.Authservice;

import it.EightBB.Server.Database.DatabaseConnect;
import it.EightBB.Server.Database.DatabaseOperations;
import it.EightBB.Server.Database.Query;
import it.EightBB.Server.Database.DatabaseProxy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AuthDBOperations implements DatabaseOperations {
    private AuthDBOperations Instance;

    @Override
    public AuthDBOperations getInstance(){
        if (Instance == null) {
            Instance = new AuthDBOperations();
            }
        return Instance;
    }

    @Override
    public List<String> getQuery(String table, String attributes) {
        return null;
    }

    @Override
    public boolean AddQuery(Connection db, String table,Query query) {
        return false;
    }

    @Override
    public boolean deleteQueryFromTable(String table, String id) {
        return false;
    }

    @Deprecated
    public boolean modifyQueryFromTable(String table, String id, String Attribute_N, String Attribute_V) {
        return false;
    }

    @Override
    public String checkInsideDB (String table,Query query){
        Connection Q = DatabaseProxy.getInstance().getConnect();
       try {
           StringBuilder q;
           q = new StringBuilder("select * from " + table + " where" + " ");
           for (int i = 0; i < query.getAttributes().size(); i++) {
               q.append(query.getAttributes().get(i));
               q.append(" = ");
               q.append(query.getValues().get(i));
               q.append(" ");
               if (i != query.getAttributes().size() - 1) {
                   q.append("and ");
               }
           }
           Statement statement = Q.createStatement();
           ResultSet rs = statement.executeQuery(q.toString());
           if (rs.getRow() == 0) {
               return "False";
           } else return "True";
       } catch (SQLException throwables) {
           throwables.printStackTrace();
           return null;
       }
    }

}
