package it.EightBB.Server.Database;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public interface DatabaseOperations {
    public ArrayList<String> getQuery(String table ,String attributes);
    public boolean AddQuery(Connection db,String table, HashMap<String, String> data);
    public boolean deleteQueryFromTable (String table, String id);
    public boolean modifyQueryFromTable (String table, String id, String Attribute_N, String Attribute_V);
    public boolean checkInsideDB (Connection db, String table, ArrayList<String> query);
}
