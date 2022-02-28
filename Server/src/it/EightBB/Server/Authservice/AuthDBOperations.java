package it.EightBB.Server.Authservice;

import it.EightBB.Server.Database.DatabaseOperations;
import it.EightBB.Server.Database.Query;
import it.EightBB.Server.Database.DatabaseProxy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * implementazione del sottosistema Authentication
 * permette il collegamente al database per l'autenticazione dell'utente
 * {@param AuthDBOperation}
 */
public class AuthDBOperations implements DatabaseOperations {
    private static AuthDBOperations Instance;

    /**
     * @return Instance Inizializzazione dell'autenticazione
     */
    public static DatabaseOperations getInstance(){
        if (Instance == null) {
            Instance = new AuthDBOperations();
            }
        return Instance;
    }

    /**
     * @param table tabella di riferimento del database
     * @param query query da efffuttare nel database
     * @return Ritorno al client in funzione se il return sia true o false, o in alternativa produce una lista
     */
    @Override
    public String getQuery(String table, Query query) {
        Connection Q = DatabaseProxy.getInstance().getConnect();
        try {
            StringBuilder q = new StringBuilder();
            String fist = "select * from " + table + " where ";
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
            Statement statement = Q.createStatement();
            ResultSet bs = statement.executeQuery(fist+ q);
            if (!bs.next()){
                return "False";
            } else {
                String pass = bs.getString(2);
                if (bs.getString(3).equals("client")){
                 ResultSet rs =   statement.executeQuery("select * from client where mail = " +"'"+ query.getAttributes().get(0)+"'");
                    if(rs.next()) {
                 return "Client,"+ rs.getString(1) +"," + pass+","+rs.getString(2) + "," +
                            rs.getString(3);}
                } else {
                    ResultSet rs =   statement.executeQuery("select * from owner where mail = " +"'"+ query.getAttributes().get(0)+"'");
                    if(rs.next()) {
                    return "Owner,"+ rs.getString(1) +"," +pass+","+rs.getString(2) + "," +
                                rs.getString(3)+"," + rs.getString(4) + "," + rs.getString(5);
                      }
                    }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "False";
        }
        return null;
    }

    /**
     *
     * @param table tabella di riferimento del database
     * @param query query da effettuare nel database
     * @return Ritorno al client in funzione se il return sia true o false, o in alternativa produce una lista
     */
    @Override
    public String AddQuery  (String table,Query query) {
        Connection Q = DatabaseProxy.getInstance().getConnect();
        try{
            StringBuilder user, q;
            user = new StringBuilder( "insert into user values ('" + query.getAttributes().get(0) +"','" +
                    query.getAttributes().get(1) + "','" + query.getAttributes().get(2) + "');");
            q = new StringBuilder("insert into "+table+" values ('" +query.getAttributes().get(0)+"',");
            for (int i = 3; i < query.getAttributes().size(); i++){
                q.append("'");
                q.append(query.getAttributes().get(i));
                q.append("'");
                if(i < query.getAttributes().size()-1){
                    q.append(",");
                }
            }
            q.append(");");
            Statement statement = Q.createStatement();
            statement.executeUpdate(user.toString());
            statement.executeUpdate(q.toString());
            return "True";

        } catch (SQLException throwables) {
            try {
                throwables.printStackTrace();
                Statement statement = Q.createStatement();
                statement.executeUpdate("DELETE From user where mail = '" + query.getAttributes().get(0) + "'");
                statement.executeUpdate("DELETE  from "+table+" where mail = '"+query.getAttributes().get(0)+ "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "False";
        }

    }

    /**
     * @param table tabella di riferimento nel database
     * @param id id di riferimento per l'autenticazione nel database
     * @return Ritorno al client in funzione se il return sia true o false
     */
    @Deprecated
    public boolean deleteQueryFromTable(String table, String id) {
        return false;
    }

    @Deprecated
    public String modifyQueryFromTable(String table, Query query) {
        return null;
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
