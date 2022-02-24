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
    public String getQuery(String table, Query query) {
        return null;
    }

    @Override
    public String AddQuery  (String table,Query query) {
        Connection Q = DatabaseProxy.getInstance().getConnect();
        try{
            StringBuilder user, q;
            user = new StringBuilder( "insert into user values ('" + query.getAttributes().get(0) +"','" + query.getAttributes().get(1) + "');");
            q = new StringBuilder("insert into "+table+" values ('" +query.getAttributes().get(0)+"',");
            for (int i = 2; i < query.getAttributes().size(); i++){
                q.append("'");
                q.append(query.getAttributes().get(i));
                q.append("'");
                if(i < query.getAttributes().size()-1){
                    q.append(",");
                }
            }
            q.append(");");
            System.out.println("Query : "+q);
            Statement statement = Q.createStatement();
            statement.executeUpdate(user.toString());
            statement.executeUpdate(q.toString());
            return "True";

        } catch (SQLException throwables) {
            try {
                throwables.printStackTrace();
                Statement statement = Q.createStatement();
                statement.executeUpdate("DELETE From user where mail = '" + query.getAttributes().get(0) + "'");
                statement.executeUpdate("DELETE  from client where mailc = '"+query.getAttributes().get(0)+ "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "False";
        }

    }

    @Deprecated
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
               q.append(query.getValues().get(i));
               q.append(" = ");
               q.append("'");
               q.append(query.getAttributes().get(i));
               q.append("'");
               q.append(" ");
               if (i != query.getAttributes().size() - 1) {
                   q.append("and ");
               }
           }
           System.out.println("Query : "+q);
           Statement statement = Q.createStatement();
           ResultSet rs = statement.executeQuery(q.toString());
           if (!rs.next()){
               return "False";
           } else return "True";
       } catch (SQLException throwables) {
           throwables.printStackTrace();
           return "False";
       }
    }

}
