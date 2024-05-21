package Utilities;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataStore extends BaseObjects {
    private static final ThreadLocal<Map<String, Object>> storeThread = ThreadLocal.withInitial(LinkedHashMap::new);

    public DataStore() {
        super();
    }

    private static Map<String, Object> getStore() {
        return storeThread.get();
    }

    public static void put(String key, Object value) {
        getStore().put(key, value);
    }

    public static Object get(String key) {
        Object value = getStore().get(key);
        if (value == null) {
            logMessage("INFO", key + " is not found in data store");
        }
        return value;
    }
}