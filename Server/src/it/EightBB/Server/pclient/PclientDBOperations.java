package it.EightBB.Server.pclient;

import it.EightBB.Server.Database.DatabaseOperations;
import it.EightBB.Server.Database.DatabaseProxy;
import it.EightBB.Server.Database.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * implementazione delle operazioni da effettuare all'interno del database per l'utente cliente
 * <p></p>
 * {@param PclientDBOperation} metodo che implementa le operazioni nel databse
 */
public class PclientDBOperations implements DatabaseOperations {
    /**
     *
     * @param table tabella di riferimento del databse
     * @param query query da effettuare nel database
     * @return visualizazione della stringa di riferimento
     * @throws SQLException Eccezzione riguardante l'imput inserito ed il suo eventuale output
     */
    @Override
    public String getQuery(String table, Query query) throws SQLException {
        Connection Q = DatabaseProxy.getInstance().getConnect();
        String rew = null;
        if (table.equals("booking")) {
            String q = "select mail from booking where data_start = '" + query.getAttributes().get(1) + "' or data_end = '"
                    + query.getAttributes().get(2) + "'";
            StringBuilder list = new StringBuilder();
            Statement statement = Q.createStatement();
            ResultSet result = statement.executeQuery(q);
            while (result.next()) {
                list.append(result.getString(1));
                if (!result.isLast()) {
                    list.append(",");
                }
            }
            String[] bn = list.toString().split(",");
            StringBuilder xq = new StringBuilder();
            ResultSet ara = statement.executeQuery("select nome,via,telefono,descrizione,service from structure");
            while (ara.next()) {
                boolean azz = true;
                for (int z = 0; z < bn.length; z++) {
                    if (ara.getString(1).equals(bn[z])) {
                        azz = false;
                    }
                }
                    if (azz){
                    xq.append(ara.getString(1)+","+ara.getString(2)+","+ara.getString(3)
                            +","+ara.getString(4)+","+ara.getString(5));}
                    if (!ara.isLast()) {
                        xq.append("-");
                    }
                rew = xq.toString();
                }
            System.out.println(rew);
            } else {
            String q = "select * from booking where mail ='"+query.getAttributes().get(0)+"'";
            StringBuilder list = new StringBuilder();
            Statement statement = Q.createStatement();
            ResultSet result = statement.executeQuery(q);
            while (result.next()){
                list.append(result.getString(1));
                list.append(",");
                list.append(result.getString(2));
                list.append(",");
                list.append(result.getString(3));
                list.append(",");
                list.append(result.getString(4));
                list.append(",");
                list.append(result.getString(5));
                list.append(",");
                list.append(result.getString(6));
                list.append(",");
                list.append(result.getString(7));
                list.append(",");
                list.append(result.getString(8));
                if (!result.isLast()) {
                    list.append("-,");
                }
            }
            System.out.println(list);
            rew = list.toString();
        }
        return rew;
    }

    /**
     *
     * @param table tabella di riferimento del database
     * @param query query da effettuare nel database
     * @return eventuale implementazione della query
     * @throws SQLException Eccezzione riguardante l'imput inserito ed il suo eventuale output
     */
    @Override
    public String AddQuery(String table, Query query) throws SQLException {
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
