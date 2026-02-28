public class Database {
    public enum DBStatus {
        DB_GOOD, 
        DB_NOT_FOUND, 
        DB_ERROR,
    } 
    public int dbSet(String key, int value) {
        return 1;
    }

    public int dbUnset(String key, int value) {
        return 1;
    }

    public int dbGet(String key, int value) {
        return 1;
    }

    public int dbNumEqualTo(String key, int value) {
        return 1;
    }

    private int decOldValue(String key) {
        return 1;
    }

}
