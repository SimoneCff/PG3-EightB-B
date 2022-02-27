package it.EightBB.Server.pclient;

import it.EightBB.Server.Database.DatabaseOperations;
import it.EightBB.Server.Database.DatabaseProxy;
import it.EightBB.Server.Database.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PclientDBOperations implements DatabaseOperations {
    @Override
    public String getQuery(String table, Query query) throws SQLException {
        Connection Q = DatabaseProxy.getInstance().getConnect();
        String rew = null;
        if (table.equals("booking")) {
            String q = "select mail from booking where data_start = '"+query.getAttributes().get(1)+"' or data_end = '"
                    + query.getAttributes().get(2) +"'";
            StringBuilder list = new StringBuilder();
            Statement statement = Q.createStatement();
            ResultSet result = statement.executeQuery(q);
            while (result.next()){
                list.append(result.getString(1));
                if (!result.isLast()) {
                    list.append(",");
                }
        }
            if (list.isEmpty()){
                return "False";
            } else {
                String[]bn = list.toString().split(",");
                StringBuilder xq = new StringBuilder();
                ResultSet ara = statement.executeQuery("select nome,via,telefono,descrizione,service from structure");
                while (result.next()) {
                    boolean azz = true;
                    for(int z = 0; z<bn.length; z++){
                        if (result.getString(1).equals(bn[z])){
                            azz = false;
                        }
                    }
                    if (azz){
                    xq.append(result.getString(1)+","+result.getString(2)+","+result.getString(3)
                            +","+result.getString(4)+","+result.getString(5));}
                    if (!result.isLast()) {
                        list.append(",");
                    }
                   }
                rew = xq.toString();
                }
            } return rew;
    }

    @Override
    public String AddQuery(String table, Query query) throws SQLException {
        return null;
    }

    @Override
    public boolean deleteQueryFromTable(String table, String id) {
        return false;
    }

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
}
