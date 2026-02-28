import java.util.Map;
import java.util.HashMap;

public class Database {
    public enum DBStatus {
        DB_GOOD, 
        DB_NOT_FOUND, 
        DB_ERROR,
    } 

    Map<String, Integer> keyToValue;
    Map<Integer, Integer> valueToCount;

    public Database () {
        keyToValue = new HashMap<>();
        valueToCount = new HashMap<>();
    }
    public DBStatus dbSet(String key, int value) {
        if(decOldValue(key) == DBStatus.DB_NOT_FOUND) {
            return DBStatus.DB_NOT_FOUND;
        }

        keyToValue.put(key, value);
        int count = valueToCount.getOrDefault(value, 0)+1;
        valueToCount.put(value, count);
        return DBStatus.DB_GOOD;
    }

    public DBStatus dbUnset(String key, int value) {
        return DBStatus.DB_GOOD;
    }

    public DBStatus dbGet(String key, int value) {
        return DBStatus.DB_GOOD;
    }

    public DBStatus dbNumEqualTo(String key, int value) {
        return DBStatus.DB_GOOD;
    }

    private DBStatus decOldValue(String key) {
        if(!keyToValue.containsKey(key)) {
            return DBStatus.DB_NOT_FOUND;
        }

        int val = keyToValue.get(key);
        int count = valueToCount.get(val);
        count--;
        if(count == 0) {
            valueToCount.remove(count);
        }
        return DBStatus.DB_GOOD;
    }

}
        