package it.EightBB.Server.Database;

import java.sql.SQLException;

public interface DatabaseOperations {
    public String getQuery(String table , Query query) throws SQLException;
    public String AddQuery(String table,Query query) throws SQLException;
    public String modifyQueryFromTable(String table, Query query);
    public String checkInsideDB (String table,Query query);

}
