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

    public List<String> AdaptQueryToString(Query query){
        List<String> result = null;
        //search max size
        int max= 0;
        if (query.getAttributes().size() > query.getValues().size()){
            max = query.getAttributes().size();
        } else max = query.getValues().size();
        //Convert
        for (int n =0; n<max; n++ ){
            if (n % 2 ==0){
                result.add(query.getAttributes().get(n));
            } else result.add(query.getValues().get(n));
        }
        return result;
    }
}
