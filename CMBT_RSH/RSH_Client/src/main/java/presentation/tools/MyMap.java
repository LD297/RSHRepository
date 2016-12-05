package presentation.tools;

import java.util.ArrayList;

/**
 * Created by john on 2016/12/5.
 */
public class MyMap {
    private ArrayList keys = new ArrayList();
    private ArrayList values = new ArrayList();

    public void put(Object key,Object value){
        keys.add(key);
        values.add(value);
    }

    public Object get(Object key){
        for(int i=0;i<keys.size();i++){
            if(keys.get(i)==key){
                return values.get(i);
            }
        }
        return null;
    }


}
