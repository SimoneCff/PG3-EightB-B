package it.EightBB.Server.Database;


import java.util.Arrays;
import java.util.List;

public class QueryAdapter extends Query {
    Query q = new Query();

    public Query AdaptStringToQuery(String s) {
        List<String> Data = null, Temp;
        //Extractor
        Temp = Arrays.asList(s.split(","));
        Temp.remove(0);
        //Add datas from temp to other
        for (int n = 0 ; n< Temp.size(); n=+2) {;
            Data.add(Temp.get(n));
            Temp.remove(n);
        }

        //Setting Up String to the Query
        q.setAttributes(Temp);
        q.setValues(Data);

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
