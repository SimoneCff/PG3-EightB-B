package it.EightBB.Server.Database;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * implementazione delle query per il databse
 * {@param Query} metodo per le query per il databse
 */
public class Query {
    private String table;
    private final ArrayList<String> attributes;
    private final ArrayList<String> values;

    public Query() {
        this.attributes = new ArrayList<String>();
        this.values = new ArrayList<String>();
    }

    public void setTable(String table){
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    public ArrayList<String> getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values.add(values);
    }

    public void setAttributes(String attributes) {
        this.attributes.add(attributes);
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }

}
