package it.EightBB.Server.Database;


import java.util.ArrayList;
import java.util.List;

public class QueryAdapter extends Query {
    Query q = new Query();

    public Query AdaptStringToQuery(ArrayList<String> s) {
        //Extractor
        //Add datas from temp to other
        for (int n = 0 ; n< s.size(); n++) {;
           if (n % 2 == 0){
              q.setValues(s.get(n));
           }else {
              q.setAttributes(s.get(n));
           }
        }

        //Setting Up String to the Query

        return q;
    }
}
