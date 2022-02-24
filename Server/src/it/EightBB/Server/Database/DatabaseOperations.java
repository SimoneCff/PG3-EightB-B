package it.EightBB.Server.Database;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DatabaseOperations {
    public List<String> getQuery(String table , String attributes);
    public String AddQuery(String table,Query query);
    public boolean deleteQueryFromTable (String table, String id);
    public boolean modifyQueryFromTable (String table, String id, String Attribute_N, String Attribute_V);
    public String checkInsideDB (String table,Query query);
    public DatabaseOperations getInstance();
}
