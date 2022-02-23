package it.EightBB.Server.Database;

import java.util.List;

public class Query {
    private List<String> attributes;
    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public List<String> getAttributes() {
        return attributes;
    }

}
