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
        if(decOldValue(key) == DBStatus.DB_NOT_FOUND) {
            return DBStatus.DB_NOT_FOUND;
        }

        keyToValue.put(key, value);
        int count = valueToCount.getOrDefault(value, 0)+1;
        valueToCount.put(value, count);
        return DBStatus.DB_GOOD;
    }

    public DBStatus dbUnset(String key) {
        if(decOldValue(key) == DBStatus.DB_NOT_FOUND) {
            return DBStatus.DB_NOT_FOUND;
        }

        keyToValue.remove(key);
        return DBStatus.DB_GOOD;
    }

    public String dbGet(String key) {
        if(!keyToValue.containsKey(key)) {
            throw new RuntimeException("key doesn't exists");
        } 

        return keyToValue.get(key);
    }

    public int dbNumEqualTo(String value) {
        if(!valueToCount.containsKey(value)) {
            throw new RuntimeException("value doesn't exists");
        }

        return valueToCount.get(value);
    }

    private DBStatus decOldValue(String key) {
        if(!keyToValue.containsKey(key)) {
            return DBStatus.DB_NOT_FOUND;
        }

        String val = keyToValue.get(key);
        int count = valueToCount.get(val);
        count--;
        if(count == 0) {
            valueToCount.remove(val);
        }
        return DBStatus.DB_GOOD;
    }

}
        