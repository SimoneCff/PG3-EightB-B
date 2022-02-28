package it.EightBB.Server.Database;


import java.util.ArrayList;
import java.util.List;

/**
 * adapter per fare le string nelle query per il database
 * {@param QueryAdapter} metodo per le implementazioni delle stringhe nelle query
 */
public class QueryAdapter extends Query {
    Query q = new Query();

    /**
     *
     * @param s parametro che descrive la stringa
     * @return visualizzazione della query cerata
     */
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
