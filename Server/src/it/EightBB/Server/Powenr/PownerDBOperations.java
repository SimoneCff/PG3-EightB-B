package it.EightBB.Server.Powenr;

import it.EightBB.Server.Database.DatabaseOperations;
import it.EightBB.Server.Database.DatabaseProxy;
import it.EightBB.Server.Database.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PownerDBOperations implements DatabaseOperations {
    private static DatabaseOperations Instance;

    @Override
    public String getQuery(String table, Query query) {
        Connection Q = DatabaseProxy.getInstance().getConnect();
        try {
            String q = "select nome from structure where mail = '"+query.getAttributes().get(0)+"'";
            StringBuilder list = new StringBuilder();
            Statement statement = Q.createStatement();
            ResultSet result = statement.executeQuery(q);
            while (result.next()){
                list.append(result.getString(1));
                if (!result.isLast()) {
                    list.append(",");
                }
                return list.toString();
            }
            System.out.println(list);
            return list.toString();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "False";
        }

    }

    @Override
    public String AddQuery(String table, Query query) {
        Connection Q = DatabaseProxy.getInstance().getConnect();
        try {
            StringBuilder q;
            q = new StringBuilder("insert into " + table + " values ('" + query.getAttributes().get(0) + "',");
            for (int i = 1; i < query.getAttributes().size(); i++) {
                q.append("'");
                q.append(query.getAttributes().get(i));
                q.append("'");
                if (i < query.getAttributes().size() - 1) {
                    q.append(",");
                }
            }
            q.append(");");
            System.out.println(q.toString());
            Statement statement = Q.createStatement();
            statement.executeUpdate(q.toString());
            return "True";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "False";
        }
    }

    @Deprecated
    public boolean deleteQueryFromTable(String table, String id) {
        return false;
    }

    @Override
    public String modifyQueryFromTable(String table, Query query) {
        Connection Q = DatabaseProxy.getInstance().getConnect();
        Statement Statement;
        String pass = "";
        try{
            Statement = Q.createStatement();
            StringBuilder q;
            if (query.getValues().get(1).contains("pass")){
                ResultSet req = Statement.executeQuery("select pass from user where mail = '"+query.getAttributes().get(0)+"'");
                if(req.next()){
                    pass = req.getString(1);
                }
                Statement.executeUpdate("update user set pass = '" + query.getAttributes().get(1) + "' where mail = '" + query.getAttributes().get(0) + "';");
            }
            String qu = "update owner set "+query.getValues().get(2)+"='"+query.getAttributes().get(2)+
                    "', "+query.getValues().get(3)+"='"+query.getAttributes().get(3)+"' where mail ='"
                    + query.getAttributes().get(0) + "'";
            Statement.executeUpdate(qu);
            return "True";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            if (!pass.isBlank()){
                try {
                    Statement = Q.createStatement();
                    Statement.executeUpdate("update user set pass = '"+pass+"' where mail = '"
                            +query.getValues().get(0) + "';");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return "False";
        }
    }

    @Override
    public String checkInsideDB(String table, Query query) {
        return null;
    }

    public static DatabaseOperations getInstance() {
        if (Instance == null) {
            Instance = new PownerDBOperations();
        }
        return Instance;
    }
}
