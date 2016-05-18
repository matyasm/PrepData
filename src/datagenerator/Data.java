package datagenerator;

import java.util.HashMap;

/**
 * Central data storage
 */
public class Data {
    private static HashMap settings = new HashMap();

    public static void set(String key, String value){
        settings.put(key,value);
    }
    public static String get(String key) {
        return (String) settings.get(key);
    }

}
