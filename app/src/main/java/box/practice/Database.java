package box.practice;

import java.util.Map;
import java.util.HashMap;

public class Database {
    public static enum DBStatus {
        DB_GOOD, 
        DB_NOT_FOUND, 
        DB_ERROR,
    } 

    Map<String, String> keyToValue;
    Map<String, Integer> valueToCount;

    public Database () {
        keyToValue = new HashMap<>();
        valueToCount = new HashMap<>();
    }
    public DBStatus dbSet(String key, String value) {
        decOldValue(key);

        keyToValue.put(key, value);
        int count = valueToCount.getOrDefault(value, 0)+1;
        valueToCount.put(value, count);
        return DBStatus.DB_GOOD;
    }

    public DBStatus dbUnset(String key) {
        decOldValue(key);
        keyToValue.remove(key);
        return DBStatus.DB_GOOD;
    }

    public String dbGet(String key) {
        return keyToValue.getOrDefault(key, "");
    }

    public int dbNumEqualTo(String value) {
        if(!valueToCount.containsKey(value)) {
            return 0;
        }

        return valueToCount.get(value);
    }

    private void decOldValue(String key) {
        if(!keyToValue.containsKey(key)) {
            return;
        }

        String val = keyToValue.get(key);
        int count = valueToCount.get(val);
        count--;
        valueToCount.put(val, count);
        if(count == 0) {
            valueToCount.remove(val);
        }
        return;
    }

}
        