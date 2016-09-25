import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by Anirudh Gali on 9/1/16.
 */
public class ClassProperties {

    public static void main(String args[]) {
        String file = System.getProperty("user.dir") + "/src/StaticLimits.properties";
        Properties props = new Properties() {
            final private Map<Object, Object> linkMap = new LinkedHashMap<>();

            @Override
            public int size() {
                return linkMap.size();
            }

            @Override
            public synchronized Object put(Object key, Object value) {
                return linkMap.put(key, value);
            }

            @Override
            public synchronized Object get(Object key){
                return linkMap.get(key);
            }


            @Override
            public synchronized boolean containsKey(Object key){
                return linkMap.containsKey(key);
            }

            @Override
            public Set<Object> keySet(){
                return linkMap.keySet();
            }


        };

        try {
            props.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<Object> iterator = props.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
