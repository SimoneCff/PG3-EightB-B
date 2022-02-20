package it.EightBB.Server.Authservice;

import it.EightBB.Server.Database.DatabaseOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AuthDBOperations  implements DatabaseOperations {
    @Override

    public boolean checkInsideDB (Connection db, String table, ArrayList<String> query){
        boolean ck = false;
        try {
            Statement qy = db.createStatement();
            //Check query;
            String qr = "select * from" + table + "where"+query.get(3)+"="+query.get(4)+"AND"+query.get(5)+"="+query.get(6);
            ResultSet check = qy.executeQuery(qr);
            ck = check.getBoolean(1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ck;
    }

    @Override
    public boolean AddQuery(Connection db,String table, HashMap<String, String> data) {
        return false;
    }

}
