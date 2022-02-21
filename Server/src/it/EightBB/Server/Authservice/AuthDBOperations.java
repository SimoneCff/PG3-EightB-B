package it.EightBB.Server.Authservice;

import it.EightBB.Server.Database.DatabaseOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

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
    public ArrayList<String> getQuery(String table, String attributes) {
        return null;
    }

    @Override
    public boolean AddQuery(Connection db, String table, HashMap<String, String> data) {
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
    public boolean checkInsideDB (Connection db, String table, ArrayList<String> query){
        boolean ck = false;
        try {
            Statement qy =  db.createStatement();
            //Check query;
            String qr = "select * from" + table + "where"+query.get(3)+"="+query.get(4)+"AND"+query.get(5)+"="+query.get(6);
            ResultSet check = qy.executeQuery(qr);
            ck = check.getBoolean(1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ck;
    }

}
